package com.itheima.okhttpdemo2.callbacks;

import com.itheima.okhttpdemo2.bean.TopicBean;
import com.itheima.okhttpdemo2.events.ErrorEvent;
import com.itheima.okhttpdemo2.interfaces.INetCallback;
import com.itheima.okhttpdemo2.utils.JsonParser;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import okhttp3.Response;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public class TopicBeanCallback implements INetCallback<TopicBean> {
    @Override
    public TopicBean parseResponse(Response response) throws IOException {
        String jsonString = response.body().string();
        TopicBean topicBean = JsonParser.changeJson2Bean(jsonString, TopicBean.class);
        return topicBean;
    }

    @Override
    public void onSuccess(TopicBean topicBean) {
//        System.out.println(topicBean.topic.size());
//        Object[] arr = {topicBean, 2, "topic"};
//        EventRocket.getDefault().notifyObserver(TopicActivity.class, new Object[]{arr});
    }

    @Override
    public void onFailure(Exception e) {
        EventBus.getDefault().post(ErrorEvent.getInstance());
    }
}
