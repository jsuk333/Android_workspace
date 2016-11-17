package com.sds.study.graphicapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;

/**
 * Created by efro2 on 2016-11-16.
 */

public class Bullet extends GameObject {
    String TAG;
    Context context;
    public Bullet(int x, int y, int width, int height, int color,Bitmap bitmap, ObjectManager objectManager, Context context) {
        super(x, y, width, height, color,bitmap,objectManager);
        TAG=this.getClass().getName();
        rectF = new RectF(x, y, x+width, y+height);
        paint = new Paint();
        paint.setColor(color);
        velX = 2;
        this.context=context;

    }

    @Override
    public void tick() {
        x += velX;
        Log.d(TAG,"x : "+x+"y : "+y+"width : "+width+"height :"+height);
        rectF.set(x,y,x+width,y+height);
    }
    @Override
    public void render(Canvas can) {
       // can.drawOval(rectF, paint);
        Bitmap bitmap=BitmapFactory.decodeResource(context.getResources(),R.drawable.bullet);
        can.drawBitmap(bitmap,x,y,paint);
    }
}
