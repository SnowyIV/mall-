import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlUtil {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            //1， 注册驱动
            // 反射
            Class.forName("com.mysql.jdbc.Driver");
            //2. 指定连接字符串  固定协议格式 获取连接
            /**
             * 127.0.0.1  localhost 本机
             * test db name
             * useSSL=false 使用用户名密码连接，就需要加上这个配置
             * useServerPrepStmts 开启服务端 的预编译会话处理
             */
            String url = "jdbc:mysql://localhost:3306/employee?useSSL=false&characterEncoding=utf8&useServerPrepStmts=true";
            String username = "root";
            String password = "123456";
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
}
