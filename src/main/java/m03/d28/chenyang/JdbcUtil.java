package m03.d28.chenyang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @ClassName JdbcUtil
 * @Description TODO(service层事务控制工具类)
 * @author wzciou
 * @Date 2017年12月26日 下午5:06:49
 * @version 1.0.0
 */
public class JdbcUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/homework";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static Connection conn;

    // 通过线程局部变量在service层中保存连接,在dao层中获取连接来实现事务的控制
    static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    /**
     * @Description (开启事务)
     */
    public static void beginTransaction() {
        // 创建连接
        conn = getConnection();
        try {
            // 开启事务
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 将连接对象保存到线程局部变量中
        tl.set(conn);
    }

    /**
     * @Description (提交事务)
     */
    public static void commit() {
        // 从线程局部变量中获取连接
        conn = tl.get();
        try {
            // 提交事务
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description (关闭连接)
     */
    public static void closeConnection() {
        // 从线程局部变量中获取连接
        conn = tl.get();
        try {
            // 关闭连接
            conn.close();
            // 从线程局部变量中移除
            tl.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        // 如果在线程变量中已经存在就从中获取,如果不存在就重新创建一个连接
        conn = tl.get();
        if (conn != null) {
            return conn;
        }
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
