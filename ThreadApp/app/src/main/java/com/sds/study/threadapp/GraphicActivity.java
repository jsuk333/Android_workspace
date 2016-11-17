package com.sds.study.threadapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by efro2 on 2016-11-15.
 */

public class GraphicActivity extends Activity implements Runnable, View.OnClickListener{
    MyView myView;
    Handler handler;
    Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myView=new MyView(this);
        LinearLayout linearLayout=new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        Button bt=new Button(this);
        bt.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        bt.setText("동작하기");
        bt.setOnClickListener(this);
        linearLayout.addView(bt);
        linearLayout.addView(myView);
        setContentView(linearLayout);
        handler=new Handler(){
            //핸들러의 메서드는 메인 쓰레드에 의해 동작한다.
            //따라서 UI제어가 가능하다.
            public void handleMessage(Message msg) {
                myView.x+=5;
                myView.y+=5;
                myView.invalidate();
            }
        };
    }

    @Override
    public void onClick(View view) {
        thread=new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.sendEmptyMessage(0);
        }
    }
}
