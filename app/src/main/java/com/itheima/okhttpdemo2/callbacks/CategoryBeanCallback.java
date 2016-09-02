package com.itheima.okhttpdemo2.callbacks;

import com.itheima.okhttpdemo2.CategoryActivity;
import com.itheima.okhttpdemo2.bean.CategoryBean;
import com.itheima.okhttpdemo2.deliver.EventRocket;
import com.itheima.okhttpdemo2.interfaces.INetCallback;
import com.itheima.okhttpdemo2.utils.JsonParser;

import java.io.IOException;

import okhttp3.Response;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public class CategoryBeanCallback implements INetCallback<CategoryBean> {
    @Override
    public CategoryBean parseResponse(Response response) throws IOException {
        String jsonString = response.body().string();
        CategoryBean categoryBean = JsonParser.changeJson2Bean(jsonString, CategoryBean.class);
        return categoryBean;
    }

    @Override
    public void onSuccess(CategoryBean categoryBean) {
//        EventBus.getDefault().post(categoryBean);
        Object[] arr = {categoryBean, "3", "category"};
        EventRocket.getDefault().notifyObserver(CategoryActivity.class, new Object[]{arr});
    }

    @Override
    public void onFailure(Exception e) {

    }
}
