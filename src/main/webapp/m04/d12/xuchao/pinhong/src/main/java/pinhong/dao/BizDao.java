/**
 * Project Name:pinhong
 * File Name:BizDao.java
 * Package Name:main.java.pinhong.dao
 * Date:2018年4月12日下午7:30:48
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package main.java.pinhong.dao;
/**
 * Description:   <br/>
 * Date:     2018年4月12日 下午7:30:48 <br/>
 * @author   chaos
 * @version
 * @see
 */

import java.util.List;

import main.java.pinhong.entity.News;
import main.java.pinhong.entity.Product;

public interface BizDao {
    List<News> getAllNews();
    
    List<Product> getAllProduct();
}

