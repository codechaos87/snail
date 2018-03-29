/**
 * Project Name:DT59Team5
 * File Name:BaseDao.java
 * Package Name:m03.d28.xuchao.dao
 * Date:2018年3月28日下午1:39:14
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d29.xuchao.dao;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


/**
 * Description:   工具类 创建初始化连接 关闭以及操作增删改的方法<br/>
 * Date:     2018年3月28日 下午1:39:14 <br/>
 * @author   chaos
 * @version
 * @see
 */
public class BaseDao {
    protected Connection con=null;
    protected PreparedStatement pst = null;
    protected ResultSet rs = null;
    protected CallableStatement cst = null;
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    //静态代码块 随着类的加载而加载
    static {
        init();
    }
    
    //初始化连接数据
    public static void init(){
        Properties pro = new Properties();
        String config = "database.properties";
        try {
            //本类的字节码文件 BaseDao.class
            InputStream ist = BaseDao.class.getClassLoader().getResourceAsStream(config);
            pro.load(ist);
            driver=pro.getProperty("driver");
            url=pro.getProperty("url");
            username=pro.getProperty("username");
            password=pro.getProperty("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //连接方法 返回连接
    public Connection getCon() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
    //操作增删改
    public int controlDML(String sql,Object[] obj) {//不确定传进来的类型 用Object这个类接收
        int flag=0;
        try {
            pst=getCon().prepareStatement(sql);
            if(obj!=null) {
                for(int i=0;i<obj.length;i++) {
                    pst.setObject(i+1, obj[i]);//赋值
                }
            }
            flag=pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(con,pst,rs,cst);
        }
        return flag;
    }
    
    //关闭方法
    public void close(Connection con,PreparedStatement pst,ResultSet rs,CallableStatement cst) {
        try {
            if(cst!=null) {
                cst.close();
            }
            if(rs!=null) {
                rs.close();
            }
            if(pst!=null) {
                pst.close();
            }
            if(con!=null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

