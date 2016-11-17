package com.sds.study.graphicapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * Created by efro2 on 2016-11-16.
 */

public class GameActivity extends Activity {
    String TAG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG=this.getClass().getName();
        GameView gameView=new GameView(this);
        setContentView(gameView);
    }


}
