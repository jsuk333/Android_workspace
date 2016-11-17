package com.sds.study.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;

/**
 * Created by efro2 on 2016-11-11.
 */

public class DetailActivity extends Activity implements View.OnClickListener{
    String filename;
    MediaPlayer mediaPlayer;
    ImageView bt_play;
    ImageView bt_stop;
    Uri uri;
    String TAG;
    AssetFileDescriptor afd;
    FileDescriptor fd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_layout);
        this.TAG = this.getClass().getName();
        Intent intent = this.getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        TextView txt_title = (TextView) findViewById(R.id.txt_title);
        TextView txt_artist = (TextView) findViewById(R.id.txt_artist);
        bt_play = (ImageView) findViewById(R.id.bt_play);
        bt_stop = (ImageView) findViewById(R.id.bt_stop);
        bt_play.setOnClickListener(this);
        bt_stop.setOnClickListener(this);
        txt_title.setText(bundle.getString("title"));
        txt_artist.setText(bundle.getString("artist"));
        filename = bundle.getString("filename");

        AssetManager manager = this.getAssets();

        try {
            afd = manager.openFd(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        @Override
    public void onClick(View view) {
        if(view==bt_play){
            if(mediaPlayer==null){
                mediaPlayer=new MediaPlayer();
                try {
                    Log.d(TAG,"재생 준비");
                    mediaPlayer.setDataSource(afd);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    Log.d(TAG,"재생 시작");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else if(view==bt_stop){
            if(mediaPlayer!=null){
                mediaPlayer.stop();
                mediaPlayer=null;
            }
        }
    }
}
