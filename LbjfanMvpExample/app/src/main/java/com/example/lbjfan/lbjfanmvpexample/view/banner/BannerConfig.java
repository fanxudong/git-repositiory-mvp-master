package com.example.lbjfan.lbjfanmvpexample.view.banner;


import android.content.Context;
import android.view.View;

import com.elvishew.xlog.XLog;
import com.example.lbjfan.lbjfanmvpexample.modle.NewsBean;
import com.example.lbjfan.lbjfanmvpexample.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

public class BannerConfig {

    public static final String TAG = BannerConfig.class.getSimpleName() + "--->";
    public static final int NOT_INDICATOR = 0;
    public static final int CIRCLE_INDICATOR = 1;
    public static final int NUM_INDICATOR = 2;
    public static final int NUM_INDICATOR_TITLE = 3;
    public static final int CIRCLE_INDICATOR_TITLE = 4;
    public static final int CIRCLE_INDICATOR_TITLE_INSIDE = 5;
    public static final int LEFT = 5;
    public static final int CENTER = 6;
    public static final int RIGHT = 7;

    public static final int INDICATOR_SIZE = 8;
    public static final int PADDING_SIZE = 5;
    public static final int TIME = 5000;
    public static final boolean IS_AUTO_PLAY = true;

    public static final int TITLE_BACKGROUND = -1;
    public static final int TITLE_HEIGHT = -1;
    public static final int TITLE_TEXT_COLOR = -1;
    public static final int TITLE_TEXT_SIZE = -1;

    public static void initBanner(final Context context, Banner banner, final List<NewsBean.DataBean> headList, boolean isClick) {

        final List<String> bannerUrl = new ArrayList<String>();
        for (NewsBean.DataBean headItem : headList) {
            XLog.i(TAG + headItem.getTop_image());
            bannerUrl.add(headItem.getTop_image());
        }
        banner.setImages(bannerUrl);
        if (isClick) {
            //banner.setOnBannerClickListener(s->UIUtils.showPrompt("第" + s. + "Banner",context));
            banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {
                @Override
                public void OnBannerClick(View view, int position) {
                    UIUtils.showPrompt("第" + position + "Banner", context);
                }
            });
        }
    }

}
