package com.sds.study.viewcustom;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 *  히어로 한 세트 (복합위젯)를 xml로 정의 해놓고 반복문을 돌려보자
 */

public class HeroActivity extends Activity {
    int[] photo={
            R.drawable.arrow,
            R.drawable.avangers,
            R.drawable.avangers2,
            R.drawable.batman,
            R.drawable.captainamerica,
            R.drawable.loki,
            R.drawable.superman,
            R.drawable.thepunisher,
            R.drawable.venom,
            R.drawable.wonderwoman
    };
    String[] title={
            "arrow",
            "avangers",
            "avangers2",
            "batman",
            "captainamerica",
            "loki",
            "superman",
            "thepunisher",
            "venom",
            "wonderwoman"
    };
    String[] p={
            "124",
            "25543",
            "513",
            "256",
            "622",
            "6221",
            "366",
            "1635",
            "161",
            "6161"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setcontentView는 하나의 전체 화면을 차지하기 때문에
        //히어로 하나만을 생성하는 목적으로 는 맞지 않다.
        //개발자가 xml을 직접 load하자
        //xml에 명시한 태그를 실제 안드로이드 객체화 시켜 메모리에 올리는 과정을 inflater라고 한다.
        LayoutInflater inflater=(LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);

        //그리드 레이아웃 안에 원하는 개수 만큼 반복문 돌려서 추가한다.
        //참고로 setContentView에서 내부적으로 Inflation이 일어난다.
        setContentView(R.layout.gallery_layout);
        GridLayout grid=(GridLayout)findViewById(R.id.grid);
        for(int i=0;i<photo.length;i++){
            RelativeLayout item=(RelativeLayout) inflater.inflate(R.layout.hero_layout,null);
            ImageView img=(ImageView)item.findViewById(R.id.img);
            TextView name=(TextView)item.findViewById(R.id.name);
            TextView power=(TextView)item.findViewById(R.id.p);
            name.setText(title[i]);
            power.setText(p[i]);
            img.setImageResource(photo[i]);

            grid.addView(item);
        }
    }
}
