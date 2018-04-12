<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<%@ page import="main.java.dao.impl.BizDaoimpl" %>
<%@ page import="main.java.service.impl.BizServiceimpl" %>
<%@ page import="main.java.entity.NewsInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>modify</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String nid = request.getParameter("nid");
		String ntid = request.getParameter("ntid");
		String ntitle = request.getParameter("ntitle");
		String nauthor = request.getParameter("nauthor");
		String nsummary = request.getParameter("nsummary");
		String ncontent = request.getParameter("ncontent");
		BizDaoimpl bdi = new BizDaoimpl();
		BizServiceimpl bsi = new BizServiceimpl();
		bsi.setBizDao(bdi);
		NewsInfo info = new NewsInfo();
		info.setNewsId(Integer.parseInt(nid));
		info.setTypeId(Integer.valueOf(ntid));
		info.setNewsTitle(ntitle);
		info.setNewsAuthor(nauthor);
		info.setNewsSummary(nsummary);
		info.setNewsContent(ncontent);
		int flag=bsi.updateNews(info);
		if(flag>0){
		    response.sendRedirect("Admin/admin.jsp?uname=admin&upwd=123");
		}else{
		    response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>