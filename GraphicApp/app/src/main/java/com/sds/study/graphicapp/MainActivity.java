package com.sds.study.graphicapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Bitmap[] bitmaps;
    String TAG;
    MyView myView;
    Handler handler;
    int current=0;
    final static int REQUEST_READ_PERMISSION=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG=this.getClass().getName();
        setContentView(R.layout.activity_main);
        myView=(MyView)findViewById(R.id.myView);
        permissionCheck();
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                //동생쓰레드 의 요청 처리
                current++;
                if(current==bitmaps.length){
                    current=0;
                }
                showImage();
            }
        };
    }
    //갤러리에 필요한 초기화 작업을 여기서 하자....
    public void init(){
        File dir=new File(Environment.getExternalStorageDirectory(),"iot_gallery");
        File[] files=dir.listFiles();
        bitmaps=new Bitmap[files.length];
        for(int i=0;i<files.length;i++){
            bitmaps[i]=BitmapFactory.decodeFile(files[i].getAbsolutePath());
            Log.d(TAG,files[i]+"경로로 생성된 객체는"+bitmaps[i]);
        }
        //유저가 알아채기도 전에 비트맵 넘겨주고 다시 그리기
        myView.setBitmap(bitmaps[current]);
        myView.invalidate();
    }
    public void permissionCheck(){
        int readPermission=ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if(readPermission== PackageManager.PERMISSION_DENIED){
            //권한을 물어보자
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE
            },REQUEST_READ_PERMISSION);
        }else{
            init();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_READ_PERMISSION:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    init();
                }
                break;
        }
    }
    public void next(View view){
        if(current<bitmaps.length-1) {
            current++;
        }
       showImage();
    }
    public void prev(View view){
        if(current>0) {
            current--;
        }
       showImage();
    }
    public void showImage(){
            myView.setBitmap(bitmaps[current]);
            myView.invalidate();
    }
    public void auto(View view){
        Thread thread=new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(300);
                        handler.sendEmptyMessage(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }


}
