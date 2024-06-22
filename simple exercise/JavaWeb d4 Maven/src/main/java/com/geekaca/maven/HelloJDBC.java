package com.geekaca.maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloJDBC {
    public static void main(String[] args) throws ClassNotFoundException {
        //1， 注册驱动
        // 反射
        Class.forName("com.mysql.jdbc.Driver");
        //2. 指定连接字符串  固定协议格式 获取连接
        /**
         * 127.0.0.1  localhost 本机
         * test db name
         * useSSL=false 使用用户名密码连接，就需要加上这个配置
         */
        String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            //3. 定义sql  更新
            String sql = "update tb_user set password = 'aaaaaa' where id = 1";
            System.out.println(sql);
            //4. 获取执行sql的对象 Statement
            //会话
            Statement stmt = conn.createStatement();
            //5. 执行sql
            //受影响的行数
            /**
             * 更新类
             * delete
             * update
             * insert
             */
            int count = stmt.executeUpdate(sql);
            //6. 处理结果
            System.out.println("影响的记录条数:" + count);
            //7. 释放资源
            stmt.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
