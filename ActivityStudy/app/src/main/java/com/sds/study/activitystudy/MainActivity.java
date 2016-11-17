package com.sds.study.activitystudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnClick(View view){
       // Toast.makeText(this,"나 눌렀어",Toast.LENGTH_SHORT).show();
        //안드로이드에서 앱 제작시 사용 빈도가 많은 기능을 가리켜
        // 안드로이드의 주요 컴포넌트라고 하는데
        // 이중 하나가 액티비티이다. 이 주요 컴포넌트들은 개발자가 제어할 수없다.
        //즉 생성할 수없다. 이유 - 시스템이 관리하기 때문에
        //시스템에 부탁하자
        //개발자가 안드로이드 시스템에 원하는 요구사항에 대한 의도를 보여야 한다.
        //의도(Intent)
        Intent intent=new Intent(this,RedActivity.class);
        intent.putExtra("data","tiger");//데이터 심기
        this.startActivity(intent);//지정한 액티비티를 활성화
    }
}
