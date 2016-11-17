package com.sds.study.threadapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 자바의 그래픽 처리와 마찬가지로 안드로이드에서 그래픽의 주체는 컴포넌트 즉 뷰이다.
 따라서 개발자가 그래픽을 재정의 하려면 뷰를 상속받아 뷰가 보유한 메서드 onDraw메서드를
 재정의 하면 된다..
 */

public class MyView extends View {
    Paint paint;
    int x=0;
    int y=0;
    int left=100;
    int bottom=100;
    Context context;
    public MyView(Context context) {
        super(context);
        this.context=context;

        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public void init(){
        paint=new Paint();
        this.setBackgroundColor(Color.YELLOW);
        paint.setColor(Color.RED);

    }
    //캔버스가 우리가 알던 그 캔버스 아님 자바의 그래픽스의 역할과 비슷하다.
    protected void onDraw(Canvas canvas) {
        /*canvas.drawOval(0,0,100,100,paint);*/
        canvas.drawOval(new RectF(x,y,left+x,bottom+y),paint);
    }


}
