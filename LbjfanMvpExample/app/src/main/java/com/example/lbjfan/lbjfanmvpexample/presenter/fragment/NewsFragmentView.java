package com.example.lbjfan.lbjfanmvpexample.presenter.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.lbjfan.lbjfanmvpexample.PictureFragment;
import com.example.lbjfan.lbjfanmvpexample.R;
import com.example.lbjfan.lbjfanmvpexample.base.mvp.view.AppView;
import com.example.lbjfan.lbjfanmvpexample.view.TabPageIndicator;

/**
 * Created by ${lbjfan} on 16-10-20.
 */
public class NewsFragmentView extends AppView {

    private String[] tabName ={"头条","新闻","财经","体育","军事","政治","娱乐","房产","直播","热点",};
    private TabPageIndicator tabPageIndicator;
    private ViewPager viewPager;
    private MyAdapter adapter;

    @Override
    protected int getRootLayoutId() {
        return R.layout.frag_main_news;
    }

    @Override
    public void initWidget(FragmentActivity context) {
        tabPageIndicator = get$(R.id.tab_indicator);
        viewPager = get$(R.id.viewPager);
        adapter = new MyAdapter(((FragmentActivity)context).getSupportFragmentManager());
        //setTabPageIndicatorViewPager();
    }

    public void setTabPageIndicatorViewPager(){
        viewPager.setAdapter(adapter);
        tabPageIndicator.setViewPager(viewPager);
        tabPageIndicator.setIndicatorMode(TabPageIndicator.IndicatorMode.MODE_WEIGHT_NOEXPAND_SAME);// 设置模式，一定要先设置模式
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
            return new PictureFragment();
        }

        @Override
        public int getCount() {
            return tabName.length;
        }
    }

}
