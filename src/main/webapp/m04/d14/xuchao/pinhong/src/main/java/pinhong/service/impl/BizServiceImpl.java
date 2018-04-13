/**
 * Project Name:pinhong
 * File Name:BizServiceImpl.java
 * Package Name:main.java.pinhong.service.impl
 * Date:2018��4��12������7:39:34
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package main.java.pinhong.service.impl;

import java.util.List;

import main.java.pinhong.dao.BizDao;
import main.java.pinhong.entity.LimitPage;
import main.java.pinhong.entity.News;
import main.java.pinhong.entity.Product;
import main.java.pinhong.entity.Users;
import main.java.pinhong.service.BizService;

/**
 * Description: <br/>
 * Date: 2018��4��12�� ����7:39:34 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class BizServiceImpl implements BizService {
    private BizDao bizDao;

    public BizDao getBizDao() {
        return bizDao;
    }

    public void setBizDao(BizDao bizDao) {
        this.bizDao = bizDao;
    }

    @Override
    public List<News> getAllNews() {
        return bizDao.getAllNews();
    }

    @Override
    public List<Product> getAllProduct() {
        return bizDao.getAllProduct();
    }

    @Override
    public boolean validateUser(Users user) {
        return bizDao.validateUser(user);
    }

    @Override
    public List<Users> getAllUser() {
        return bizDao.getAllUser();
    }

    @Override
    public List<Product> limitPageProduct(LimitPage limitPage) {
        return bizDao.limitPageProduct(limitPage);
    }

    @Override
    public int getTotalPageSize() {
        return bizDao.getTotalPageSize();
    }

}
