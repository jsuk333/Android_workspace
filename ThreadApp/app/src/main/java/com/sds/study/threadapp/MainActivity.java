package com.sds.study.threadapp;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Runnable{
    String TAG;
    int count;
    TextView txt_count;
    //안드로이드 에서는 개발자가 정의한 쓰레드 즉 메인 쓰레드
    //아닌자가 UI를 제어 할 수 없다.
    //해결책: Handler에 의한 간접제어방식을 허용한다.
    //개발자가 정의한 쓰레드로 UI를 제어하고 싶다면 Handler에 예약하면된다.
    //
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TAG=getClass().getName();
        setContentView(R.layout.activity_main);
        txt_count=(TextView)findViewById(R.id.txt_count);
        handler=new Handler(){
            //핸들러에게 다른 객체가 업무처리를 부탁하면,
            //이 함수가 동작한다.
            //우리의 경우 UI처리를 여기서 하면된다.
            public void handleMessage(Message msg) {
                    txt_count.setText(Integer.toString(count++));
            }
        };
    }
    public void btnClick(View view){
        Thread thread=new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
               // Log.d(TAG, Integer.toString(count++));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.sendEmptyMessage(0);//이 메서드에 의해 위의 HandleMessage가 작동한다.
        }
    }
}
