package com.itheima.okhttpdemo2.base;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.itheima.okhttpdemo2.base.handlers.UIHandler;
import com.itheima.okhttpdemo2.deliver.EventRocket;
import com.itheima.okhttpdemo2.interfaces.IHandler;
import com.itheima.okhttpdemo2.interfaces.IView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public abstract class BaseActivity extends FragmentActivity implements IView {
    protected UIHandler mHandler = new UIHandler(Looper.getMainLooper());

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventRocket.getDefault().registerObserver(this);
        init();
        initHandler();
        initView();
        initListener();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //        EventBus.getDefault().unregister(this);
        if (mHandler != null) {
            mHandler = null;
        }
    }

    public void initHandler() {
        mHandler.setHandler(new IHandler() {
            @Override
            public void handleMessage(Message msg) {   //只要收到UIHandler发送的消息,这个方法里的代码就会执行
                processMsg(msg);
            }
        });
    }

    @Override
    public void refreshUI(Object... objs) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showError() {

    }

    public abstract void init();

    public abstract void initView();

    public abstract void initListener();

    public abstract void processMsg(Message msg);       //处理消息的方法,让子类实现
}
