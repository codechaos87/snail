/**
 * Project Name:wangguojun
 * File Name:BaseDao.java
 * Package Name:dao
 * Date:2018年3月28日下午4:23:25
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.wangguojun.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午4:23:25 <br/>
 * @author   wangguojun
 * @version
 * @see
 */
public class BaseDao {
    // 连接通道
    protected Connection con = null;

    // 预编译
    protected java.sql.PreparedStatement pst = null;

    // 结果集
    protected ResultSet res = null;

    static String driver;

    static String url;

    static String username;

    static String password;
    static {
        init();
    }

    public static void init() {
        Properties pro = new Properties();
        String path = "database.properties";
        try {
            InputStream ist = BaseDao.class.getClassLoader().getResourceAsStream(path);
            pro.load(ist);// 加载流
            driver = pro.getProperty(driver);
            url = pro.getProperty(url);
            username = pro.getProperty(url);
            password = pro.getProperty(password);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // 连接方法
    public Connection getCon() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return con;
    }

    public int controlDml(String sql, Object[] obj) {
        int flag = 0;
        try {
            pst = getCon().prepareStatement(sql);
            if (obj != null) {
                for (int i = 0; i < obj.length; i++) {
                    pst.setObject(i + 1, obj[i]);// 赋值
                }
            }
            flag = pst.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, res);

        }
        return flag;
    }

    public void close(Connection con2, java.sql.PreparedStatement pst2, ResultSet res2) {
        try {
            if (res != null) {
                res.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}

