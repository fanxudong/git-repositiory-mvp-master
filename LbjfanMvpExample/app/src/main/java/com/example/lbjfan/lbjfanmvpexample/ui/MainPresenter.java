package com.example.lbjfan.lbjfanmvpexample.ui;

import com.elvishew.xlog.XLog;

/**
 * Created by ${lbjfan} on 16-11-21.
 */
public class MainPresenter implements MainContract.MainPresenter {

    private static final String TAG = MainPresenter.class.getSimpleName();

    private MainContract.MainView mainView;

    public MainPresenter(MainContract.MainView mainView) {
        this.mainView = mainView;
        this.mainView.setPresent(this);
    }

    @Override
    public void onStart() {
        XLog.i(TAG + "----ooooo");
    }

    @Override
    public void onResume() {
        //去除引用，防止内存泄露
        mainView = null;
    }
}
