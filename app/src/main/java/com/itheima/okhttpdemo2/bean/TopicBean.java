package com.itheima.okhttpdemo2.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public class TopicBean {
    /**
     * response : topic
     * topic : [{"id":2,"name":"儿童玩具聚划算","pic":"/images/topic/2.jpg"}]
     */

    public String response;
    /**
     * id : 2
     * name : 儿童玩具聚划算
     * pic : /images/topic/2.jpg
     */

    public List<TopicData> topic;

    public static class TopicData {
        public int id;
        public String name;
        public String pic;
    }
}
