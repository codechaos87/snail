<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MessageBoard_top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body background="Img_Background/1/bookbg.gif">
	<table align="center" width="750">
  	  <tr>
	    <td colspan="4"><img src="Img_Background/1/welcome.jpg" width="750" height="135" /></td>
	  </tr>
	  <tr height="20">
	    <td height="20" colspan="4">
			<marquee onMouseOut=start(); onMouseOver=stop(); scrollamount=3>
				<b><font color=#000099 size="3">ª∂”≠ƒ˙ π”√&nbsp;¡Ù—‘±æ&nbsp;</font> </b>
			</marquee>
		</td>
	  </tr>
	</table>
  </body>
</html>
