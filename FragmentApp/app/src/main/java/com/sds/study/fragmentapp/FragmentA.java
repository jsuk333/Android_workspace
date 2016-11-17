package com.sds.study.fragmentapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 안드로이드의 화면이 태블릿의 등장으로 커짐에 따라 공간활용을 위해
 * 하나의 화면내에서도 여러 화면으로 분할가능하도록 하기 위한 객체가
 * 프래그먼트이다. 쉽게 생각하면 작은 액티비티가 있어야 하낟.
 * 화면의 일부이므로 반드시 액티비티에 의존해서 존재하게 된다.
 * html과 비교하면 iframe과 비슷하다.
 */

public class FragmentA extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.a_layout,null);
    }

}
