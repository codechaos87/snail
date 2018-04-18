package com.dt59.service.impl;

import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.entity.Message;
import com.dt59.entity.News;
import com.dt59.entity.Page;
import com.dt59.entity.Product;
import com.dt59.entity.User;
import com.dt59.service.BizService;

public class BizServiceImpl implements BizService{
	private BizDao bizDao;
	
	public BizDao getBizDao() {
		return bizDao;
	}

	public void setBizDao(BizDao bizDao) {
		this.bizDao = bizDao;
	}

	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		return bizDao.getAllNews();
	}

	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return bizDao.getAllProduct();
	}

	public boolean validateUser(User user) {
		// TODO Auto-generated method stub
		return bizDao.validateUser(user);
	}

	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return bizDao.getAllUser();
	}

	public String getUserRoleByName(String name, String pwd) {
		// TODO Auto-generated method stub
		return bizDao.getUserRoleByName(name, pwd);
	}

	public List<Product> getAllProductByPage(Page page) {
		// TODO Auto-generated method stub
		return bizDao.getAllProductByPage(page);
	}

	public int getProductNumber() {
		// TODO Auto-generated method stub
		return bizDao.getProductNumber();
	}

    @Override
    public List<Message> getAllMessages() {

        // Auto-generated method stub
        return bizDao.getAllMessages();
    }
	
	

}
