<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<%@ page import="main.java.dao.impl.BizDaoimpl" %>
<%@ page import="main.java.service.impl.BizServiceimpl" %>
<%@ page import="main.java.entity.CommentInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>初始化页面</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		BizDaoimpl bdi = new BizDaoimpl();
		BizServiceimpl bsi = new BizServiceimpl();
		bsi.setBizDao(bdi);
		List<CommentInfo> listCommentInfo = bsi.getCommentInfo();
		request.setAttribute("listCommentInfo", listCommentInfo);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	%>
</body>
</html>