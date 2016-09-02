package com.itheima.okhttpdemo2.base.handlers;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.itheima.okhttpdemo2.interfaces.IHandler;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public class UIHandler extends Handler {
    private IHandler handler;   //回调接口，消息传递给注册者

    public UIHandler(Looper looper) {
        super(looper);
    }

    public UIHandler(Looper looper, IHandler handler) {
        super(looper);
        this.handler = handler;
    }

    public void setHandler(IHandler handler) {
        this.handler = handler;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if (handler != null) {
            handler.handleMessage(msg);     //有消息，就传递
        }
    }
}

