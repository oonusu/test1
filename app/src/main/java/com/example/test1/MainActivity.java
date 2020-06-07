package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity  {

    private Button btn_upload,btn_view1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_upload = findViewById(R.id.btn_upload);//리뷰등록 버튼
        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //메인->리뷰등록 UploadActivity로 이동
                Intent intent = new Intent(MainActivity.this, UploadActivity.class);
                startActivity(intent);
            }
        });

        btn_view1 = findViewById(R.id.btn_view1);//리뷰보기 버튼
        btn_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //최근 영상 자동 재생을 위한 PlayActivity로 이동
                Intent intent = new Intent(MainActivity.this, PlayActivity.class);
                startActivity(intent);
            }
        });
    }


}
