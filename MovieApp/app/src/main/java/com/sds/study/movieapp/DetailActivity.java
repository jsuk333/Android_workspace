package com.sds.study.movieapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * 동영상이 재생되도록 한다.
 * 안드로이드에서 영상 재생은 VideoView로 재생한다.
 */

public class DetailActivity extends Activity {
    VideoView videoView;
    MediaController mediaController;
    String TAG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG=this.getClass().getName();
        setContentView(R.layout.detail_layout);
        TextView txt_filename=(TextView)findViewById(R.id.txt_filename);
        videoView=(VideoView)findViewById(R.id.videoView);
        mediaController=new MediaController(this);
        Intent intent=this.getIntent();
        Movie dto=intent.getParcelableExtra("dto");
/*        videoView.setMediaController(mediaController);
        videoView.setVideoPath(filename);
        videoView.start();*/
        txt_filename.setText(dto.getTitle());
    }
    public void play(View view){
        videoView.start();
    }
    public void pause(View view){
        videoView.pause();
    }
    public void stop(View view){
        videoView.seekTo(0);
        videoView.pause();
    }
}
