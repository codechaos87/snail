/**
 * Project Name:DT59Team5
 * File Name:Test.java
 * Package Name:m03.d27.xuchao.多表查询.jdbc
 * Date:2018年3月27日下午4:38:11
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d27.xuchao.多表查询.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import m03.d27.xuchao.多表查询.entity.Info;

/**
 * Description:   <br/>
 * Date:     2018年3月27日 下午4:38:11 <br/>
 * @author   chaos
 * @version
 * @see
 */
public class Test {
    public static void main(String[] args) {
        Test tt= new Test();
        //实体类封装查询方法
        List<Info> list1 = tt.getInfo1();
        for(Info info:list1) {
            System.out.println(info.getCid()+"\t"+info.getCname()+"\t"+info.getPname());
        }
        System.out.println("===========================================================");
        //集合封装查询方法
        List<Map<String,Object>> list2 = tt.getInfo2();
        for(Map<String,Object> map:list2) {
            System.out.println(map);
        }
    }
    Connection con = null;//连接通道
    PreparedStatement pst = null;//预编译
    ResultSet rs = null;
    private String url="jdbc:mysql://localhost:3306/mydata";//连接什么位置的数据库 端口号 数据库名
                                                            //古国是本机，可以简写为jdbc:mysql:///数据库名
    //连接方法
    public Connection getCon() {
        try {
            //用反射加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            con = DriverManager.getConnection(url,"root","root");
        } catch (Exception e) {
            //  Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }
    
    //查询方法 实体类封装
    public List<Info> getInfo1(){
        List<Info> list = new ArrayList<Info>();
        try {
            String sql =
                    "SELECT b.`cid`,b.`cname`,a.`pname` FROM province a INNER JOIN city b ON a.`pid`=b.`pid`";
            pst = getCon().prepareStatement(sql);//预编译：先把sql语句带到mysql环境中检测语法错误
            rs = pst.executeQuery();//执行查询
            while(rs.next()){
                Info info = new Info();
                info.setCid(rs.getInt("b.cid"));
                info.setCname(rs.getString("b.cname"));
                info.setPname(rs.getString("a.pname"));
                list.add(info);
            }
        } catch (Exception e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }finally {
            close(con,pst,rs);
        }
        return list;
    }
    
    //查询方法 集合封装
    public List<Map<String,Object>> getInfo2() {
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        try {
            String sql=
                    "SELECT b.`cid`,b.`cname`,a.`pname` FROM province a INNER JOIN city b ON a.`pid`=b.`pid`";
            pst=getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()) {
                int cId = rs.getInt("b.cid");
                String cName = rs.getString("b.cname");
                String pName = rs.getString("a.pname");
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("pName", pName);
                map.put("cName", cName);
                map.put("cId", cId);
                list.add(map);
            }
        } catch (SQLException e) {
            //  Auto-generated catch block
            e.printStackTrace();
        }finally {
            close(con,pst,rs);
        }
        return list;
    }
    
    //关闭资源
    public void close(Connection con,PreparedStatement pst,ResultSet rs) {
        try {
            //先判空 再执行关闭资源操作
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
            // TODO: handle exception
        }
    }
}

