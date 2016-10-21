package com.example.lbjfan.lbjfanmvpexample.base.mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ${lbjfan} on 16-10-19.
 */
public interface BaseView {

    void create(LayoutInflater inflater,ViewGroup viewGroup,Bundle savedInstanceState,Context context);

    View getRootView();

    void initWidget(FragmentActivity context);

    void destory();

}
