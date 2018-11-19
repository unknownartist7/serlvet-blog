package com.blog.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.blog.dao.DruidDBSource;

@WebListener
public class ApplicationContextListener implements ServletContextListener{

	public static DruidDBSource druidDBSource = null;
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		try{
			DruidDBSource.initJDBCProperties();
			druidDBSource = DruidDBSource.createInstance();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		
	}
}
