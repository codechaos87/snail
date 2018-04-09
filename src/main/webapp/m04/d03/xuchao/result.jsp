<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<%@ page import="m04.d03.xuchao.entity.UserInfo" %>
<%@ page import="m04.d03.xuchao.dao.impl.BizDaoimpl" %>
<%@ page import="m04.d03.xuchao.service.impl.BizServiceimpl" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title></title>
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
		    request.getRequestDispatcher("Admin/admin.jsp").forward(request, response);
		}
	%>
</body>
</html>