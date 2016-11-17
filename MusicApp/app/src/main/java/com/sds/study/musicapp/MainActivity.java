/*
package com.sds.study.musicapp;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    String TAG;
    //음악 동영상등의 미디어를 재생하려면 Media Player라는 객체가 필요함
    MediaPlayer mediaPlayer;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG=this.getClass().getName();
        setContentView(R.layout.activity_main);


    }
    public void btnClick(View view){

        if(view.getId()==R.id.bt_play) {

            Log.d(TAG,"재생합니다.");
            //Uri란 자원의 위치 정보를 가진 객체로서 특정자원을 접근하려면 정해진 형식을 알아야 한다.
            //EX) 인터넷 상의 자원 url: http://서버주소/디렉토리
            Uri uri = Uri.parse("android.resource://com.sds.study.musicapp/asset/" + R.raw.tt);
            //음원을 결정하자
            try {
                if(mediaPlayer==null) {
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(this, uri);
                    mediaPlayer.prepare();
                }

                mediaPlayer.start();//음악재생
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(view.getId()==R.id.bt_pause){
            if(mediaPlayer!=null||mediaPlayer.isPlaying()) {
                Log.d(TAG, "잠시멈춤니다.");
                mediaPlayer.pause();
            }
        }else if(view.getId()==R.id.bt_stop){
            if(mediaPlayer.isPlaying()) {
                Log.d(TAG, "재생종료.");
                mediaPlayer.stop();
                mediaPlayer=null;
            }
        }
    }

}
*/
