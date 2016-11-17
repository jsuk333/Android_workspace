package com.sds.study.graphicapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by efro2 on 2016-11-16.
 */

public class GameView extends View implements  Runnable{
    String TAG;
    Paint paint;
    RectF rect;
    Thread thread;/*게임 운영 엔진*/
    ObjectManager objectManager=new ObjectManager();
    Handler handler;//쓰레드가 유아이를 제어 할 수 있도록
    int[] colArr={
            Color.RED,
            Color.BLACK,
            Color.CYAN,
            Color.BLUE,
            Color.GREEN
    };
    Bitmap[] bitmaps=new Bitmap[3];
    Context context;
    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GameView(Context context) {
        super(context);
        this.context=context;
        TAG = this.getClass().getName();
        this.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        this.setBackgroundColor(Color.YELLOW);
        paint = new Paint();
        paint.setColor(Color.RED);

        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inSampleSize=4;
        BitmapFactory.Options options2=new BitmapFactory.Options();
        options2.inSampleSize=2;
       // for(int i=0;i<bitmaps.length;i++){
            Bitmap temp=BitmapFactory.decodeResource(context.getResources(),R.drawable.bullet,options);
            bitmaps[0]=Bitmap.createBitmap(temp,0,0,temp.getWidth(), temp.getHeight());
        //}
        //총알 발사 버튼 등장
        Bitmap button_temp=BitmapFactory.decodeResource(context.getResources(),R.drawable.button);
        bitmaps[1]=Bitmap.createBitmap(button_temp,0,0,100,100 );
        init();

        Button2 button=new Button2(700, 350, 100, 100, colArr[1],bitmaps[1], objectManager);
        objectManager.addObject(button);
    }
    //게임 초기화
    public void init(){
        handler=new Handler(){//메인 쓰레드에 의해 아래의 메서드가 호출
            @Override
            public void handleMessage(Message msg) {
                objectManager.tick();
               invalidate();
            }
        };
        thread =new Thread(this);
        thread.start();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        objectManager.render(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //게임 오브젝트 생성하여 동작 시키자
        int width=50;
        int height=50;
        int y=(int) event.getY()-height/2;
        int  x=(int)event.getX()-width/2;
        int color=(int)Math.floor(Math.random()*(colArr.length));
        Bullet bullet = new Bullet(x, y, width, height,colArr[color],bitmaps[0],objectManager,context);
        objectManager.addObject(bullet);
        return true;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //모든 게임 오브젝트들의 틱 렌더 호출
            handler.sendEmptyMessage(0);
        }
    }
}
