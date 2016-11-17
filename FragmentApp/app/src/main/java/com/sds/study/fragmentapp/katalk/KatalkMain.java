package com.sds.study.fragmentapp.katalk;

import android.app.Activity;

import android.os.Bundle;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sds.study.fragmentapp.R;

/**
 * Created by efro2 on 2016-11-16.
 */

public class KatalkMain extends Activity {
    LinearLayout container;
    FragmentManager manager;
    FragmentTransaction transaction;
    String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getClass().getName();
        setContentView(R.layout.katalk_main_layout);
    }

    public void btnClick(View view) {
        manager = getFragmentManager();
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.bt_red:
                fragment = new RedFragment();
                replaceFragment(fragment);
                break;
            case R.id.bt_green:
                fragment = new GreenFragment();
                replaceFragment(fragment);
                break;
            case R.id.bt_blue:
                fragment = new BlueFragment();
                replaceFragment(fragment);
                break;
        }
    }
    public void replaceFragment(Fragment fragment){
        transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
