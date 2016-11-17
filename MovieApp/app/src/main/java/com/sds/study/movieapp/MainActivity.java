package com.sds.study.movieapp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    String TAG;
    static final int READ_REQUEST = 1;
    //보여질 데이터가 단지 단일 텍스트일때 적절
    //단, 복합 위젯의 경우엔 우리가 재정의
    ListView listView;
    File dir;//타겟디렉토리
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getName();
        setContentView(R.layout.activity_main);
        listView=(ListView) findViewById(R.id.listView);

        //안드로이드의 외부 저장소에 접근해보자!!
        //각 기기의 디바이스의 종류에 따라 각각 종류가 틀리므로 아래의
        //코드가 유용하다.....
        //현재 앱에 지정한 권한이 있는지 부터 체크해 본다.
        int readPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        Log.d(TAG, "readPermission" + Integer.toString(readPermission));
        if (readPermission == PackageManager.PERMISSION_GRANTED) {
            getInfo();
            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.READ_EXTERNAL_STORAGE
                    }, READ_REQUEST);
        } else {//권한이 없다면 권한 요청
            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.READ_EXTERNAL_STORAGE
                    }, READ_REQUEST);
        }
    }
    //사용자의 권한 처리 여부를 피드백 받기 위한 메서드 재정의

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case READ_REQUEST:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "권한 수락!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "권한 거부!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    //권한이 있을때만 하위 디렉토리에 대한 접근을 시작하자
    //마시멜로버전부터 권한 정책이 바뀌었다.
    public void getInfo() {
        dir = new File(Environment.getExternalStorageDirectory(),"iot_movie");
        File[] sub = dir.listFiles();
        ArrayList<String> list= new ArrayList<String>();
        for(int i=0;i<sub.length;i++){
            list.add(sub[i].getName());
        }
        Log.d(TAG, "외부 저장소 루트 경로는" + dir.getAbsolutePath());
        adapter=new MyAdapter(this);
       //리스트 뷰와 어댑터 연결
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //선택한 아이템으로부터 정보를 추출한다음 Intent전달해 본다. dto정보를 추출한다.
        //일반적으로 Intent에는 기본형 레퍼런스 클래스만을 담을 수 있지만
        //일반 인스턴스도 가능하다 단, parcelable인터페이스를 구현해야 한다.
        Movie movie=((MovieItem)view).movie;
        movie.setImg(dir.getAbsolutePath()+"/"+movie.getImg());
        Intent intent=new Intent(this,DetailActivity.class);
        intent.putExtra("dto",movie);
        startActivity(intent);
    }
}
