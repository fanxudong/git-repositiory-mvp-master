package com.example.lbjfan.lbjfanmvpexample.base.mvp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ${lbjfan} on 16-10-19.
 */
public interface BaseView {

    void create(LayoutInflater inflater,ViewGroup viewGroup,Bundle savedInstanceState);

    View getRootView();

    void initWidget();

    void destory();

}
