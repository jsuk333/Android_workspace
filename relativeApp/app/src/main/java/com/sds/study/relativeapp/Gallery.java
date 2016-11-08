package com.sds.study.relativeapp;

/*엑티비티란 화면 관리자 이다(화면 Controller)*/
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Gallery extends Activity implements ViewGroup.OnClickListener{
    ImageView img;
    Button bt_prev;
    Button bt_next;
    //안드로이드 res디렉토리에 넣어지는 모든 자원을
    //내부적으로 상수화 시킨다.. 따라서 int로 제어가 가능
    //res/layout/xml파일,res/drawable/그림파일
    int[] photo={R.drawable.img0,
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,};
    //배열의 인덱스
    int index=0;
    //서블릿의 init이 클래스의 초기화를 담당한다면
    //안드로이드에서의 클래스 초기화는 OnCreate메서드가 담당
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //xml에 명시된 객체가 메모리로 로드됨(Inflation)
        setContentView(R.layout.gallery2);
        //버튼과 리스너 연결
        bt_prev=(Button)this.findViewById(R.id.bt_prev);
        bt_next=(Button)this.findViewById(R.id.bt_next);
        img=(ImageView)this.findViewById(R.id.img);
        bt_prev.setOnClickListener(this);
        bt_next.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //이벤트를 일으킨 뷰가 인수로 넘어옴..
        //스윙으ㅢ ActionEvent가 넘어오는 것과 비슷함..
        if(view.equals(bt_prev)){
             index--;
            if(index<0){
                index++;
                Toast.makeText(this,"이전 사진이 없습니다.",Toast.LENGTH_SHORT).show();
                return;
            }else{
                Toast.makeText(this,"이전사진",Toast.LENGTH_SHORT).show();
            }
        }else if(view.equals(bt_next)){

            index++;
            if(index>=photo.length){
                index--;
                Toast.makeText(this,"다음 사진이 없습니다.",Toast.LENGTH_SHORT).show();
                return;
            }else{
                Toast.makeText(this,"다음사진",Toast.LENGTH_SHORT).show();
            }
        }
        img.setImageResource(photo[index]);
    }
}
