package com.YuuiAsuka.app1.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//对接redis或者elasticsearch等第三方工具
@WebListener
public class CustomContextListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInit");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroy");
    }
}
