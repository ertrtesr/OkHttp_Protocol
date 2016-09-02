package com.itheima.okhttpdemo2.base;

import android.support.annotation.Nullable;

import com.lzy.okhttputils.callback.AbsCallback;

import com.itheima.okhttpdemo2.interfaces.INetCallback;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/7/8 0008.
 * <p/>
 * 网络回调的基类,是一个抽象类,继承自OkhttpUtils中的AbsCallback方法,泛型T为需要解析成的对象类型,覆写AbsCallback中的三个方法
 */
public class BaseNetCallBack<T> extends AbsCallback<T> {
    private INetCallback<T> mCallback;

    public BaseNetCallBack(INetCallback<T> callback) {
        mCallback = callback;                                       //构造函数中给自定义的mCallback赋值,本类中保留MyBaseCallback的引用
    }

    @Override
    public T parseNetworkResponse(Response response) throws Exception {
        T t = null;
        try {
            t = mCallback.parseResponse(response);                    //通过MyBaseCallback的引用回调到自己定义的回调接口中去解析数据
        } catch (Exception e) { //鉴于在解析数据时可能会抛出异常,因此多加一层catch,如果子类callback解析出了故障,则走onFailure方法;
            mCallback.onFailure(e);
        }
        return t;
    }

    @Override
    public void onResponse(boolean b, T t, Request request, @Nullable Response response) {
        mCallback.onSuccess(t);               //回调至自定义的成功接口
    }

    @Override
    public void onError(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e) {
        mCallback.onFailure(e);        //回调至自定义的失败接口
    }
}
