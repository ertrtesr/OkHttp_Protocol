package com.itheima.okhttpdemo2.deliver;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.itheima.okhttpdemo2.base.BaseObservable;

/**
 * Created by Administrator on 2016/7/11 0011.
 */
public class EventRocket extends BaseObservable {
    private static volatile EventRocket instance;

    private EventRocket() {

    }

    public static EventRocket getDefault() {
        if (instance == null) {
            synchronized (EventRocket.class) {
                if (instance == null) {
                    instance = new EventRocket();
                }
            }
        }
        return instance;
    }

    @Override
    public void notifyObservers(Object... objs) {
        for (Class<?> cls : obserList) {
            this.notifyObserver(cls, objs);
        }
    }

    @Override
    public void notifyObserver(Class<?> cls, Object... objs) {
        if (cls == null) {
            throw new NullPointerException();
        }
        Method[] methods = cls.getDeclaredMethods();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
        }
        for (Method method : methods) {
            if (method.getName().equals("refreshUI")) {
                try {
                    method.setAccessible(true);
                    method.invoke(cls.newInstance(), objs);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public <T> void notifyObserver(T t, Object... objs) {
        if (t == null) {
            throw new NullPointerException();
        }
        this.notifyObserver(t.getClass(), objs);
    }
}
