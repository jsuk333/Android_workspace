package com.sds.study.viewcustom;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout;//리니어 정의
    MyButton mybt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        layout=new LinearLayout(this);
        ViewGroup.LayoutParams layoutParams=null;
        layoutParams=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        layout.setLayoutParams(layoutParams);
        layout.setBackgroundColor(Color.YELLOW);
        //버튼 정의
        mybt=new MyButton(this);
        ViewGroup.LayoutParams btParams=null;
        btParams=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        mybt.setLayoutParams(btParams);
        layout.addView(mybt);
        setContentView(layout);
    }

}
