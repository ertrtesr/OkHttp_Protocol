package com.itheima.okhttpdemo2.events;

/**
 * Created by Administrator on 2016/7/14 0014.
 */
public class ErrorEvent {
    private static volatile ErrorEvent mErrorEvent;

    private ErrorEvent() {
    }

    public static ErrorEvent getInstance() {
        if (mErrorEvent == null) {
            synchronized (ErrorEvent.class) {
                if (mErrorEvent == null) {
                    mErrorEvent = new ErrorEvent();
                }
            }
        }
        return mErrorEvent;
    }
}
