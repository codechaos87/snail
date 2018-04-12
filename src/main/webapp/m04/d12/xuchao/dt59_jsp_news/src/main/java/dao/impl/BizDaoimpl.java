/**
 * Project Name:dt59_jsp_news
 * File Name:BizDaoimpl.java
 * Package Name:main.java.dao.impl
 * Date:2018年4月7日下午4:56:29
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package main.java.dao.impl;

import java.util.ArrayList;
import java.util.List;

import main.java.dao.BaseDao;
import main.java.dao.BizDao;
import main.java.entity.CommentInfo;
import main.java.entity.NewsInfo;
import main.java.entity.PageLimit;
import main.java.entity.UserInfo;

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

    @Override
    public int delNews(int id) {
        int flag = 0;
        try {
            String sql = "DELETE FROM news_info WHERE news_id=?";
            pst = getCon().prepareStatement(sql);
            pst.setInt(1, id);
            flag = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return flag;
    }

    @Override
    public List<CommentInfo> getCommentInfo() {
        List<CommentInfo> listComment = new ArrayList<CommentInfo>();
        try {
            String sql = "SELECT comment_id,username,ip,content,news_id,DATE_FORMAT(fbtime,'%Y-%m-%d') AS fbtime FROM comment_info";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                CommentInfo ci = new CommentInfo();
                ci.setCommentID(rs.getInt(1));
                ci.setUsername(rs.getString(2));
                ci.setCommentIp(rs.getString(3));
                ci.setCommentContent(rs.getString(4));
                ci.setCommentNewsId(rs.getInt(5));
                ci.setFbtime(rs.getDate(6));
                listComment.add(ci);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return listComment;
    }

    @Override
    public int updateNews(NewsInfo info) {
        int flag = 0;
        try {
            String sql = "UPDATE news_info SET type_id=?,news_title=?,news_author=?,news_summary=?,news_content=? WHERE news_id=?";
            pst = getCon().prepareStatement(sql);
            pst.setInt(1, info.getTypeId());
            pst.setString(2, info.getNewsTitle());
            pst.setString(3, info.getNewsAuthor());
            pst.setString(4, info.getNewsSummary());
            pst.setString(5, info.getNewsContent());
            pst.setInt(6, info.getNewsId());
            flag = pst.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return flag;
    }

    @Override
    public int insertNews(NewsInfo info) {
        int flag = 0;
        try {
            String sql = "INSERT INTO news_info (type_id,news_title,news_author,news_summary,news_content,news_pic) VALUES(?,?,?,?,?,?)";
            pst = getCon().prepareStatement(sql);
            pst.setInt(1, info.getTypeId());
            pst.setString(2, info.getNewsTitle());
            pst.setString(3, info.getNewsAuthor());
            pst.setString(4, info.getNewsSummary());
            pst.setString(5, info.getNewsContent());
            pst.setString(6, info.getNewsPic());
            flag = pst.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return flag;
    }

    @Override
    public List<NewsInfo> limitPages(PageLimit pageLimit) {
        List<NewsInfo> listPages = new ArrayList<NewsInfo>();
        try {
            String sql = "SELECT * FROM news_info LIMIT ?,?";
            pst = getCon().prepareStatement(sql);
            pst.setInt(1, (pageLimit.getCurrentPage() - 1) * pageLimit.getPageSize());
            pst.setInt(2, pageLimit.getPageSize());
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
                listPages.add(info);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listPages;
    }

    @Override
    public int totalPageSize() {
        int sum = 0;
        try {
            String sql = "SELECT COUNT(1)AS SUM FROM news_info";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                sum = Integer.parseInt(rs.getString(1));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return sum;
    }

}
