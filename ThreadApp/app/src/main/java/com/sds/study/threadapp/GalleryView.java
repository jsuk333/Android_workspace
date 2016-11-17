package com.sds.study.threadapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import android.os.Environment;
import android.util.AttributeSet;

import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by efro2 on 2016-11-15.
 */

public class GalleryView extends View {
    Paint paint;
    String TAG;
    Bitmap bitmap;
    Context context;
    int count = 0;
    File[] files;

    public GalleryView(Context context) {
        super(context);
        TAG = getClass().getName();
        init(context);
    }

    public GalleryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {

        paint = new Paint();
        File dir = Environment.getExternalStorageDirectory();
        File iot_gallery = new File(dir, "iot_gallery");
        files = iot_gallery.listFiles();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        try {
            InputStream is = new FileInputStream(files[count]);
            bitmap = BitmapFactory.decodeStream(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        canvas.drawBitmap(bitmap, 0, 0, paint);
        //canvas.drawOval(new RectF(0,0,100,100),paint);
    }
}
