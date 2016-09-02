package com.itheima.okhttpdemo2.protocol;

import com.lzy.okhttputils.model.HttpParams;

import com.itheima.okhttpdemo2.base.BaseProtocol;
import com.itheima.okhttpdemo2.bean.TopicBean;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public class TopicProtocol extends BaseProtocol<TopicBean> {
    @Override
    public String hostUrl() {
        return "http://10.0.2.2:8080";
    }

    @Override
    public String subUrl() {
        return "market/topic";
    }

    @Override
    public HttpParams requestParams() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("page", "1");
        httpParams.put("pageNum", "2");
        return httpParams;
    }
}
