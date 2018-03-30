/**
 * Project Name:jdbc_03
 * File Name:BaseDao.java
 * Package Name:com.jdbc.dao
 * Date:2018年3月30日上午11:09:25
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d29.tianyongxu.dao;

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
 * Date:     2018年3月30日 上午11:09:25 <br/>
 * @author   tianyongxu
 * @version
 * @see
 */
public class BaseDao {
      private static String url = null;
      private static String username = null;
      private static String password = null;
      private static String driver =null;
      protected Connection conn = null;
      protected PreparedStatement pst = null;
      protected ResultSet rs = null;
      /** 
       * 创建一个静态方法，用来首先加载，在配置文件中的连接数据库必须的四样东西。
       * 这样在方法加载时，这四样东西已经存在，加载好，等待使用了方便使用，且降低了代码的耦合性；
       */
      static{
          //创建对象，用来找到配置文件里面的东西；properties
          Properties pros = new Properties();
          //通过将配置文件中的数据加载成流的形式，用load方法加载；
          //通过放射的机制读取文件
          InputStream ins = BaseDao.class.getClassLoader().getResourceAsStream("database.properties");
          try {
            pros.load(ins);
            //读取配置  留作备用
            driver = pros.getProperty("driver");
            url = pros.getProperty("url");
            username = pros.getProperty("username");
            password = pros.getProperty("password");
          } catch (IOException e) {
             e.printStackTrace();
          }
      }
      /**
       * 通过读取配置文件内的内容，链接好数据库   也就是开通管道
       * @throws Exception 
       */
      public Connection getCon() throws Exception{
          Class.forName(driver);
          conn =DriverManager.getConnection(url, username, password);
          return conn;
      }
       public void close(){
           if(conn != null){
               try {
                conn.close();
                
            } catch (SQLException e) {
                
                //  Auto-generated catch block
                e.printStackTrace();
                
            }
           }
       }
      
}

