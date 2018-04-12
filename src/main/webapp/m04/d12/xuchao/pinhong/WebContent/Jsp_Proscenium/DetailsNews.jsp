<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'DetailsNews.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	<!--
	.title {
		font-size: 16px;
		font-weight: bold;
	}
	#Layer1 {
		position:absolute;
		width:523px;
		height:200px;
		z-index:1;
		left: 50px;
		top: 87px;
	}
	.date {
		color: #999999;
		font-size: 12px;
	}
	#Layer2 {
		position:absolute;
		width:100px;
		height:12px;
		z-index:2;
		left: 480px;
		top: 380px;
	}
	-->
	</style>
  </head>
  
  <body>
	<table width="613" height="400" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td height="50" colspan="2" background="Img_Proscenium/cg2.jpg"><div align="center"><span class="title">${newsListById.title }</span></div></td>
	  </tr>
	  <tr>
	    <td height="259" colspan="2"><div id="Layer1">${newsListById.content }</div></td>
	  </tr>
	  <tr>
	    <td width="463" height="72">&nbsp;</td>
	    <td width="150"><div align="center"><img src="Img_Proscenium/n10.jpg" width="165" height="72" /></div></td>
	  </tr>
	  <tr>
	    <td height="50" colspan="2"><div id="Layer2">
	      <div align="right"><span class="date">${newsListById.writerDate }</span></div>
	    </div></td>
	  </tr>
	</table>
  </body>
</html>
