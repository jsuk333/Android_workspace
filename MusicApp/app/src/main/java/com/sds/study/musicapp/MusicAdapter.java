package com.sds.study.musicapp;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by efro2 on 2016-11-11.
 */

public class MusicAdapter extends BaseAdapter {
    Context context;
    String TAG;
    ArrayList<Music> list = new ArrayList<Music>();
    BufferedReader buffr;
    public MusicAdapter(Context context) {
        this.context = context;
        TAG = this.getClass().getName();
        //json 가져오기
        AssetManager manager = context.getAssets();
        try {
            InputStream is = manager.open("music.data");
           buffr = new BufferedReader(new BufferedReader(new InputStreamReader(is)));
            String data = null;
            StringBuffer sb = new StringBuffer();
            while ((data = buffr.readLine()) != null) {
                //Log.d(TAG,data);
                sb.append(data);
            }
            //  JsonReader jsonReader=new JsonReader(buffr);
            //json 완성시점
            JSONObject jsonObject = new JSONObject(sb.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("musicList");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = (JSONObject) jsonArray.getJSONObject(i);
                Music music = new Music();
                music.setTitle(object.getString("title"));
                music.setArtist(object.getString("artist"));
                music.setFilename(object.getString("filename"));
                list.add(music);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if(buffr!=null){
                try {
                    buffr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //아이템 개수
    public int getCount() {
        return list.size();
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    //각 index 에 보여질 뷰(버튼, 각종 뷰, but 사실 복합위젯이 대부분)
    public View getView(int i, View view, ViewGroup viewGroup) {
        Music music =list.get(i);
        MusicItem item = new MusicItem(context, music);
        return item;
    }
}
