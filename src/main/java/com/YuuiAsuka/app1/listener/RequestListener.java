package com.YuuiAsuka.app1.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

//监听请求并进行逻辑处理
@WebListener
public class RequestListener implements ServletRequestListener {
    //在请求之前
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("requestDestroyed");
    }

    //在请求之后
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("ServletInit");
    }
}
