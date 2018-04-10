/**
 * Project Name:snail
 * File Name:Test.java
 * Package Name:m03.d27.guojin
 * Date:2018年3月27日下午4:36:58
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d27.chenyang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: <br/>
 * Date: 2018年3月27日 下午4:36:58 <br/>
 * 
 * @author GUO
 * @version
 * @see
 */
public class Test {

    public static void main(String[] args) {
        Test tt = new Test();
        List<Info> list = tt.getAllInfo();
        for (Info ff : list) {
            System.out.println(ff.getCid() + "\t" + ff.getCname() + "\t" + ff.getPname());
        }
    }

    Connection conn = null;

    PreparedStatement pst = null;

    ResultSet rs = null;

    private String url = "jdbc:mysql://localhost:3306/mydata";

    public Connection getCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "root");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return conn;
    }

    public List<Info> getAllInfo() {
        List<Info> list = new ArrayList<Info>();
        try {
            String sql = "SELECT b.`cid`,b.`cname`,a.`pname` FROM province a INNER JOIN city b ON a.`pid`=b.`pid`";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Info ff = new Info();
                ff.setCid(rs.getInt("cid"));
                ff.setCname(rs.getString("cname"));
                ff.setPname(rs.getString("pname"));
                list.add(ff);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(conn, pst, rs);
        }
        return list;
    }

    public void close(Connection conn, PreparedStatement pst, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (rs != null) {
                rs.close();
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
