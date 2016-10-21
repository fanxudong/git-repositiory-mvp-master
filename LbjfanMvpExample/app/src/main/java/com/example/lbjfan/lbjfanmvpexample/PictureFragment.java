package com.example.lbjfan.lbjfanmvpexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lbjfan.lbjfanmvpexample.base.BaseFragment;

/**
 * Created by ${lbjfan} on 16-10-19.
 */
public class PictureFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_main_activity_bottom_tab,null);
    }
}
