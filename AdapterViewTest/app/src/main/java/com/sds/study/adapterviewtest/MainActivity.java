/*안드로이드에서 데이터를 보여주기 위해 사용되는
* 위젯의 종류엔 크게 3가지가 있다. 단, 이 위젯은 스윙의 JTable과 마찬가지로
* 껍데기와 마찮가지이기때문에 Adapter가 담당한다. 이 위젯을 가리켜
* AdapterView라고 한다.
* ListView 세로 방향 스크롤 형식
* GridView 격자 무늬 형식
* SpinnerView html select box형식
* */
package com.sds.study.adapterviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // ListView listView=(ListView) findViewById(R.id.listView);
        //Spinner listView=(Spinner) findViewById(R.id.listView);
        GridView listView=(GridView) findViewById(R.id.listView);
        ArrayList list=new ArrayList();
        list.add("사과");
        list.add("딸기");
        list.add("바나나");
        list.add("파인애플");
        list.add("오렌지");
        list.add("귤");
        list.add("모과");
        list.add("메론");
        list.add("수박");

        ArrayAdapter<String> adapter=null;
        adapter=new ArrayAdapter<String>(this,R.layout.myitem,list);
        listView.setAdapter(adapter);
    }
}
