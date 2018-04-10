/**
 * Project Name:dt59_jsp_news
 * File Name:BizDao.java
 * Package Name:main.java.dao
 * Date:2018年4月7日下午4:52:43
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package main.java.dao;

import java.util.List;

import main.java.entity.CommentInfo;
import main.java.entity.NewsInfo;
import main.java.entity.PageLimit;
import main.java.entity.UserInfo;

/**
 * Description: <br/>
 * Date: 2018年4月7日 下午4:52:43 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public interface BizDao {
    boolean validateUser(UserInfo user);

    List<NewsInfo> getNews();

    int delNews(int id);

    List<CommentInfo> getCommentInfo();

    int updateNews(NewsInfo info);

    int insertNews(NewsInfo info);

    List<NewsInfo> limitPages(PageLimit pageLimit);

    int totalPageSize();
}
