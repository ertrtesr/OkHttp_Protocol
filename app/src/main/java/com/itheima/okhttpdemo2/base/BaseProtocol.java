package com.itheima.okhttpdemo2.base;

import android.content.Context;

import com.itheima.okhttpdemo2.interfaces.INetCallback;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.cache.CacheMode;
import com.lzy.okhttputils.model.HttpParams;

/**
 * Created by Administrator on 2016/7/9 0009.
 * <p/>
 * 网络访问的基类:实现基本的get和post请求,使用时必须先创建BaseProtocol的子类对象,覆写其中的抽象方法,用于返回url和url后面接的参数
 */
public abstract class BaseProtocol<T> {
    public void get(Context context, final INetCallback<T> callback) {
        OkHttpUtils.get(hostUrl() + "/" + subUrl()).params(requestParams()).tag(context).cacheMode(CacheMode.DEFAULT).execute(new BaseNetCallBack<T>(callback));
    }

    public void post(Context context, final INetCallback<T> callback) {
        OkHttpUtils.post(hostUrl() + "/" + subUrl()).params(requestParams()).tag(context).cacheMode(CacheMode.DEFAULT).execute(new BaseNetCallBack<T>(callback));
    }

    public void postJson(Context context, final INetCallback<T> callback) {
        OkHttpUtils.post(hostUrl() + "/" + subUrl()).postJson(obtainJsonString()).tag(context).cacheMode(CacheMode.DEFAULT).execute(new BaseNetCallBack<T>(callback));
    }

    public void cancel(Context context) {
        OkHttpUtils.getInstance().cancelTag(context);
    }

    public String obtainJsonString() {
        return null;
    }

    /**
     * 主机地址
     *
     * @return
     */
    public String hostUrl() {
        return "http://10.0.2.2:8080";              //子类可以覆写该方法返回自己的主机地址
    }

    public abstract String subUrl();                //子地址

    public abstract HttpParams requestParams();      //?后面所跟的参数?key=value&
}
