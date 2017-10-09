package com.example.austinlee.radtrads;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class Vid extends AppCompatActivity {

    int charNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vid);

        VideoView videoView = (VideoView)findViewById(R.id.videoView);

        charNum = getIntent().getIntExtra("num", 0);

        if(charNum == 1){
            videoView.setVideoPath("android.resource://"+ getPackageName()+"/"+R.raw.onev);
            videoView.start();
        }
        if(charNum == 2){
            videoView.setVideoPath("android.resource://"+ getPackageName()+"/"+R.raw.twov);
            videoView.start();
        }
        if(charNum == 3){
            videoView.setVideoPath("android.resource://"+ getPackageName()+"/"+R.raw.threev);
            videoView.start();
        }
        if(charNum == 4){
            videoView.setVideoPath("android.resource://"+ getPackageName()+"/"+R.raw.fourv);
            videoView.start();
        }
        if(charNum == 5){
            videoView.setVideoPath("android.resource://"+ getPackageName()+"/"+R.raw.fivev);
            videoView.start();
        }
    }
}
