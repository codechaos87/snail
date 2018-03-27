/**
 * Project Name:Demo
 * File Name:多表jdbc.java
 * Package Name:Demojdbc
 * Date:2018年3月27日上午10:36:13
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package Demojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: <br/>
 * Date: 2018年3月27日 上午10:36:13 <br/>
 * 
 * @author l
 * @version
 * @see
 */
public class 多表jdbc {

    public static void main(String[] args) {
        多表jdbc tt = new 多表jdbc();
        List<info2> list = tt.getAllInfo();
        for (info2 ff : list) {
            System.out.println(ff.getCid() + "\t" + ff.getCname() + "\t" + ff.getPname());
        }
    }

    Connection con = null;// 连接通：马路

    PreparedStatement pst = null;// 预编译

    ResultSet rs = null;// 结果集

    private String url = "jdbc:mysql://localhost:3306/mydata2";

    // 连接方法
    public Connection getCon() {
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 驱动管理器
            con = DriverManager.getConnection(url, "root", "root");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return con;
    }

    // 查询的方法
    public List<info2> getAllInfo() {
        List<info2> list = new ArrayList<info2>();
        try {
            String sql = "SELECT b.`cid`,b.`cname`,a.`pname` FROM province a INNER JOIN city b ON a.`pid`=b.`pid`;";
            pst = getCon().prepareStatement(sql);
            // 执行
            rs = pst.executeQuery();
            while (rs.next()) {
                info2 ff = new info2();
                ff.setCid(rs.getInt("cid"));

                ff.setCname(rs.getString("cname"));
                // . ff.setPid(rs.getInt("pid"));
                ff.setPname(rs.getString("pname"));
                list.add(ff);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return list;
    }
}
