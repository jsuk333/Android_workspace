package com.sds.study.graphicapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * 화면에 등장할 객체
 * 자기만의 고유한 변수를 가지는 각체
 */

public abstract class GameObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int velX;
    protected int velY;
    protected int gravity;
    protected int color;
    protected RectF rectF;
    protected Paint paint;
    protected ObjectManager objectManager;
    protected Bitmap bitmap;
    public GameObject(int x, int y, int width, int height, int color,Bitmap bitmap, ObjectManager objectManager) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.objectManager = objectManager;
       this.bitmap=bitmap;
    }

    /*이 클래스를 상속받는 객체가 어떤 행도을 할지 알 수 없으므로 추상 메서드로 정의 해놓자*/
    public abstract void tick();/*물리적 변화*/

    public abstract void render(Canvas can);/*화면에 어떻게 그려질지*/

}
