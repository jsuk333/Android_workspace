package com.sds.study.musicapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 리스트에 보여줄 복합위젯을 정의 한다.
 * 마치 하나의 위젯처럼 사용가능
 */

public class MusicItem extends LinearLayout implements View.OnClickListener {
    Music music;
    boolean flag = true;
    ImageView img;
    Context context;
    TextView txt_title;
    TextView txt_artist;

    public MusicItem(Context context, Music music) {
        super(context);
        this.music = music;
        this.context = context;
        init(context);
    }

    public MusicItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        //이 클래스가 참조할 xml을 인플레이션 시키자
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.itme_music, this);
        //각 뷰에 알맞는 데이터 대입하기
        txt_title = ((TextView) findViewById(R.id.txt_title));
        txt_title.setText(music.getTitle());
        txt_artist = ((TextView) findViewById(R.id.txt_artist));
        txt_artist.setText(music.getTitle());
        img = ((ImageView) findViewById(R.id.img));
        img.setImageResource(R.drawable.play);
        this.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       /* flag=!flag;
        if(!flag) {
            img.setImageResource(R.drawable.stop);
        }else{
            img.setImageResource(R.drawable.play);
        }*/
        Intent intent = new Intent(context, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("title",music.getTitle());
        bundle.putString("artist",music.getArtist());
        bundle.putString("filename",music.getFilename());
        intent.putExtra("bundle", bundle);
        context.startActivity(intent);
    }
}
