package com.sds.study.graphicapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import java.io.File;

/**
 * 개발자가 주도하여 뷰에 그림을 그려야 한다.
 * 따라서 onDraw메서드 정의해야 한다.
 * OnDraw는 java SE의 Paint 메서드와 같다
 */

public class MyView extends View{
    private Bitmap bitmap;
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (bitmap!=null) {
            canvas.drawBitmap(bitmap, 0, 0, null);
        }
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
