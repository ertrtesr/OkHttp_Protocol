package com.itheima.okhttpdemo2.protocol;

import com.lzy.okhttputils.model.HttpParams;

import com.itheima.okhttpdemo2.base.BaseProtocol;
import com.itheima.okhttpdemo2.bean.HomeBean;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public class HomeProtocol extends BaseProtocol<HomeBean> {
    @Override
    public String hostUrl() {
//        return "http://10.0.2.2:8080";
        return "http://www.weather.com.cn/";
    }

    @Override
    public String subUrl() {
//        return "market/home";
        return "data/cityinfo/101010100.html";
    }

    @Override
    public HttpParams requestParams() {
        return null;
    }
}
