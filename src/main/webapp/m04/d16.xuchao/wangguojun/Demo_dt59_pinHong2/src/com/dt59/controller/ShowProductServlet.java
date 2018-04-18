package com.dt59.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.Page;
import com.dt59.entity.Product;
import com.dt59.service.impl.BizServiceImpl;

public class ShowProductServlet extends HttpServlet {

	public ShowProductServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BizDaoImpl bizdao=new BizDaoImpl();
		BizServiceImpl bsi=new BizServiceImpl();
		bsi.setBizDao(bizdao);//为什么要注入
		//List<Product> listproduct= bsi.getAllProduct();
		int count=bsi.getProductNumber();
		Page pg=new Page();
		pg.setSumsize(count);
		pg.setLastpage(pg.getSumsize()%pg.getPagesize()==0?pg.getSumsize()/pg.getPagesize():pg.getSumsize()/pg.getPagesize()+1);
		pg.setCurrentpage(1);
		List<Product> listproduct=bsi.getAllProductByPage(pg);
		
		HttpSession session= request.getSession(false);
		session.setAttribute("listproduct", listproduct);
		session.setAttribute("pg", pg);
		request.getRequestDispatcher("Jsp_Proscenium/M_ShowProduct.jsp").forward(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
