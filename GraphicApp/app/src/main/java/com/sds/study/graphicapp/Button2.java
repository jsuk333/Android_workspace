package com.sds.study.graphicapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by efro2 on 2016-11-16.
 */

public class Button2 extends GameObject {
    public Button2(int x, int y, int width, int height, int color, Bitmap bitmap, ObjectManager objectManager) {
        super(x, y, width, height, color, bitmap, objectManager);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Canvas can) {
        can.drawBitmap(bitmap,x,y,null);
    }
}
