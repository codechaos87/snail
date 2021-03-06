/**
 * Project Name:dt59_jsp_news
 * File Name:BizDao.java
 * Package Name:main.java.dao
 * Date:2018年4月7日下午4:52:43
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m04.d03.xuchao.dao;

import java.util.List;

import m04.d03.xuchao.entity.NewsInfo;
import m04.d03.xuchao.entity.UserInfo;

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
}
