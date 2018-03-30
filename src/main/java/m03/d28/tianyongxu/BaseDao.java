/**
 * Project Name:jdbc_01
 * File Name:BaseDao.java
 * Package Name:com.class1.dao
 * Date:2018年3月28日下午3:18:13
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.class1.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午3:18:13 <br/>
 * @author   tianyongxu
 * @version
 * @see
 */
public class BaseDao {
        Connection con = null;
        protected PreparedStatement pst = null;
        protected ResultSet rs = null;
        static String driver;
        static String url;
        static String username;
        static String userpsd;
        static {
            init();
        }
        public static void init(){//、
            try {
                Properties pro = new Properties();//连接的是配置文件；
                String path ="jdbc.properties";
                InputStream ist = BaseDao.class.getClassLoader().getResourceAsStream(path);
                pro.load(ist);
                driver=pro.getProperty("driver");
                url =pro.getProperty("url");
                username = pro.getProperty("username");
                userpsd = pro.getProperty("password");
                
            } catch (IOException e) {
                
                //  Auto-generated catch block
                e.printStackTrace();
                
            }
            
        }
        public Connection getCon(){
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(url, username, userpsd);
            } catch (ClassNotFoundException e) {
                
                //  Auto-generated catch block
                e.printStackTrace();
                
            } catch (SQLException e) {
                
                //  Auto-generated catch block
                e.printStackTrace();
                
            }
            return con;
            
        }
        public int controlDml(String sql,Object[] obj){
            int flag=0;
            try {
                pst=getCon().prepareStatement(sql);
                if (obj != null) {
                    for (int i = 0; i < obj.length; i++) {
                        pst.setObject(i+1, obj[i]);//赋值
                    }
                }
                flag=pst.executeUpdate();
            } catch (SQLException e) {
                
                //  Auto-generated catch block
                e.printStackTrace();
                
            }finally{
                close(con,pst,rs);//调用方法，创建关闭的方法；
            }
            return flag;
        }
        public void close(Connection con,PreparedStatement pst,ResultSet rs){
            try {
                if(rs!=null){
                    rs.close();
                }
                if(pst!=null){
                    pst.close();
                }
                if(con!=null){
                    con.close();
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
}

