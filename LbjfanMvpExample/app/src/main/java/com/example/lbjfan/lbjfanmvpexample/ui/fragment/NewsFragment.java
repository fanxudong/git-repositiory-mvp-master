package com.example.lbjfan.lbjfanmvpexample.ui.fragment;

import com.example.lbjfan.lbjfanmvpexample.base.mvp.present.FragmenterPresenter;
import com.example.lbjfan.lbjfanmvpexample.presenter.fragment.NewsFragmentView;

/**
 * Created by ${lbjfan} on 16-10-19.
 */
public class NewsFragment extends FragmenterPresenter<NewsFragmentView> {


    @Override
    protected Class<NewsFragmentView> getIViewClass() {
        return NewsFragmentView.class;
    }

    @Override
    protected void bindEventListener() {
        //iView.setTabPageIndicatorViewPager();
    }

}
