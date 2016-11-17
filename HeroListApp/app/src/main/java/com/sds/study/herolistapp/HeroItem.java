package com.sds.study.herolistapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
    추후 재사용성을 고려하여, 여러 위젯이 조합도니 형태의 즉 새로운 형태의 복합형
 위젯을 정의해 보자 나만의 위젯을 정의 해보자.
 */

public class HeroItem extends LinearLayout{
    private TextView txt_name;
    private TextView txt_phone;
    private ImageView img;
    public HeroItem(Context context,Hero hero) {
        super(context);
        //Xml을 여기서 infation시키자
        LayoutInflater inflater=null;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.hero_item,this);
        txt_name=(TextView)this.findViewById(R.id.txt_name);
        txt_phone=(TextView)this.findViewById(R.id.txt_phone);
        img=(ImageView) this.findViewById(R.id.img);
        txt_name.setText(hero.getName());
        txt_phone.setText(hero.getPhone());
        img.setImageResource(hero.getImg());
    }

    public HeroItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextView getTxt_name() {
        return txt_name;
    }

    public void setTxt_name(TextView txt_name) {
        this.txt_name = txt_name;
    }

    public TextView getTxt_phone() {
        return txt_phone;
    }

    public void setTxt_phone(TextView txt_phone) {
        this.txt_phone = txt_phone;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }


}
