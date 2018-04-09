/**
 * Project Name:dt59_jsp_news
 * File Name:BizDaoimpl.java
 * Package Name:main.java.dao.impl
 * Date:2018年4月7日下午4:56:29
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m04.d03.xuchao.dao.impl;

import java.util.ArrayList;
import java.util.List;

import m04.d03.xuchao.dao.BaseDao;
import m04.d03.xuchao.dao.BizDao;
import m04.d03.xuchao.entity.NewsInfo;
import m04.d03.xuchao.entity.UserInfo;

/**
 * Description: <br/>
 * Date: 2018年4月7日 下午4:56:29 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class BizDaoimpl extends BaseDao implements BizDao {

    @Override
    public boolean validateUser(UserInfo user) {
        boolean flag = false;
        try {
            String sql = "SELECT * FROM user_info WHERE username=? AND PASSWORD=?";
            pst = getCon().prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            rs = pst.executeQuery();
            while (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return flag;
    }

    @Override
    public List<NewsInfo> getNews() {
        List<NewsInfo> listNews = new ArrayList<NewsInfo>();
        try {
            String sql = "SELECT * FROM news_info";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                NewsInfo info = new NewsInfo();
                info.setNewsId(rs.getInt(1));
                info.setTypeId(rs.getInt(2));
                info.setNewsTitle(rs.getString(3));
                info.setNewsAuthor(rs.getString(4));
                info.setNewsSummary(rs.getString(5));
                info.setNewsContent(rs.getString(6));
                info.setNewsPic(rs.getString(7));
                listNews.add(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return listNews;
    }
}
