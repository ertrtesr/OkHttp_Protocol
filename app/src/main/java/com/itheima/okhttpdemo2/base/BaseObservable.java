package com.itheima.okhttpdemo2.base;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Administrator on 2016/7/11 0011.
 */
public abstract class BaseObservable {
    public final ArrayList<Class<?>> obserList = new ArrayList<Class<?>>();

    public <T> void registerObserver(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        this.registerObserver(t.getClass());
    }

    public void registerObserver(Class<?> cls) {
        if (cls == null) {
            throw new NullPointerException();
        }
        synchronized (obserList) {
            if (!obserList.contains(cls)) {
                obserList.add(cls);
            }
        }
    }

    public <T> void unRegisterObserver(T t) {
        if (t == null) throw new NullPointerException();
        this.unRegisterObserver(t.getClass());
    }

    public void unRegisterObserver(Class<?> cls) {
        if (cls == null) throw new NullPointerException();
        synchronized (obserList) {
            Iterator<Class<?>> iterator = obserList.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getName().equals(cls.getName())) {
                    iterator.remove();
                    break;
                }
            }
        }
    }

    public void unRegisterAll() {
        synchronized (obserList) {
            obserList.clear();
        }
    }

    public int countObservers() {
        synchronized (obserList) {
            return obserList.size();
        }
    }

    public abstract void notifyObservers(Object... objs);

    public abstract void notifyObserver(Class<?> cls, Object... objs);

    public abstract <T> void notifyObserver(T t, Object... objs);
}
