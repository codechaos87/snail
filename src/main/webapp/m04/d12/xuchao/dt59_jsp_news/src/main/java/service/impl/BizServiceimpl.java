/**
 * Project Name:dt59_jsp_news
 * File Name:BizServiceimpl.java
 * Package Name:main.java.service.impl
 * Date:2018年4月7日下午7:04:14
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package main.java.service.impl;

import java.util.List;

import main.java.dao.BizDao;
import main.java.entity.CommentInfo;
import main.java.entity.NewsInfo;
import main.java.entity.PageLimit;
import main.java.entity.UserInfo;
import main.java.service.BizService;

/**
 * Description: <br/>
 * Date: 2018年4月7日 下午7:04:14 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class BizServiceimpl implements BizService {

    private BizDao bizDao;

    public BizDao getBizDao() {
        return bizDao;
    }

    public void setBizDao(BizDao bizDao) {
        this.bizDao = bizDao;
    }

    @Override
    public boolean validateUser(UserInfo user) {
        return bizDao.validateUser(user);
    }

    @Override
    public List<NewsInfo> getNews() {
        return bizDao.getNews();
    }

    @Override
    public int delNews(int id) {
        return bizDao.delNews(id);
    }

    @Override
    public List<CommentInfo> getCommentInfo() {
        return bizDao.getCommentInfo();
    }

    @Override
    public int updateNews(NewsInfo info) {
        return bizDao.updateNews(info);
    }

    @Override
    public int insertNews(NewsInfo info) {
        return bizDao.insertNews(info);
    }

    @Override
    public List<NewsInfo> limitPages(PageLimit pageLimit) {
        return bizDao.limitPages(pageLimit);
    }

    @Override
    public int totalPageSize() {
        return bizDao.totalPageSize();
    }

}
