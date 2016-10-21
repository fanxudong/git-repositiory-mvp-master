package com.example.lbjfan.lbjfanmvpexample.ui.activity;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.lbjfan.lbjfanmvpexample.MineFragment;
import com.example.lbjfan.lbjfanmvpexample.MusicFragment;
import com.example.lbjfan.lbjfanmvpexample.ui.fragment.NewsFragment;
import com.example.lbjfan.lbjfanmvpexample.PictureFragment;
import com.example.lbjfan.lbjfanmvpexample.R;
import com.example.lbjfan.lbjfanmvpexample.base.mvp.view.AppView;

/**
 * Created by ${lbjfan} on 16-10-20.
 */
public class MainAcitvityView extends AppView {

    private FragmentTabHost tabHost;
    private Class[] fragmentTab = {NewsFragment.class, PictureFragment.class, MusicFragment.class, MineFragment.class};
    private String[] tabName = {"新闻", "图片", "音乐", "我的"};

    @Override
    protected int getRootLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initWidget(FragmentActivity context) {
        initTab(context);
    }

    private void initTab(Context context) {
        tabHost = get$(android.R.id.tabhost);
        FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        tabHost.setup(context, fragmentManager, R.id.fl_main_content);

        for (int i = 0; i < tabName.length; i++) {
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(tabName[i]).setIndicator(getTabView(i, context));
            tabHost.addTab(tabSpec, fragmentTab[i], null);
        }
        tabHost.getTabWidget().setDividerDrawable(R.color.color_white);
    }

    private View getTabView(int position, Context context) {
        View tabView = View.inflate(context, R.layout.view_main_activity_bottom_tab, null);
        TextView tvTabName = (TextView) tabView.findViewById(R.id.tv_tag);
        tvTabName.setText(tabName[position]);
        return tabView;
    }
}
