<%@page import="com.jspsmart.upload.File"%>
<%@page import="java.util.UUID"%>
<%@page import="com.jspsmart.upload.SmartUpload"%>
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
    	SmartUpload su=new  SmartUpload();//实例化上传对象
    	//初始化 ServletConfig ，请求，响应
    	su.initialize(super.getServletConfig(), request, response);
    	String one="jpg,png,gif";
    	String two="exe,rar,jsp";
    	File upload;//接收文件流
    	try{
    		//设置允许上传的文件
    		su.setAllowedFilesList(one);
    		//设置 不允许上传的文件
    		su.setDeniedFilesList(two);
    		//设置文件的大小
    		su.setMaxFileSize(5*1024*1024);//5M
    		//设置格式
    		su.setCharset("utf-8");
    		//执行上传
    		su.upload();
    		//获取文件
    		//upload=su.getFiles().getFile(0);
    	    upload=su.getFiles().getFile(0);
    		String path2="upload\\";//路径
    		String filename="";//文件名
    		
    		  if(!upload.isMissing()){
    		            
    			//如果文件存在，那么获取文件名
    			//filename=upload.getFileName();
    			filename=UUID.randomUUID().toString()+".jpg";
    			path2+=filename;
    			upload.saveAs(path2, su.SAVE_VIRTUAL);
    			
    			}
    		request.setAttribute("path2", path2);
    		request.setAttribute("filename", filename);
    		request.getRequestDispatcher("show.jsp").forward(request, response);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
     %>
</body>
</html>