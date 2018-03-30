/**
 * Project Name:jdbc_01
 * File Name:BizDaoImpl.java
 * Package Name:com.class1.dao.impl
 * Date:2018年3月28日下午3:00:02
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.class1.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.class1.dao.BaseDao;
import com.class1.dao.BizDao;
import com.class1.dao.entity.Info;
import com.class1.dao.entity.Info2;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午3:00:02 <br/>
 * @author   tianyongxu
 * @version
 * @see
 */
public class BizDaoImpl extends BaseDao implements BizDao {

    @Override
    public List<Info> getAllInfo() {
         List<Info> list = new ArrayList<Info>();
         String sql="SELECT * FROM info";
            try {
                pst = getCon().prepareStatement(sql);
                rs = pst.executeQuery();
                while(rs.next()){
                    Info ff = new Info();
                    ff.setId(rs.getInt(1));
                    ff.setName(rs.getString(2));
                    ff.setAge(rs.getInt(3));
                    list.add(ff);
                }
            } catch (SQLException e) {
                
                //  Auto-generated catch block
                e.printStackTrace();
                
            }
        //  Auto-generated method stub
        return list;
    }

    @Override
    public int updateinfo(Object t) {
        
        //  Auto-generated method stub
        int flag=0;
        try {
            String sql="UPDATE info SET NAME=?,age=? WHERE id=?";
            Object[] obj=new Object[3];
            if(t instanceof Info){
                Info ff=(Info)t;//向下转型 
                obj[0]=ff.getName();
                obj[1]=ff.getAge();
                obj[2]=ff.getId();
            }
            flag=controlDml(sql,obj);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int deleteinfo(int id) {
        
        //  Auto-generated method stub
        int flag=0;
        try {
            String sql="DELETE FROM info WHERE id=?";
            Object[] obj=new Object[1];
            obj[0]=id;
            flag=controlDml(sql,obj);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int saveinfo2(Object t) {
        
        //  Auto-generated method stub
        int flag=0;
        try {
            String sql="INSERT INTO info2(NAME,birthday) VALUES(?,?)";
            Object[] obj=new Object[2];
            if(t instanceof Info2){
                Info2 ff=(Info2)t;
                obj[0]=ff.getName();
                obj[1]=ff.getBirthday();
            }
            flag=controlDml(sql,obj);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }

    }

