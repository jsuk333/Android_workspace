package com.sds.study.activitystudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by efro2 on 2016-11-09.
 */

public class ResultActivity extends Activity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);
        intent=this.getIntent();
        String name=intent.getStringExtra("name");
        TextView answer=(TextView)findViewById(R.id.answer);
        answer.setText("선택한 영웅은"+name+"입니다.");
    }
    public void btnClick(View view){
        this.finish();
    }
}
