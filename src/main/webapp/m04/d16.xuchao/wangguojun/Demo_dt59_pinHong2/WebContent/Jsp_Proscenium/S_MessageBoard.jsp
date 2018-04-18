<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'S_MessageBoard.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body  background="Img_Background/1/bookbg.gif">
    <table align="center">
    	<tr height="165">
    		<td><iframe src="Jsp_Proscenium/MessageBoard_top.jsp" width="750" marginheight="0" scrolling="no" frameborder="0" height="100%"></iframe></td>
    	</tr>
    	<tr>
    		<td><iframe src="Jsp_Proscenium/MessageBoard_main.jsp" width="750" marginheight="0" scrolling="no" frameborder="0" height="100%"></iframe></td>
    	</tr>
    </table>
  </body>
</html>
