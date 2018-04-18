package com.dt59.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.User;
import com.dt59.service.impl.BizServiceImpl;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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
		request.setCharacterEncoding("utf-8");
		String userName= request.getParameter("userName");
		String password= request.getParameter("password");
		User user=new User();
		user.setUname(userName);
		user.setUpwd(password);
		BizDaoImpl bizdao=new BizDaoImpl();
		BizServiceImpl bsi=new BizServiceImpl();
		bsi.setBizDao(bizdao);//为什么要注入
		boolean flag=bsi.validateUser(user);
		response.setCharacterEncoding("utf-8");
		PrintWriter out= response.getWriter();
		HttpSession session= request.getSession(false);
		if(flag){
			session.setAttribute("loginName", userName);//用户名
			String role= bsi.getUserRoleByName(userName, password);
			session.setAttribute("role", role);
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}else{
			out.print("<script>");
			out.print("alert('用户名或密码错误！');");
			out.print("location.href='Jsp_Proscenium/Login.jsp';");
			//out.print("location.href='init';");
			out.print("</script>");
			out.flush();//刷新
			out.close();
		}
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
