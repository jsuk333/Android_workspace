package com.sds.study.adapterviewtest.data;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.sds.study.adapterviewtest.R;

/**
 * Created by efro2 on 2016-11-10.
 */

public class ActivityB extends Activity {
    EditText send_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityb_layout);
        Intent intent=getIntent();
        EditText recive_msg=(EditText)findViewById(R.id.recive_msg);
        send_msg=(EditText)findViewById(R.id.send_msg);
        recive_msg.setText(intent.getStringExtra("data"));

    }
    public void btnClick(View view){
        Intent intent =new Intent();
        intent.putExtra("data",send_msg.getText().toString());
        setResult(2002,intent);
    }

}
