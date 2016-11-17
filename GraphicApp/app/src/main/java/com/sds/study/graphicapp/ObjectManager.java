package com.sds.study.graphicapp;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by efro2 on 2016-11-16.
 */

public class ObjectManager {
    private ArrayList<GameObject> list;

    public ObjectManager() {
        list=new ArrayList<GameObject>();
    }
    public void addObject(GameObject object){
        list.add(object);
    }
    public void removeObject(GameObject object){
        for(int i=0;i<list.size();i++){
            if(list.get(i)==object) {
                list.remove(i);
            }
        }
    }

    public ArrayList<GameObject> getList() {
        return list;
    }

    public void setList(ArrayList<GameObject> list) {
        this.list = list;
    }
    public void tick(){
        for(int i=0;i<list.size();i++){
            list.get(i).tick();
        }
    }
    public void render(Canvas canvas){
        for(int i=0;i<list.size();i++){
            list.get(i).render(canvas);
        }
    }
}
