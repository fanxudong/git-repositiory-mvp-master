package com.example.lbjfan.lbjfanmvpexample.base.mvp.present;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.lbjfan.lbjfanmvpexample.R;
import com.example.lbjfan.lbjfanmvpexample.base.mvp.view.BaseView;
import com.example.lbjfan.lbjfanmvpexample.utils.UIUtils;

/**
 * Created by ${lbjfan} on 16-10-20.
 */
public abstract class ActivityPresenter<T extends BaseView> extends FragmentActivity {

    //present持有View层的引用
    private T iView;
    private RelativeLayout rootLayout;//整个的父布局，先添加Layout资源，然后添加进度条
    private ProgressDialog pd;

    //利用构造函数进行初始化，获取View层的引用
    public ActivityPresenter() {
        try {
            iView = getIViewClass().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("create IView Error");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("create IView Error");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        iView.create(getLayoutInflater(), null, savedInstanceState,this);
        //创建根布局
        rootLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams rootParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        //添加布局文件到根布局之中
        rootLayout.addView(iView.getRootView(), rootParams);
        rootLayout.setId(R.id.rootId);

        setContentView(rootLayout);

        iView.initWidget(this);
        bindEventListener();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iView.destory();
        //防止内存泄露
        iView = null;
    }

    protected abstract Class<T> getIViewClass();

    protected abstract void bindEventListener();

    public void showDataError() {
        UIUtils.showPrompt("数据错误", this);
    }
}
