package com.blog.dao;

import java.io.IOException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.blog.context.ApplicationContextListener;

/**
 * 创建Druid数据源实例
 * <p>单例模式</p>
 * @author 最红
 *
 */
public final class DruidDBSource {

	private static DruidDBSource instance = null;
	private static DruidDataSource druidDataSourceInstance = null;
	private static Properties jdbcProperties = new Properties();
	
	private DruidDBSource(){
		druidDataSourceInstance = new DruidDataSource();
		druidDataSourceInstance.setUrl(jdbcProperties.getProperty("jdbc.url"));
		druidDataSourceInstance.setDriverClassName(jdbcProperties.getProperty("jdbc.Driver"));
		druidDataSourceInstance.setUsername(jdbcProperties.getProperty("jdbc.user"));
		druidDataSourceInstance.setPassword(jdbcProperties.getProperty("jdbc.password"));
		druidDataSourceInstance.setInitialSize(Integer.parseInt(jdbcProperties.getProperty("jdbc.InitialSize")));
		druidDataSourceInstance.setMinIdle(Integer.parseInt(jdbcProperties.getProperty("jdbc.MinIdle")));
		druidDataSourceInstance.setMaxActive(Integer.parseInt(jdbcProperties.getProperty("jdbc.MaxActive")));
		druidDataSourceInstance.setRemoveAbandoned(Boolean.parseBoolean(jdbcProperties.getProperty("jdbc.RemoveAbandoned")));
		druidDataSourceInstance.setRemoveAbandonedTimeout(Integer.parseInt(jdbcProperties.getProperty("jdbc.RemoveAbandonedTimeout")));
		druidDataSourceInstance.setMaxWait(Integer.parseInt(jdbcProperties.getProperty("jdbc.MaxWait")));
		druidDataSourceInstance.setTimeBetweenEvictionRunsMillis(Integer.parseInt(jdbcProperties.getProperty("jdbc.TimeBetweenEvictionRunsMillis")));
		druidDataSourceInstance.setValidationQuery(jdbcProperties.getProperty("jdbc.ValidationQuery"));
		druidDataSourceInstance.setTestWhileIdle(Boolean.parseBoolean(jdbcProperties.getProperty("jdbc.TestWhileIdle")));
        druidDataSourceInstance.setTestOnBorrow(Boolean.parseBoolean(jdbcProperties.getProperty("jdbc.TestOnBorrow")));
	}
	
	/**
	 * 创建DruidDBSource实例
	 * @return {@link com.blog.dao.DruidDBSource}
	 */
	public static DruidDBSource createInstance(){
		if (instance == null) {
			return instance = new DruidDBSource();
		}
		
		return instance;
	}
	
	/**
	 * 获取数据源
	 * @return {@link com.alibaba.druid.pool.DruidDataSource}
	 */
	public DruidDataSource getDBSource(){
		return druidDataSourceInstance;
	}
	
	/**
	 * 初始化JDBC配置文件
	 * @throws IOException
	 */
	public static void initJDBCProperties() throws IOException{
		jdbcProperties.load(ApplicationContextListener.class.getResourceAsStream("/jdbc.properties"));
	}
}
