package com.sds.study.adapterviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by efro2 on 2016-11-10.
 */

public class MyAdapter extends BaseAdapter {
    //String[] arr = {"사과", "딸기", "오렌지", "바나나", "파인애플", "망고", "멜론", "배"};
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
    Context context;

    public MyAdapter(Context context) {
        this.context = context;
    }

    //총 아이템 개수
    @Override
    public int getCount() {
        return thumb.length;
    }

    //i번째 아이템 추출
    @Override
    public Object getItem(int i) {
        return null;
    }

    //
    @Override
    public long getItemId(int i) {
        return 0;
    }

    //선택한 위치의 밸류 반환
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //복합위젯을 인플레이션 하여 반환한다.
        LayoutInflater inflater=null;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout itemLayout=(LinearLayout) inflater.inflate(R.layout.hero_item,null);
        ((TextView)itemLayout.findViewById(R.id.txt_name)).setText(arr_name[i]);
        ((TextView)itemLayout.findViewById(R.id.txt_phone)).setText(arr_phone[i]);
        ((ImageView)itemLayout.findViewById(R.id.img)).setImageResource(thumb[i]);
        return itemLayout;
    }
}
