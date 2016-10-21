package com.example.lbjfan.lbjfanmvpexample.base.mvp.present;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lbjfan.lbjfanmvpexample.base.mvp.view.BaseView;
import com.example.lbjfan.lbjfanmvpexample.utils.UIUtils;

/**
 * Created by ${lbjfan} on 16-10-20.
 */
public abstract class FragmenterPresenter<T extends BaseView> extends Fragment {

    public T iView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            iView = getIViewClass().newInstance();
        } catch (java.lang.InstantiationException e) {
            throw new RuntimeException("create IView Error");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("create IView Error");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        iView.create(inflater, container, savedInstanceState,getActivity());

        iView.initWidget(getActivity());

        bindEventListener();

        return iView.getRootView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    protected abstract Class<T> getIViewClass();

    protected abstract void bindEventListener();

    public void isDataError(){
        UIUtils.showPrompt("数据错误",getActivity());
    }
}
