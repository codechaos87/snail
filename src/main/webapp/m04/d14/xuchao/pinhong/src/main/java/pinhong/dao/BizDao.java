/**
 * Project Name:pinhong
 * File Name:BizDao.java
 * Package Name:main.java.pinhong.dao
 * Date:2018��4��12������7:30:48
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package main.java.pinhong.dao;

/**
 * Description:   <br/>
 * Date:     2018��4��12�� ����7:30:48 <br/>
 * @author   chaos
 * @version
 * @see
 */

import java.util.List;

import main.java.pinhong.entity.LimitPage;
import main.java.pinhong.entity.News;
import main.java.pinhong.entity.Product;
import main.java.pinhong.entity.Users;

public interface BizDao {
    List<News> getAllNews();

    List<Product> getAllProduct();

    boolean validateUser(Users user);

    List<Users> getAllUser();

    List<Product> limitPageProduct(LimitPage limitPage);

    int getTotalPageSize();
}
