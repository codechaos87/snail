/**
 * Project Name:jdbc_01
 * File Name:BizDao.java
 * Package Name:com.class1.dao
 * Date:2018年3月28日下午3:51:42
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.class1.dao;

import java.util.List;

import com.class1.dao.entity.Info;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午3:51:42 <br/>
 * @author   tianyongxu
 * @version
 * @see
 */
public interface BizDao<T> {
    List<Info>  getAllInfo();
    int updateinfo(T t);
    int deleteinfo(int id);
    int saveinfo2(T t);
}

