package com.project.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class exthree extends AppCompatActivity {

    VideoView videoView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exthree);


        videoView = findViewById(R.id.videothree);
        String videpath = "android.resource://"+getPackageName()+"/"+R.raw.squat;
        Uri uri = Uri.parse(videpath);

        videoView.setVideoURI(uri);



        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        videoView.start();
    }
}