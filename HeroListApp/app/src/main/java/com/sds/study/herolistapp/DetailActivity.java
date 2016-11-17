package com.sds.study.herolistapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by efro2 on 2016-11-10.
 */

public class DetailActivity extends Activity implements ViewGroup.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=this.getIntent();
        setContentView(R.layout.detail_layout);
        TextView txt_msg=(TextView) findViewById(R.id.txt_msg);
        txt_msg.setText("내가 선택한 영웅은 "+intent.getStringExtra("data")+"이다.");
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.finish();
    }
}
