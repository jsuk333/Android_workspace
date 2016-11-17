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
public class ActivityA extends Activity {
    EditText recive_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitya_layout);
    }
    public void btnClick(View view){
        //안드로이드의 4대 컴포넌트는 시스템이 관리하므로
        //생성이 아니라 요청을 해야 한다.
        Intent intent=new Intent(this,ActivityB.class);
        EditText send_msg=(EditText) findViewById(R.id.send_msg);
        recive_msg=(EditText) findViewById(R.id.recive_msg);

        intent.putExtra("data",send_msg.getText().toString());
        //다른 액티비티 호출시 그 결과를 다시 받아올 경우엔
        //startActivity(intent);
        startActivityForResult(intent,2002);
    }
    //호출한 activity가 응답할 경우 아래의 메서드가 호출!!
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==2002&&requestCode==Activity.RESULT_OK){
            String result=data.getStringExtra("data");
            recive_msg.setText(result);
        }
    }
}
