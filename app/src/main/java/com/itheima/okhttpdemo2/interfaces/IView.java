package com.itheima.okhttpdemo2.interfaces;

/**
 * Created by Administrator on 2016/7/19 0019.
 * <p/>
 * DES: View的接口,只处理view有关的操作,解耦view层
 */
public interface IView {
    void refreshUI(Object... objs);                 //刷新界面的方法

    void showEmpty();                               //用于展示数据为空的界面

    void showError();                               //用于展示网络错误的界面

    void showLoading();                             //用于展示加载中的界面
}
