package com.sds.study.relativeapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by efro2 on 2016-11-08.
 */
//앱이 가동되면 무조건 실행되는 클래스
public class LogInActivity extends Activity implements ViewGroup.OnClickListener{
    LinearLayout wrapper;
    LinearLayout wrapper_id;
    TextView title;
    EditText input_id;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //렙퍼 정의
        wrapper=new LinearLayout(this);
        LinearLayout.LayoutParams param_wrapper=null;
        param_wrapper=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        wrapper.setOrientation(LinearLayout.VERTICAL);
        wrapper.setLayoutParams(param_wrapper);
        wrapper.setPadding(40,40,40,40);
        //textview 정의
        title=new TextView(this);
        ViewGroup.LayoutParams params_title=null;
        params_title=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        title.setLayoutParams(params_title);
        title.setGravity(Gravity.CENTER_HORIZONTAL);
        title.setTextSize(30);
        title.setText("로그인");
        //input wrapper정의
        wrapper_id=new LinearLayout(this);
        LinearLayout.LayoutParams param_wrapper_id=null;
        param_wrapper_id=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        wrapper_id.setOrientation(LinearLayout.HORIZONTAL);
        wrapper_id.setLayoutParams(param_wrapper);
        wrapper_id.setBackgroundColor(Color.BLUE);
        //input 정의
        input_id=new EditText(this);
        LinearLayout.LayoutParams params_input_id=null;
        params_input_id=new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,3);
        input_id.setLayoutParams(params_input_id);
        input_id.setBackgroundColor(Color.CYAN);
        input_id.setTextSize(20);

        //Button 정의
        bt=new Button(this);
        LinearLayout.LayoutParams params_bt_id=null;
        params_bt_id=new LinearLayout.LayoutParams(0,
                ViewGroup.LayoutParams.WRAP_CONTENT,1);
        bt.setText("버튼");
        bt.setTextSize(20);
        bt.setOnClickListener(this);
        //붙이기
        wrapper.addView(title);
        wrapper_id.addView(input_id);
        wrapper_id.addView(bt);
        wrapper.addView(wrapper_id);
        setContentView(wrapper);
    }

    @Override
    public void onClick(View view) {
       Toast.makeText(this,input_id.getText(),Toast.LENGTH_SHORT).show();
    }
}
