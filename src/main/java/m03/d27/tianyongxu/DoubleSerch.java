/**
 * Project Name:Jdbc
 * File Name:DoubleSerch.java
 * Package Name:trim_01
 * Date:2018年3月27日下午4:17:06
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d27.tianyongxu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:   <br/>
 * Date:     2018年3月27日 下午4:17:06 <br/>
 * @author   tianyongxu
 * @version
 * @see
 */
public class DoubleSerch {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String url ="jdbc:mysql://localhost:3306/mydata";
        public Connection getCon(){
            try {
                Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动
                con = DriverManager.getConnection(url, "root", "root");//链接数据库
            } catch (ClassNotFoundException e) {
                
                //  Auto-generated catch block
                e.printStackTrace();
                
            } catch (SQLException e) {
                
                //  Auto-generated catch block
                e.printStackTrace();
                
            }
            return con;
        }
        public List<Infomation> getInfor(){
            List<Infomation> li = new ArrayList<Infomation>();
            String sql = "SELECT c.cid,p.pname,c.cname FROM province p INNER JOIN city c ON p.pid = c.pid"; 
            try {
                pst = getCon().prepareStatement(sql);
                rs =pst.executeQuery();
                while(rs.next()){
                    Infomation ff1 = new Infomation();
                    ff1.setCid(rs.getInt("cid"));
                    ff1.setPname(rs.getString("pname"));
                    ff1.setCname(rs.getString("cname"));
                    li.add(ff1);
                }
            } catch (SQLException e) {
                
                //  Auto-generated catch block
                e.printStackTrace();
                
            }
            return li;
        }
    public static void main(String[] args) {
        DoubleSerch ds = new DoubleSerch();
        List<Infomation> li =ds.getInfor();
        for (Infomation infn : li) {
            System.out.println(infn.getCid()+"\t"+infn.getPname()+"\t"+infn.getCname());
        }
    }

}

