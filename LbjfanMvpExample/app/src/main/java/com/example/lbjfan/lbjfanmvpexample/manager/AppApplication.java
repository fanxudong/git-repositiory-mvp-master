package com.example.lbjfan.lbjfanmvpexample.manager;

import android.app.Application;

/**
 * Created by ${lbjfan} on 16-10-19.
 */
public class AppApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        AppManager.getInstance().appInit(this);
    }
}
