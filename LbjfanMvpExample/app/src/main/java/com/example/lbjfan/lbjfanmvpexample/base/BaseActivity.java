package com.example.lbjfan.lbjfanmvpexample.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by ${lbjfan} on 16-10-19.
 */
public abstract class BaseActivity extends FragmentActivity {


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    protected abstract void addContentView(int layoutID);

    protected abstract void initView();
}
