package com.itheima.okhttpdemo2.protocol;

import com.lzy.okhttputils.model.HttpParams;

import com.itheima.okhttpdemo2.base.BaseProtocol;
import com.itheima.okhttpdemo2.bean.CategoryBean;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public class CategoryProtocol extends BaseProtocol<CategoryBean> {

    @Override
    public String subUrl() {
        return "market/category";
    }

    @Override
    public HttpParams requestParams() {
        HttpParams httpParams = new HttpParams("version", "2");
        return httpParams;
    }
}
