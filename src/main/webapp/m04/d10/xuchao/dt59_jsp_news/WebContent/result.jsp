<%@page import="main.java.entity.NewsInfo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<%@ page import="main.java.entity.UserInfo" %>
<%@ page import="main.java.dao.impl.BizDaoimpl" %>
<%@ page import="main.java.service.impl.BizServiceimpl" %>
<%@ page import="main.java.entity.PageLimit" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>result</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		UserInfo user = new UserInfo();
		user.setUsername(uname);
		user.setPassword(upwd);
		BizDaoimpl bdi = new BizDaoimpl();
		BizServiceimpl bsi = new BizServiceimpl();
		bsi.setBizDao(bdi);
		boolean flag = bsi.validateUser(user);
		if(flag){
		    session.setAttribute("uname", uname);
		    //session.removeAttribute("error");
		    session.setMaxInactiveInterval(60*60);//设置时间  以秒为单位
		    PageLimit pageLimit = new PageLimit();
		    pageLimit.setTotalPageSize(bsi.totalPageSize());
	  		int lastPage = pageLimit.getTotalPageSize()%pageLimit.getPageSize()==0?(pageLimit.getTotalPageSize()/pageLimit.getPageSize()):(pageLimit.getTotalPageSize()/pageLimit.getPageSize()+1);
	  		pageLimit.setLastPage(lastPage);
		    pageLimit.setCurrentPage(1);
		    List<NewsInfo> listPage = bsi.limitPages(pageLimit);
		    request.setAttribute("listPage", listPage);
		    request.setAttribute("pageLimit", pageLimit);
		    request.getRequestDispatcher("Admin/admin.jsp").forward(request, response);
		}else{
		    response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>