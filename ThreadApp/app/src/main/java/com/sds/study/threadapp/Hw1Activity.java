package com.sds.study.threadapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by efro2 on 2016-11-15.
 */

public class Hw1Activity extends Activity implements View.OnTouchListener,Runnable{
    LinearLayout layout;
    Handler handler;
    MyView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hw1);
        layout=(LinearLayout)findViewById(R.id.layout);
        layout.setOnTouchListener(this);
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                myView.y+=1;
                myView.invalidate();
            }
        };

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x=motionEvent.getX();
        float y=motionEvent.getY();
        myView=new MyView(this);
        myView.x=(int)x;
        myView.y=(int)y;
        Thread thread=new Thread(this);
        thread.start();
        return true;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            handler.sendEmptyMessage(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
