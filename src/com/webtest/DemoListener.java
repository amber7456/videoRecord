package com.webtest;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DemoListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		// System.out.println("==>DemoListener启动");

	}

	public void contextDestroyed(ServletContextEvent sce) {

	}

}