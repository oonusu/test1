package com.example.test1;

public class Video {

    String videoId;
    String videoUri;
    double videoLat, videoLng;

    public Video() {

    }

    public Video(String videoId, String videoUri, double videoLtd, double videoLng) {
        this.videoId = videoId;
        this.videoUri = videoUri;
        this.videoLat = videoLtd;
        this.videoLng = videoLng;
    }

    public String getVideoId() {
        return videoId;
    }

    public String getVideoUri() {
        return videoUri;
    }

    public double getVideoLtd() {
        return videoLat;
    }

    public double getVideoLng() {
        return videoLng;
    }
}
