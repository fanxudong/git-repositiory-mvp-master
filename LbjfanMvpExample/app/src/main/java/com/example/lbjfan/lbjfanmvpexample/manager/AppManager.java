package com.example.lbjfan.lbjfanmvpexample.manager;

import android.content.Context;

import com.example.lbjfan.lbjfanmvpexample.api.newsApi.NewsApiService;
import com.example.lbjfan.lbjfanmvpexample.api.newsApi.PictureApiService;
import com.example.lbjfan.lbjfanmvpexample.config.NewsConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by ${lbjfan} on 16-10-19.
 */
public class AppManager {

    private static AppManager appManager;
    private NewsApiService newsApiService;
    private PictureApiService pictureApiService;

    public static AppManager getInstance() {
        if (appManager == null) {
            synchronized (AppManager.class) {
                if (appManager == null) {
                    appManager = new AppManager();
                }
            }
        }
        return appManager;
    }

    public void appInit(Context context) {
        Fresco.initialize(context);
        initHttpApi();
    }

    private void initHttpApi() {
        if (newsApiService == null) {
            synchronized (NewsApiService.class) {
                if (newsApiService == null) {
                    newsApiService = new Retrofit.Builder()
                            .client(okClient())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .baseUrl(NewsConstants.baseNewsUrl).build()
                            .create(NewsApiService.class);
                }
            }
        }
        if (pictureApiService == null) {
            synchronized (PictureApiService.class) {
                if (pictureApiService == null) {
                    pictureApiService = new Retrofit.Builder()
                            .client(okClient())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .baseUrl(NewsConstants.baseNewsUrl).build()
                            .create(PictureApiService.class);
                }
            }
        }
    }

    private OkHttpClient okClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setWriteTimeout(1, TimeUnit.MINUTES);
        okHttpClient.setConnectTimeout(1, TimeUnit.MINUTES);
        okHttpClient.setReadTimeout(1, TimeUnit.MINUTES);
        return okHttpClient;
    }

    public NewsApiService getNewsApiService() {
        return newsApiService;
    }

    public PictureApiService getPictureApiService() {
        return pictureApiService;
    }
}
