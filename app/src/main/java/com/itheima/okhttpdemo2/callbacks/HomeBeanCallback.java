package com.itheima.okhttpdemo2.callbacks;

import com.itheima.okhttpdemo2.bean.HomeBean;
import com.itheima.okhttpdemo2.interfaces.INetCallback;
import com.itheima.okhttpdemo2.interfaces.IView;
import com.itheima.okhttpdemo2.utils.JsonParser;

import java.io.IOException;

import okhttp3.Response;

/**
 * Created by Administrator on 2016/7/7 0007.
 */
public class HomeBeanCallback implements INetCallback<HomeBean> {
    private IView mIView;

    public HomeBeanCallback() {
    }

    public HomeBeanCallback(IView view) {
        this.mIView = view;
    }

    @Override
    public HomeBean parseResponse(Response response) throws IOException {
        String jsonString = response.body().string();
        HomeBean homeBean = JsonParser.changeJson2Bean(jsonString, HomeBean.class);
        return homeBean;
    }

    @Override
    public void onSuccess(HomeBean homeBean) {
//        EventBus.getDefault().post(homeBean);
//        EventRocket.getDefault().notifyObserver(MainActivity.class, homeBean);
//        Object[] arr = {homeBean, 1, "home"};
//        EventRocket.getDefault().notifyObserver(MainActivity.class, new Object[]{arr});
        mIView.refreshUI(homeBean);
    }

    @Override
    public void onFailure(Exception e) {
//        EventBus.getDefault().post(ErrorEvent.getInstance());
        mIView.showError();
    }
}
