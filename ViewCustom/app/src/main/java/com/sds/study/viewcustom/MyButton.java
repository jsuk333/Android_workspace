package com.sds.study.viewcustom;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

/**
 *
 */
//이 클래스의 사용을 xml에서 할지 순수 자바코드에서 할지 모르기 때문에
    //생성자 오버로딩으로 정의 했따.
public class MyButton extends Button{
    String TAG;
    public MyButton(Context context) {
        super(context);//부모인 버튼의 생성자 호출
        TAG=this.getClass().getName();
        Log.d(TAG,"인수 1개짜리 생성자 호출");
        this.setText("내 버튼");
    }
    //xml로 메모리에 올릴때 반드시 AttributeSet을 인수로 가지는 생성자를 가져야 한다.
    public MyButton(Context context, AttributeSet attrs) {
        super(context,attrs);//부모인 버튼의 생성자 호출
        TAG=this.getClass().getName();
        Log.d(TAG,"인수 2개짜리 생성자 호출");
        this.setText("내 버튼");
    }
}
