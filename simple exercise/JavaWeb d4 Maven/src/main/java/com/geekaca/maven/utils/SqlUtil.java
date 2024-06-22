package com.geekaca.maven.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 工具类
 */
public class SqlUtil {
    private static DataSource dataSource;
    static {
        initDatasource();
    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private static void initDatasource(){
        Properties prop = new Properties();
        try {
            InputStream ips = SqlUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            prop.load(ips);
            //4. 获取连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
