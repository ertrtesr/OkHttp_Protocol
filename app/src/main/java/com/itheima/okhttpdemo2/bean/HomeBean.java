package com.itheima.okhttpdemo2.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/7/8 0008.
 */
public class HomeBean implements Serializable {

//    public String response;
//    public List<HomeTopicBean> homeTopic;
//
//    public static class HomeTopicBean {
//        public int id;
//        public String pic;
//        public String title;
//    }
    public WeatherInfo weatherinfo;

    public class WeatherInfo {
        public String city;
        public String cityid;
        public String temp1;
        public String temp2;
        public String weather;
        public String img1;
        public String img2;
        public String ptime;
    }
}
