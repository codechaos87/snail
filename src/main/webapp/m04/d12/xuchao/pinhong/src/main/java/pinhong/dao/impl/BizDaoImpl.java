/**
 * Project Name:pinhong
 * File Name:BizDaoImpl.java
 * Package Name:main.java.pinhong.dao.impl
 * Date:2018年4月12日下午7:31:16
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package main.java.pinhong.dao.impl;

import java.util.ArrayList;
import java.util.List;

import main.java.pinhong.dao.BaseDao;
import main.java.pinhong.dao.BizDao;
import main.java.pinhong.entity.News;
import main.java.pinhong.entity.Product;

/**
 * Description:   <br/>
 * Date:     2018年4月12日 下午7:31:16 <br/>
 * @author   chaos
 * @version
 * @see
 */
public class BizDaoImpl extends BaseDao implements BizDao{

    @Override
    public List<News> getAllNews() {
        List<News> listNews = new ArrayList<News>();
        try {
            String sql="SELECT * FROM news";
            pst=getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()) {
                News news = new News();
                news.setnId(rs.getInt(1));
                news.setnTitle(rs.getString(2));
                news.setnContent(rs.getString(3));
                news.setnDate(rs.getDate(4));
                listNews.add(news);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listNews;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> listPro= new ArrayList<Product>();
        try {
            String sql="SELECT * FROM product";
            pst=getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()) {
                Product pro = new Product();
                pro.setpId(rs.getInt(1));
                pro.setpName(rs.getString(2));
                pro.setpBrand(rs.getString(3));
                pro.setpModel(rs.getString(4));
                pro.setpPrice(rs.getString(5));
                pro.setpPicture(rs.getString(6));
                pro.setpDes(rs.getString(7));
                listPro.add(pro);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listPro;
    }
    
}

