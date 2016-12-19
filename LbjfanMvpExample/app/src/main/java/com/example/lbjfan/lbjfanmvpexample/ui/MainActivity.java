package com.example.lbjfan.lbjfanmvpexample.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.lbjfan.lbjfanmvpexample.R;
import com.example.lbjfan.lbjfanmvpexample.base.BaseActivity;
import com.example.lbjfan.lbjfanmvpexample.base.BaseFragment;
import com.example.lbjfan.lbjfanmvpexample.ui.news.fragment.NewsFragment;
import com.example.lbjfan.lbjfanmvpexample.ui.picture.fragment.PictureFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainContract.MainView {

    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;

    private MainContract.MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        ButterKnife.bind(this);
        initWidget();
        bindEventListener();
    }

    @Override
    public void initWidget() {
        mainPresenter = new MainPresenter(this);
        initIndicateTab();
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mainPresenter.onStart();
    }

    @Override
    public void initTitleBar() {

    }

    @Override
    public void setPresent(MainContract.MainPresenter present) {
        mainPresenter = present;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //释放引用
        mainPresenter.onResume();
        mainPresenter = null;
    }

    @Override
    public void initIndicateTab() {
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);//点击水泼纹向两边飘散
        bottomNavigationBar.setActiveColor(R.color.colorAccent).setInActiveColor("#FFFFFF").setBarBackgroundColor(R.color.color_view_bg);//背景色
        bottomNavigationBar//添加item
                .addItem(new BottomNavigationItem(R.mipmap.ic_home_white_24dp, "Home"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_book_white_24dp, "Picture"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_music_note_white_24dp, "Music"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_tv_white_24dp, "Movies & TV"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_videogame_asset_white_24dp, "Mine"))
                .initialise();//确认布局
    }

    @Override
    public void bindEventListener() {
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationBar.selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            BaseFragment baseFragment = null;
            switch (position){
                case 0:
                    baseFragment = BaseFragment.getInstance(new NewsFragment(), position, null);
                    break;
                case 1:
                    baseFragment = BaseFragment.getInstance(new PictureFragment(), position, null);
                    break;
                case 2:
                    baseFragment = BaseFragment.getInstance(new PictureFragment(), position, null);
                    break;
                case 3:
                    baseFragment = BaseFragment.getInstance(new PictureFragment(), position, null);
                    break;
                case 4:
                    baseFragment = BaseFragment.getInstance(new PictureFragment(), position, null);
                    break;
            }
            return baseFragment;
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
