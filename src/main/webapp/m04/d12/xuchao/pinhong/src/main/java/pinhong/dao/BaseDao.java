/**
 * Project Name:pinhong
 * File Name:BaseDao.java
 * Package Name:main.java.pinhong.dao
 * Date:2018年4月12日下午7:26:44
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package main.java.pinhong.dao;
/**
 * Description:   <br/>
 * Date:     2018年4月12日 下午7:26:44 <br/>
 * @author   chaos
 * @version
 * @see
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BaseDao {
    protected Connection con=null;
    protected PreparedStatement pst=null;
    protected ResultSet rs=null;
    
    public Connection getCon() {
        try {
            Context ct = new InitialContext();
            DataSource ds =(DataSource)ct.lookup("java:comp/env/chaos");
            con=ds.getConnection();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return con;
    }
}

