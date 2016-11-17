package com.sds.study.musicapp;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.ListView;

import java.io.File;
import java.io.IOException;

/**
 * Created by efro2 on 2016-11-11.
 */

public class MusicListActivity extends Activity {
    String TAG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG=this.getClass().getName();
        setContentView(R.layout.music_list);
        //리스트 뷰와 어댑터 연결
        ListView listView=(ListView)findViewById(R.id.listView);
        MusicAdapter adapter=new MusicAdapter(this);
        listView.setAdapter(adapter);
    }
}
/* //안드로이드의 일반 자원을 두는 곳중 raw,asset이라는 디렉토리가 있는데
        //raw안의 데이터는 R.java에 등록되어 상수 취급되고
        //asset은 그냥 일반 디렉토리로 가능하다.
       //스마트폰의 external storage에 놓아둔, 파일을 접근해보자
        File dir=Environment.getExternalStorageDirectory();*/