/**
 * Project Name:数据库连接java
 * File Name:jdbc1.java
 * Package Name:数据库连接java
 * Date:2018年3月27日下午2:17:56
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d27.wangguojun.数据库连接java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * Description:   <br/>
 * Date:     2018年3月27日 下午2:17:56 <br/>
 * @author   wangguojun
 * @version
 * @see
 */
public class jdbc1 {
    @Test
    public void selectAll() throws Exception {
        // 1加载驱动Class.forName("com.mysql.jbdc.Driver");
        Class.forName("com.mysql.jdbc.Driver");
        // 2连接数据库
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "root");
        // 3写sql语句 ctrl+1强制提示
        String sql = "SELECT b.`cid`,b.`cname`,a.`pname` FROM province a INNER JOIN city b ON a.`pid`=b.`pid`;";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        // 用集合保存多条记录
        List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
        while (rs.next()) {
            Integer cid = rs.getInt("cid");
            String cname = rs.getString("cname");
            String pname = rs.getString("pname");
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("cid", cid);
            hm.put("cname", cname);
            hm.put("pname", pname);
            lists.add(hm);
        }
        for (Map<String, Object> map : lists) {
            System.err.println(map);
        }

        // 4关闭连接
        con.close();
    }
}

