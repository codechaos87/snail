<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="main.java.entity.PageLimit" %>
<%@ page import="main.java.dao.impl.BizDaoimpl" %>
<%@ page import="main.java.service.impl.BizServiceimpl" %>
<%@ page import="main.java.entity.NewsInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>分页</title>
	<%
		request.setCharacterEncoding("utf-8");
		String currentPage = request.getParameter("currentPage");
		int current=Integer.parseInt(currentPage);
		BizDaoimpl bdi = new BizDaoimpl();
		BizServiceimpl bsi = new BizServiceimpl();
		bsi.setBizDao(bdi);
		PageLimit pageLimit = new PageLimit();
		pageLimit.setTotalPageSize(bsi.totalPageSize());
  		int lastPage = pageLimit.getTotalPageSize()%pageLimit.getPageSize()==0?(pageLimit.getTotalPageSize()/pageLimit.getPageSize()):(pageLimit.getTotalPageSize()/pageLimit.getPageSize()+1);
		if(current<1){
		    current=1;
		}else if(current>lastPage){
		    current=lastPage;
		}
		pageLimit.setCurrentPage(current);
  		pageLimit.setLastPage(lastPage);
		List<NewsInfo> listPage=bsi.limitPages(pageLimit);
		request.setAttribute("listPage", listPage);
		request.setAttribute("pageLimit", pageLimit);
		request.getRequestDispatcher("Admin/admin.jsp").forward(request, response); 
	%>
</head>
<body>
</body>
</html>