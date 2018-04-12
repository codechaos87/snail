<%@page import="main.java.pinhong.entity.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'NewsAndCommandProduct.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		a{
			font-size:13px;
			color:#000000;
			text-decoration:none;
		}
		a:hover{
			font-size:14px;
			color:#FF0000;
			text-decoration:underline;
		}
	</style>
  </head>
  
  <body>
	<table align="center" width="620" height="230" border="0" cellpadding="0" cellspacing="0">
	  <tr height="35">
		<td width="352"><img src="Img_Proscenium/d_r7_c1.jpg" width="101" height="35" /><img src="Img_Proscenium/d02.jpg" width="157" height="35" /><img src="Img_Proscenium/d_r7_c14.jpg" width="94" height="35" /></td>
		<td rowspan="16">
			<table width="268" height="236" border="0" cellpadding="0" cellspacing="0">
			  <tr>
				<td><a href="Jsp_Proscenium/M_ShowProduct.jsp" target="_parent"><img src="Img_Proscenium/d_r11_5_r1_c1.jpg" width="268" height="60" border="0" /></a></td>
			  </tr>
			  <tr>
				<td><a href="Jsp_Proscenium/M_ShowProduct.jsp" target="_parent"><img src="Img_Proscenium/d_r11_5_r3_c1.jpg" width="268" height="60" border="0" /></a></td>
			  </tr>
			  <tr>
				<td><a href="Jsp_Proscenium/M_ShowProduct.jsp" target="_parent"><img src="Img_Proscenium/d_r11_5_r4_c1.jpg" width="268" height="60" border="0" /></a></td>
			  </tr>
			  <tr>
				<td><a href="Jsp_Proscenium/M_ShowProduct.jsp" target="_parent"><img src="Img_Proscenium/d_r11_5_r5_c1.jpg" width="268" height="60" border="0" /></a></td>
			  </tr>
			</table>
		</td>
	  </tr>
		<%-- <c:if test="${not empty newsList}">
			<c:forEach items="${newsList}" var="n"> --%>
			<%
				List<News> listNews=(List<News>)session.getAttribute("listNews");
				for(int i=0;i<listNews.size();i++){
					out.print("<tr><td height='22'>&nbsp;<a target='_parent' href='News?id=${n.newsID }'>"+listNews.get(i).getnTitle()+"&nbsp;&nbsp;&nbsp;<span style='color: red;'>["+listNews.get(i).getnDate()+"]</span></a></td></tr>");
				}
			%>
				<%-- <tr>
					<td height="22">&nbsp;<a target="_parent" href="News?id=${n.newsID }">${n.title }&nbsp;&nbsp;&nbsp;<span style="color: red;">[${n.writerDate}]</span></a></td>
				</tr> --%>
			  	<tr>
					<td><img src="Img_Proscenium/d03.jpg" width="352" height="1" /></td>
	  		 	</tr>
			<%-- </c:forEach>
		</c:if> --%>
	  <tr>
		<td><div align="right"><a href="Jsp_Proscenium/M_ShowNews.jsp" target="_parent"><img src="Img_Proscenium/d_r11_c15.jpg" width="50" height="33" border="0" /></a></div></td>
	  </tr>
	</table>
  </body>
</html>
