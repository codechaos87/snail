/**
 * Project Name:dt59_jsp_news
 * File Name:BizServiceimpl.java
 * Package Name:main.java.service.impl
 * Date:2018年4月7日下午7:04:14
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m04.d03.xuchao.service.impl;

import java.util.List;

import m04.d03.xuchao.dao.BizDao;
import m04.d03.xuchao.entity.NewsInfo;
import m04.d03.xuchao.entity.UserInfo;
import m04.d03.xuchao.service.BizService;

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
}
