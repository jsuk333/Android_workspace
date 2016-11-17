package com.sds.study.activitystudy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by efro2 on 2016-11-09.
 */

public class MemoMainActivity extends Activity {
    int[] photo={
            R.drawable.avangers,
            R.drawable.avangers2,
            R.drawable.batman,
            R.drawable.captainamerica,
            R.drawable.comichero,
            R.drawable.loki,
            R.drawable.superman,
            R.drawable.thepunisher,
            R.drawable.venom,
            R.drawable.wonderwoman
    };
    String[] telArr={
            "010-5262-1666",
            "010-6211-7353",
            "010-6237-1377",
            "010-1373-7137",
            "010-2345-1758",
            "010-7422-7866",
            "010-5273-8337",
            "010-2725-2722",
            "010-2276-2727",
            "010-2727-1111"
    };
    String[] nick={
            "avangers",
            "avangers2",
            "batman",
            "captainamerica",
            "comichero",
            "loki",
            "superman",
            "thepunisher",
            "venom",
            "wonderwoman"
    };
    LayoutInflater inflater;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflater=(LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        setContentView(R.layout.memo_layout);
        layout=(LinearLayout)findViewById(R.id.layout);
        for(int i=0;i<photo.length;i++){
            LinearLayout item=(LinearLayout) inflater.inflate(R.layout.memo,null);
            TextView name=(TextView)item.findViewById(R.id.name);
            TextView tel=(TextView)item.findViewById(R.id.tel);
            ImageView img=(ImageView)item.findViewById(R.id.img);
            name.setText(nick[i]);
            tel.setText(telArr[i]);
            img.setImageResource(photo[i]);
            layout.addView(item);
        }
    }
    public void btnClick(View view){
        TextView result=(TextView) view.findViewById(R.id.name);
        /*Toast.makeText(this,result.getText(),Toast.LENGTH_SHORT);*/
        Intent intent=new Intent(this,ResultActivity.class);
        intent.putExtra("name",result.getText());
        this.startActivity(intent);
    }
}
