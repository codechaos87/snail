<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="main.java.dao.impl.BizDaoimpl" %>
<%@ page import="main.java.service.impl.BizServiceimpl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		BizDaoimpl bdi = new BizDaoimpl();
		BizServiceimpl bsi = new BizServiceimpl();
		bsi.setBizDao(bdi);
		String id = request.getParameter("id");
		int flag=bsi.delNews(Integer.valueOf(id));
		if(flag>0){
		    response.sendRedirect("delone.jsp");
		}else{
		    response.sendRedirect("deltwo.jsp");
		}
	%>
</body>
</html>