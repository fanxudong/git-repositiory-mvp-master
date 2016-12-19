package com.example.lbjfan.lbjfanmvpexample.ui.news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lbjfan.lbjfanmvpexample.R;
import com.example.lbjfan.lbjfanmvpexample.base.BaseFragment;
import com.example.lbjfan.lbjfanmvpexample.view.TabPageIndicator;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ${lbjfan} on 16-10-19.
 */
public class NewsFragment extends BaseFragment implements NewsFragmentContract.NewsFragmentView {

    private static final String TAG = NewsFragment.class.getSimpleName();
    private View view;
    private String[] tabName = {"头条", "娱乐", "军事", "汽车", "财经", "笑话", "体育", "科技"};
    @Bind(R.id.tab_indicator)
    TabPageIndicator tabPageIndicator;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    private MyAdapter adapter;
    private NewsFragmentPresent newsPresent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_main_news, null);
        ButterKnife.bind(this, view);
        initWidget();
        newsPresent = new NewsFragmentPresent(this);
        return view;
    }

    @Override
    public void initWidget() {
        adapter = new MyAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabPageIndicator.setViewPager(viewPager);
        tabPageIndicator.setIndicatorMode(TabPageIndicator.IndicatorMode.MODE_WEIGHT_NOEXPAND_SAME);// 设置模式，一定要先设置模式
    }

    @Override
    public void initTitleBar() {

    }

    @Override
    public void setPresent(NewsFragmentContract.NewsFragmentPresent present) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        newsPresent.onResume();
    }

    public class MyAdapter extends FragmentStatePagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabName[position];
        }

        @Override
        public Fragment getItem(int position) {
            return BaseFragment.getInstance(new NewsListFragment(), position + 1, null);
        }

        @Override
        public int getCount() {
            return tabName.length;
        }
    }
}
