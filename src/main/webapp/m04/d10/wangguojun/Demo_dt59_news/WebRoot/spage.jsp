
<%@page import="java.awt.List"%>
<%@page import="com.dt59.entity.Page"%>
<%@page import="com.dt59.service.impl.BizServiceImpl"%>
<%@page import="com.dt59.dao.impl.BizDaoImpl"%>
<%@page import="com.dt59.dao.BizDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String currentpage =request.getParameter("currentpage");
	Page page2=new Page();
	page2.setCurrentge(Integer.parseInt(currentpage));
	BizDaoImpl bdi=new BizDaoImpl();
	BizServiceImpl bsi=new BizServiceImpl();
	bsi.setBizDao(bdi);//注入
	bsi.getNewsInfoByPage(page2);
	//request.setAttribute("listpage",List);
	//request.setAttribute("listpage", List);
	request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
%>
</body>
</html>