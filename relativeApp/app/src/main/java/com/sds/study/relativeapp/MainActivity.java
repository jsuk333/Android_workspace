package com.sds.study.relativeapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ViewGroup.OnClickListener {
    LinearLayout linearLayout;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.introduction);
        //순수한 자바코드 만으로, 화면을 디자인 할 수는 있다!!!
        //때에 따라서는 자바코드로 작성해야하는 경우도 있다.
        linearLayout=new LinearLayout(this);
        //파라미터 객체 생성
        LinearLayout.LayoutParams params=null;
        params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(params);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setBackgroundColor(Color.YELLOW);
        //버튼 생성하여 레이아웃 객체에 붙이기
        button=new Button(this);
        ViewGroup.LayoutParams bt_params=null;
        bt_params=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(bt_params);
        button.setText("나 버튼");
        //리스너와 연결
        button.setOnClickListener(this);
        linearLayout.addView(button);
        //화면에 뷰 보여주기
        setContentView(linearLayout);

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this,"나 눌렀어?",Toast.LENGTH_SHORT).show();
    }
}
