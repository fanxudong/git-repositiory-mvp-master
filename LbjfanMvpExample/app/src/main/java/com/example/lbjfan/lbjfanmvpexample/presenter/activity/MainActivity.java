package com.example.lbjfan.lbjfanmvpexample.presenter.activity;

import com.example.lbjfan.lbjfanmvpexample.base.mvp.present.ActivityPresenter;
import com.example.lbjfan.lbjfanmvpexample.ui.activity.MainAcitvityView;

public class MainActivity extends ActivityPresenter<MainAcitvityView> {


    @Override
    protected Class<MainAcitvityView> getIViewClass() {
        return MainAcitvityView.class;
    }

    @Override
    protected void bindEventListener() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
