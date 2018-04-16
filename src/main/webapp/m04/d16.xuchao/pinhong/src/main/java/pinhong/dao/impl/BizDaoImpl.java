/**
 * Project Name:pinhong
 * File Name:BizDaoImpl.java
 * Package Name:main.java.pinhong.dao.impl
 * Date:2018��4��12������7:31:16
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package main.java.pinhong.dao.impl;

import java.util.ArrayList;
import java.util.List;

import main.java.pinhong.dao.BaseDao;
import main.java.pinhong.dao.BizDao;
import main.java.pinhong.entity.LimitPage;
import main.java.pinhong.entity.Message;
import main.java.pinhong.entity.News;
import main.java.pinhong.entity.Product;
import main.java.pinhong.entity.Users;

/**
 * Description: <br/>
 * Date: 2018��4��12�� ����7:31:16 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class BizDaoImpl extends BaseDao implements BizDao {

    @Override
    public List<News> getAllNews() {
        List<News> listNews = new ArrayList<News>();
        try {
            String sql = "SELECT * FROM news";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
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
        List<Product> listPro = new ArrayList<Product>();
        try {
            String sql = "SELECT * FROM product";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
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

    @Override
    public boolean validateUser(Users user) {
        boolean flag = false;
        try {
            String sql = "SELECT * FROM USER WHERE uname=? AND upwd=?";
            pst = getCon().prepareStatement(sql);
            pst.setString(1, user.getuName());
            pst.setString(2, user.getuPWD());
            rs = pst.executeQuery();
            while (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Users> getAllUser() {
        List<Users> listUser = new ArrayList<Users>();
        try {
            String sql = "SELECT * FROM USER";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Users user = new Users();
                user.setuId(rs.getInt(1));
                user.setuName(rs.getString(2));
                user.setuPWD(rs.getString(3));
                user.setuStatus(rs.getString(4));
                user.setuPic(rs.getString(5));
                listUser.add(user);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listUser;
    }

    @Override
    public List<Product> limitPageProduct(LimitPage limitPage) {
        List<Product> listPro = new ArrayList<Product>();
        try {
            String sql = "SELECT * FROM product LIMIT ?,?";
            pst = getCon().prepareStatement(sql);
            pst.setInt(1, (limitPage.getCurrentPage() - 1) * limitPage.getPageSize());
            pst.setInt(2, limitPage.getPageSize());
            rs = pst.executeQuery();
            while (rs.next()) {
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

    @Override
    public int getTotalPageSize() {
        int flag = 0;
        try {
            String sql = "SELECT COUNT(1) FROM product";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                flag = Integer.parseInt(rs.getString(1));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Message> getAllMessage() {
        List<Message> listMessage = new ArrayList<Message>();
        try {
            String sql = "SELECT * FROM message";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Message message = new Message();
                message.setmId(rs.getInt(1));
                message.setmTitle(rs.getString(2));
                message.setmContent(rs.getString(3));
                message.setmName(rs.getString(4));
                message.setmDate(rs.getDate(5));
                message.setrCount(rs.getInt(6));
                listMessage.add(message);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listMessage;
    }

}
