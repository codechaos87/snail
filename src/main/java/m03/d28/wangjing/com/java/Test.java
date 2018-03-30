/**
 * Project Name:JAVA05_JDBC
 * File Name:Test.java
 * Package Name:com.java
 * Date:2018年3月28日上午10:19:37
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 上午10:19:37 <br/>
 * @author   wangJing
 * @version
 * @see
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Info;
//jdbc访问数据库的步骤

//1、加载JDBC驱动 Class.forname("JDBC驱动类的名称"); 
//2、与数据库建立连接 connectioncon=DriverManager.getConnection(数据连接字符串，数据库用户名，密码)
//3、发送SQL语句，并得到返回结果一旦建立连接，就使用该连接创建Statement接口的对象，并将SQL语句传递给它所连接的数据库。如果是查询操作，将会返回值类型
//     为Result的结果集。它包含执行sql查询所得的结果，如果是其他操作，将根据调用方法的不同返回布尔值或操作影响的数据记录数目。 Statement
//     stmt =con.creatStatement(); Resultrs=stmt.execueteQuery("select id ,name from **") 
//4、处理返回结果
//      返回结果主要是针对查询操作返回的结果集，通过循环取出结果集中每条记录并做相应处理

public class Test {

    /**
     * 功能：连接数据库
     */
    //
    //
    //
    //

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test tt = new Test();
        List<Info> list = tt.getAllInfo();
        for (Info ff : list) {
            System.out.println(ff.getId() + "\t" + ff.getName() + "\t" + ff.getAge());
        }
    }

    //
    //
    //
    //

    Connection con = null;// 连接通：马路 负责连接数据库并担任传输数据的任务

    // Statement stm=null; 预编译 由connection产生 负责执行SQL语句

    PreparedStatement pst = null;// Statement的子接口 也由connection产生 ，同样负责执行SQL语句，
                                 // 比Statement接口具有更高安全性，高性能，高可读性和高可维护性

    ResultSet rs = null;// 结果集 负责保存和处理Statement执行后所产生的查询结果

    private String url = "jdbc:mysql://localhost:3307/mydata";

    // 连接方法
    public Connection getCon() {
        try {
            // 1、加载JDBC驱动 Class.forname("JDBC驱动类的名称");
            Class.forName("com.mysql.jdbc.Driver");
            // 驱动管理器
            // 2、与数据库建立连接 connection con
            // =DriverManager.getConnection(数据连接字符串，数据库用户名，密码)

            // DriverManager类 装载驱动程序 并为创建新的数据库连接提供支持。
            con = DriverManager.getConnection(url, "root", "root");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return con;
    }

    // 查询的方法
    public List<Info> getAllInfo() {
        // 创建一个集合 等会儿查询出来了放到这个集合里
        List<Info> list = new ArrayList<Info>();
        try {
            // 3、发送SQL语句，并得到返回结果
            String sql = "SELECT * FROM info";
            pst = getCon().prepareStatement(sql);
            // 执行
            rs = pst.executeQuery();// 这里是查询 进行其他操作时不一样
            // 4、处理返回结果
            while (rs.next()) {
                Info ff = new Info();
                ff.setId(rs.getInt("id"));
                ff.setName(rs.getString("name"));
                ff.setAge(rs.getInt("age"));
                list.add(ff);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return list; //返回集合里的东西 就是数据表
     }
}
