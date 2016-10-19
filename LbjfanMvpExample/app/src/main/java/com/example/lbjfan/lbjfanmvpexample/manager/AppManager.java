package com.example.lbjfan.lbjfanmvpexample.manager;

import android.content.Context;

/**
 * Created by ${lbjfan} on 16-10-19.
 */
public class AppManager {

    private static AppManager appManager;

    public static AppManager getInstance() {
        if (appManager == null) {
            synchronized (AppManager.class) {
                if (appManager == null) {
                    appManager = new AppManager();
                }
            }
        }
        return appManager;
    }

    public void appInit(Context context){

    }
}
