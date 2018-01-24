package lone.wolf.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Description: JDBC工具类，主要简化连接，和关闭
 * @author: hechunhui
 * @CreateTime: 2018/1/24 12:00
 * @ModifyBy:
 */
public class JdbcUtils {
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;

    static {

        try {
            ClassLoader loader = JdbcUtils.class.getClassLoader();
            InputStream in = loader.getResourceAsStream("dbcfg.properties");
            Properties prop = new Properties();
            prop.load(in);
            driverClass = prop.getProperty("driverClass");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            in.close();
        } catch (IOException e) {
            throw new ExceptionInInitializerError("获取数据库配置文件信息失败");
        }
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("驱动加载失败");
        }

    }


    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("数据库连接失败，url或用户名密码错误,请检查您的配置文件");
        }
    }

    public static void release(ResultSet rs, PreparedStatement pstm, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement("select * from teacher");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("tid"));
                System.out.println(rs.getString("tname"));
                System.out.println(rs.getString("description"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
