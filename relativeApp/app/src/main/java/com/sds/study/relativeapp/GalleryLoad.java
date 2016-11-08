package com.sds.study.relativeapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/**
 * Created by efro2 on 2016-11-08.
 */

public class GalleryLoad extends Activity implements ViewGroup.OnClickListener{
    Button bt;
    LinearLayout scrollView;
    int[] photo={R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery3);
        bt=(Button)findViewById(R.id.bt_load);
        bt.setOnClickListener(this);
        scrollView=(LinearLayout) findViewById(R.id.scroll);

    }

    @Override
    public void onClick(View view) {
        for(int i=0;i<photo.length;i++) {
            ImageView addimg=new ImageView(this);
            addimg.setImageResource(photo[i]);
            ViewGroup.LayoutParams params=null;
            params=new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            addimg.setLayoutParams(params);
            addimg.setAdjustViewBounds(true);
            scrollView.addView(addimg);
        }
    }
}
