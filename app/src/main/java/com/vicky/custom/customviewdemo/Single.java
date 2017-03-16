package com.vicky.custom.customviewdemo;

/**
 * Created by lenovo on 2016/11/15.
 */
public class Single {
//    private static Single ourInstance = new Single();
//
//    public static Single getInstance() {
//        return ourInstance;
//    }
//
//    private Single() {
//    }
    
    private static class SingleTonHolder {
        private static final Single INSTANCE = new Single();
    }
    
    public static Single getInstance() {
        return SingleTonHolder.INSTANCE;
    }

    private Single() {
    
    }
}
