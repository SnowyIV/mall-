package com.geekaca.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("当servletContext 初始化的时候，这个方法会被调用");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("servletContext被销毁的时候，方法被调用");
    }
}
