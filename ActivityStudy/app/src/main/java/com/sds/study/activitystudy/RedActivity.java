package com.sds.study.activitystudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by efro2 on 2016-11-09.
 */

public class RedActivity extends Activity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.red_layout);
        //인텐트에 심어진 데이터를 끄집어 내기
        intent=getIntent();
        String data=intent.getStringExtra("data");
        TextView txt=(TextView)findViewById(R.id.txt);
        txt.setText(data);
    }
    public void btnClick(View view){
        /*Intent intent=new Intent(this,MainActivity.class);
        this.startActivity(intent);*/
        this.finish();
    }
}
