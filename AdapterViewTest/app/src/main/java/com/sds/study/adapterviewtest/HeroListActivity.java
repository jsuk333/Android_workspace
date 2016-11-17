package com.sds.study.adapterviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;

/**
 * 복합 위젯을 리스트 뷰로 보여 주자
 * 자체 제작한 List와 차이점은 안드로이드 API 에서 지원하는
 * AdapterView의 결
 * 정적 차이점은? 메모리 효율성이 극대화 됨..
 *
 */

public class HeroListActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //리스트 뷰는 껍데기에 불과 하므로 적절한 어댑터를 사용해 보자
        //ArrayAdapter는 단순히 텍스트 뷰 하나로 구현시만 사용가능하므로
        //개발자가 정의한 복합 위젯 표현이 불가능 하다 따라서 Adapter를 직접 구현하자
        //스윙에서 테이블 모델에서 상속받아 재정의 하는것과 동일하다.
        setContentView(R.layout.activity_list);
        //ListView listView=(ListView)findViewById(R.id.listView);
        //GridView listView=(GridView)findViewById(R.id.listView);
        Spinner listView=(Spinner) findViewById(R.id.listView);
        MyAdapter myAdapter=new MyAdapter(this);
        listView.setAdapter(myAdapter);
    }
}
