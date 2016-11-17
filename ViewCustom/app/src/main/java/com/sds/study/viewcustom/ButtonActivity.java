package com.sds.study.viewcustom;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * 안드로이드에서 위젯을 생성하는 모든 방법을 다 동원해보자
 */

public class ButtonActivity extends Activity {
    LinearLayout layout_insert;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_layout);
        layout_insert=(LinearLayout)findViewById(R.id.layout_insert);
        bt=new Button(this);
        ViewGroup.LayoutParams params_bt=null;
        params_bt=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        bt.setLayoutParams(params_bt);
        bt.setText("자바");
        layout_insert.addView(bt);
    }
}
