package com.itheima.okhttpdemo2.utils;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by Administrator on 2016/7/8 0008.
 * <p/>
 * des:json字符串的解析类,封装了fastJson,可实现转json转实体,json转集合,以及对象转json字符串的功能
 */
public class JsonParser {
    /**
     * @param jsonString 需进行解析的json字符串
     * @param clazz      传入解析后的实体类的.class参数
     * @param <T>        jsonString转换后的实体类
     * @return 解析后的对象
     */
    public static <T> T changeJson2Bean(String jsonString, Class<T> clazz) {
        T t = JSON.parseObject(jsonString, clazz);
        return t;
    }

    /**
     * @param jsonString
     * @param clazz
     * @param <T>        jsonString解析后的实体类
     * @return 解析后的集合
     */
    public static <T> List<T> changeJson2List(String jsonString, Class<T> clazz) {
        List<T> list = JSON.parseArray(jsonString, clazz);
        return list;
    }

    /**
     * @param t   封装好的实体对象
     * @param <T> 需要转成json字符串的对象类型
     * @return json字符串
     */
    public static <T> String changeBean2JsonString(T t) {
        String jsonString = JSON.toJSONString(t);
        return jsonString;
    }
}
