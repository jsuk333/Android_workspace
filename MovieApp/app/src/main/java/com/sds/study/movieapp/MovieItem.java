package com.sds.study.movieapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * 여러위젯이 조합된 복합위젯을 정의 한다.
 */

public class MovieItem extends LinearLayout {
    Context context;
    Movie movie;
    public MovieItem(Context context) {
        super(context);
        this.context=context;
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.movie_item,this);
        //xml인풀레이션 시키자
    }

    public void setData(Movie movie){
        this.movie=movie;
        TextView txt_title=(TextView)findViewById(R.id.txt_title);
        TextView txt_regdate=(TextView)findViewById(R.id.txt_regdate);
        ImageView img=(ImageView)findViewById(R.id.img);
        txt_title.setText(movie.getTitle());
        txt_regdate.setText(movie.getRegdate());
        //이미지 대입 고민
        try {
            InputStream is=context.getAssets().open(movie.getImg());
            Bitmap bitmap=BitmapFactory.decodeStream(is);
            img.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
