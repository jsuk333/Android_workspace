package com.sds.study.movieapp;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 리스트뷰를 이루는 아이템이 복잡하거나 , 안드로이드 자체에서 지원하지 않을 경우
 * 개발자가 직접 어댑터를 재정의 해야한다.
 */

public class MyAdapter extends BaseAdapter {
    Context context;
    String TAG;
    ArrayList<Movie> list=new ArrayList<Movie>();
    //getcount등이 호출되기전에 이미 데이터를 처리 해놓아야 한다.
    public MyAdapter(Context context) {
        this.context = context;
        TAG=this.getClass().getName();
        AssetManager manager = context.getAssets();
        BufferedReader buffr = null;
        try {
            InputStream is = manager.open("data.json");
            buffr = new BufferedReader(new InputStreamReader(is));
            StringBuffer sb = new StringBuffer();
            String data = null;
            while (true) {
                data = buffr.readLine();
                if (data == null) {
                    break;
                }
                sb.append(data);
                System.out.println(data);
            }

            JSONObject jsonObject = new JSONObject(sb.toString());
            JSONArray jsonArray=(JSONArray)jsonObject.getJSONArray("movieList");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject obj=jsonArray.getJSONObject(i);
                Movie movie=new Movie();
                movie.setTitle(obj.getString("title"));
                movie.setRegdate(obj.getString("regdate"));
                movie.setImg(obj.getString("img"));
                list.add(movie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if (buffr != null) {
                try {
                    buffr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }
//이미 디자인이 완료된 상태에서 원하는 뷰 추출
    @Override
    public Object getItem(int i) {
        return null;
    }
//아이템의 유일성 확보
    @Override
    public long getItemId(int i) {
        return 0;
    }
//디자인 구성시 호출
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        //최초에 아무것도 없는 상태라면
        View view=null;

        Movie movie=(Movie)list.get(i);
        if(convertView==null) {
            MovieItem item = new MovieItem(context);
            item.setData(movie);
            view=item;
        }else{//이미 채워진 경우라면 같은 뷰로 대체한다.
            MovieItem item=(MovieItem)convertView;
            item.setData(movie);
            view=item;
        }
        Log.d(TAG,i+"번째 뷰는"+convertView);
        return view;
    }
}
