package com.example.test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

     private ImageButton ibtn_view2;//목록의 리뷰영상 재생버튼
     private TextView tv_id, tv_date;
     private ImageView iv_profile;

    ListView listViewVideos;

    List<Video> videoList;
    DatabaseReference databaseVideos;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //ibtn_view2 = findViewById(R.id.ibtn_view2);

        listViewVideos = (ListView) findViewById(R.id.listViewVideos);

        videoList = new ArrayList<>();

        ibtn_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, PlayActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseVideos.addValueEventListener((new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                videoList.clear();

                for(DataSnapshot videoSnapshot : dataSnapshot.getChildren()) {
                    Video video = videoSnapshot.getValue(Video.class);

                    videoList.add(video);
                }

                VideoList adapter = new VideoList(SearchActivity.this, videoList);
                listViewVideos.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }));
    }
}
