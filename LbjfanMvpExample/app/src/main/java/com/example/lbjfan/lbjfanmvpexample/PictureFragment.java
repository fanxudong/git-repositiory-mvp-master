package com.example.lbjfan.lbjfanmvpexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lbjfan.lbjfanmvpexample.base.BaseFragment;

/**
 * Created by ${lbjfan} on 16-10-19.
 */
public class PictureFragment extends BaseFragment {

    private TextView tv_alert;
    private View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.frag_main_picture,null);
        tv_alert = (TextView) rootView.findViewById(R.id.tv_alert);
        tv_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
        return rootView;
    }
}
