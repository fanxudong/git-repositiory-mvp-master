package com.example.lbjfan.lbjfanmvpexample.base.mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ${lbjfan} on 16-10-19.
 */
public abstract class AppView implements BaseView {

    private SparseArray<View> mViews = new SparseArray<>();
    private View rootView;

    @Override
    public void create(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState,Context context) {
        int rootLayoutId = getRootLayoutId();
        rootView  = inflater.inflate(rootLayoutId,viewGroup,false);
    }

    //获取布局文件资源ID
    protected abstract int getRootLayoutId();

    @Override
    public View getRootView() {
        return rootView;
    }

    @Override
    public void initWidget(FragmentActivity context) {

    }

    @Override
    public void destory() {

    }

    //一些简化代码的方法
    public <T extends View> T bindView(int id){
        T view=(T)mViews.get(id);
        if(view==null){
            view= (T) rootView.findViewById(id);
            mViews.put(id,view);
        }
        return view;
    }

    public <T extends View> T get$(int id){
        return (T)bindView(id);
    }

    public void setOnClickListener(View.OnClickListener listener,int ... ids){
        if(ids==null){
            return;
        }
        for(int id:ids){
            get$(id).setOnClickListener(listener);
        }
    }
}
