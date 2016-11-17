package com.sds.study.threadapp;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by efro2 on 2016-11-15.
 */

public class GalleryActivity extends Activity {
    String TAG;
    LinearLayout layout_img;
    static final int REQUEST_READ = 1;
    GalleryView galleryView;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getClass().getName();
        setContentView(R.layout.gallery_activity_layout);
        layout_img = (LinearLayout) findViewById(R.id.layout_img);
        permission();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                galleryView.count++;
                if (galleryView.count == galleryView.files.length) {
                    galleryView.count = 0;
                }
                galleryView.invalidate();
            }
        };


    }

    public void play(View view) {
        Thread thread = new Thread() {
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

    public void prev(View view) {
        if (galleryView.count > 0) {
            galleryView.count--;
            galleryView.invalidate();
        }
    }

    public void next(View view) {
        if (galleryView.count < galleryView.files.length - 1) {
            galleryView.count++;
            galleryView.invalidate();
        }
    }

    public void permission() {
        int readPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (readPermission == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE
            }, REQUEST_READ);
        } else {
            setImg();
        }
    }

    public void setImg() {
        galleryView = new GalleryView(this);
        Log.d(TAG, "GalleryActivity 생성");
        layout_img.addView(galleryView);
        galleryView.invalidate();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_READ:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    setImg();
                }
        }
    }
}
