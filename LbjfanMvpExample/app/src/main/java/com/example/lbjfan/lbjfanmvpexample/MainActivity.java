package com.example.lbjfan.lbjfanmvpexample;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.lbjfan.lbjfanmvpexample.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private FragmentTabHost tabHost;
    private Class[] fragmentTab = {NewsFragment.class, PictureFragment.class, MusicFragment.class, MineFragment.class};
    private String[] tabName = {"新闻","图片","音乐","我的"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    @Override
    protected void addContentView(int layoutID) {

    }

    @Override
    public void initView() {
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.fl_main_content);

        for (int i=0;i<tabName.length;i++){
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(tabName[i]).setIndicator(getTabView(i));
            tabHost.addTab(tabSpec, fragmentTab[i], null);
        }
        tabHost.getTabWidget().setDividerDrawable(R.color.color_white);
    }

    private View getTabView(int position){
        View tabView = View.inflate(this,R.layout.view_main_activity_bottom_tab,null);
        TextView tvTabName = (TextView) tabView.findViewById(R.id.tv_tag);
        tvTabName.setText(tabName[position]);
        return tabView;
    }
}
