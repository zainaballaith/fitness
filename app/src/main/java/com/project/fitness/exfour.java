package com.project.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class exfour extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exfour);


        videoView = findViewById(R.id.videofour);
        String videpath = "android.resource://"+getPackageName()+"/"+R.raw.dumbbell;
        Uri uri = Uri.parse(videpath);

        videoView.setVideoURI(uri);



        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        videoView.start();
    }
}