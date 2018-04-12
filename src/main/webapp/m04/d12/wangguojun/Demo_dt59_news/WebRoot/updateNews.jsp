<%@page import="java.io.PrintWriter"%>
<%@page import="com.dt59.service.impl.BizServiceImpl"%>
<%@page import="com.dt59.dao.impl.BizDaoImpl"%>
<%@page import="com.dt59.entity.NewsInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateNews.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    	request.setCharacterEncoding("utf-8");
    	String nid= request.getParameter("nid");
    	String ntid= request.getParameter("ntid");
    	String ntitle= request.getParameter("ntitle");
    	String nauthor= request.getParameter("nauthor");
    	String nsummary= request.getParameter("nsummary");
    	String ncontent= request.getParameter("ncontent");
    	
    	NewsInfo info=new NewsInfo();
    	info.setNewsid(Integer.parseInt(nid));
    	info.setTypeid(Integer.parseInt(ntid));
    	info.setNewstitle(ntitle);
    	info.setNewsauthor(nauthor);
    	info.setNewssummary(nsummary);
    	info.setNewscontent(ncontent);
    	
    	BizDaoImpl bdi=new BizDaoImpl();
    	BizServiceImpl bsi=new BizServiceImpl();
    	bsi.setBizDao(bdi);//注入
    	int flag=bsi.updateNewsInfo(info);
    	if(flag>0){
    		//弹个窗体出来
    		PrintWriter pw= response.getWriter();
    		//通过io流的方式输出
    		pw.write("<script>");
    		pw.write("alert('修改成功！');");
    		pw.write("window.location.href='result.jsp?name=admin&pwd=123';");
    		pw.write("</script>");
    		//response.sendRedirect("result.jsp?name=admin&pwd=123");
    	}else{
    		response.sendRedirect("index.jsp");
    	}
     %>
  </body>
</html>
