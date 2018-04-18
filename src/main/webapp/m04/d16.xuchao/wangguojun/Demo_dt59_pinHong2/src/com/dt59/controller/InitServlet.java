package com.dt59.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.News;
import com.dt59.entity.Product;
import com.dt59.service.impl.BizServiceImpl;

public class InitServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public InitServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
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
		bsi.setBizDao(bizdao);//ΪʲôҪע��
        // String cpath= request.getContextPath();
        // System.out.println("·��:------------------------->"+cpath);
        // String method= request.getMethod();//Ĭ�Ϸ�ʽ��GET
        // System.out.println("����---------------------->"+method);
        // String initparam= getInitParameter("initParam");
        // System.out.println("��ʼ������------------------------->"+initparam);
		//f1 f2 f3 ���벻ͬ����
        // String cparam= this.getServletContext().getInitParameter("cparam");
        // System.out.println("�����ĵĲ���--------------------��"+cparam);
		List<News> listnews= bsi.getAllNews();
		//request.setAttribute("listnews", listnews);
		//null true false  null=true ����һ��session   false:����һ����� ��ǰ�Ƿ���session,�����ֱ�����ã����û�вŴ���
		HttpSession session= request.getSession();
		session.setAttribute("listnews", listnews);
		List<Product> listpro=bsi.getAllProduct();
		session.setAttribute("listpro", listpro);
		//ת��
		request.getRequestDispatcher("Jsp_Proscenium/M_Index.jsp").forward(request, response);
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
