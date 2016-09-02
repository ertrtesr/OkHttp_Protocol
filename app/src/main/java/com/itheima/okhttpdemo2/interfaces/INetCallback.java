package com.itheima.okhttpdemo2.interfaces;

import java.io.IOException;

import okhttp3.Response;

/**
 * Created by Administrator on 2016/7/9 0009.
 * <p/>
 * 自定义的网络回调接口,以后所有自定义网络回调类都需实现该接口,通过BaseProtocol中的接口回调,回调至自己定义的接口中进行数据解析的操作
 */
public interface INetCallback<T> {
    T parseResponse(Response response) throws IOException;

    void onSuccess(T t);

    void onFailure(Exception e);
}
