<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="com.jspsmart.upload.File"%>
<%@page import="com.jspsmart.upload.SmartUpload"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath %>"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>展示页面</title>
</head>
<%
	//因为enctype="multipart/form-data" 将文件通过二进制流的形式传输
	//所以request.getParameter获取不到 要用流的方式获取
	request.setCharacterEncoding("utf-8");
	SmartUpload su= new SmartUpload();
	su.initialize(super.getServletConfig(), request, response);
	File upload;
	su.setMaxFileSize(10*1024*1024);
	//设置允许的格式 不然获取不到元素
	su.setAllowedFilesList("txt,html,jpg,js");
	su.setDeniedFilesList("exe,doc");
	su.setCharset("utf-8");
	su.upload();
	String ntitle=su.getRequest().getParameter("ntitle");
	String nauthor=su.getRequest().getParameter("nauthor");
	String nsummary=su.getRequest().getParameter("nsummary");
	String ncontent=su.getRequest().getParameter("ncontent");
	upload=su.getFiles().getFile(0);
	String fileName="";
	if(!upload.isMissing()){
	    fileName=upload.getFileName();
	}
%>
<body>
	<h2>标题：<%=ntitle %></h2>
	<h2>作者：<%=nauthor %></h2>
	<h2>摘要：<%=nsummary %></h2>
	<h2>内容：<%=ncontent %></h2>
	<h2>上传的文件名是：<%=fileName %></h2>
</body>
</html>