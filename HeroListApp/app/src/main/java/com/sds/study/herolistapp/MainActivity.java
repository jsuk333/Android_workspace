package com.sds.study.herolistapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ViewGroup.OnClickListener{
    int[] thumb={
            R.drawable.batman,
            R.drawable.captain,
            R.drawable.flashman,
            R.drawable.green,
            R.drawable.ironman,
            R.drawable.punisher,
            R.drawable.robin,
            R.drawable.spiderman,
            R.drawable.superman,
            R.drawable.wonder
    };
    String[] arr_name={
            "배트맨",
            "캡틴아메리카",
            "플래시맨",
            "그린",
            "아이언맨",
            "처벌자",
            "로빈",
            "스파이더맨",
            "슈퍼맨",
            "원더우먼"
    };
    String[] arr_phone={
            "010-4161-5262",
            "010-4161-7272",
            "010-4161-6163",
            "010-4161-8282",
            "010-4161-2653",
            "010-4161-7557",
            "010-4161-6277",
            "010-4161-6278",
            "010-4161-6227",
            "010-4161-2565"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_list);
        //레이아웃을 얻어 와서 동적으로 아이템들을 채워 넣자
        LinearLayout layout=(LinearLayout)findViewById(R.id.layout);
        LayoutInflater inflater=(LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        for(int i=0;i<10;i++){
           Hero hero=new Hero();
            hero.setName(arr_name[i]);
            hero.setPhone(arr_phone[i]);
            hero.setImg(thumb[i]);
            HeroItem item=new HeroItem(this,hero);
            item.setOnClickListener(this);
            layout.addView(item);
        }

    }

    @Override
    public void onClick(View view) {
        TextView txt_name=(TextView)view.findViewById(R.id.txt_name);
        //Toast.makeText(this,data.getText(),Toast.LENGTH_SHORT).show();
        //액티비티는 호출만 가능 할뿐 우리가 메모리에 직접 생성할수없다.
        //이때 개발자는 시스템에 원하는 내용 즉, 의도를 보여야 한다.
        //즉, 시스템이 이해 할수 있는 형태로 표현해야 하는데 그 객체가 intent이다.
        Intent intent=new Intent(this,DetailActivity.class);
        intent.putExtra("data",txt_name.getText());
        this.startActivity(intent);
    }
}
