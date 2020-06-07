package com.example.test1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class VideoList extends ArrayAdapter<Video> {

    private Activity context;
    private List<Video> videoList;

    public VideoList(Activity context, List<Video> videoList){
        super(context, R.layout.list_layout, videoList);
        this.context = context;
        this.videoList = videoList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewUri = (TextView) listViewItem.findViewById(R.id.textViewUri);

        Video video = videoList.get(position);

        textViewName.setText(video.getVideoId());
        textViewUri.setText((video.getVideoUri()));

        return listViewItem;
        //return super.getView(position, convertView, parent);
    }
}
