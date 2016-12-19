package com.example.lbjfan.lbjfanmvpexample.base;

/**
 * Created by ${lbjfan} on 16-10-19.
 */
public interface BaseView<T> {


    void initWidget();

    void initTitleBar();

    void setPresent(T present);

}
