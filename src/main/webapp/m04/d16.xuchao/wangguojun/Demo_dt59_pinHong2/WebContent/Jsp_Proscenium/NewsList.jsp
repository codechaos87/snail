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
    
    <title>My JSP 'NewsList.jsp' starting page</title>
    
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
	.newsList {
		font-size: 18px;
		font-weight: bold;
	}
	a{text-decoration:none; color:#999999; font-size:13px;}
	a:hover{text-decoration:underline; color:#FF0000; font-size:13px;}
	-->
	</style>
  </head>
  
  <body>
	<table width="613" height="410" border="0" cellpadding="0" cellspacing="0" style="font-size:13px; color:#999999;">
	  <tr>
	    <td width="10">&nbsp;</td>
	    <td colspan="4"><span class="newsList">新闻列表</span></td>
	  </tr>
	  <c:if test="${not empty allNewsList}">
	  	<c:forEach items="${allNewsList}" var="n" varStatus="vs">
		  <tr>
		    <td width="10">&nbsp;</td>
		    <td width="70">&nbsp;${vs.index+1 }</td>
		    <td colspan="3"><a href="News?id=${n.newsID }" target="_parent">${n.title }&nbsp;&nbsp;&nbsp;[${n.writerDate }]</a></td>
		  </tr>
	  	</c:forEach>
	  </c:if>
	  <tr>
	    <td width="10">&nbsp;</td>
	    <td width="70">&nbsp;</td>
	    <td width="344">&nbsp;</td>
	    <td width="131"><div align="right"><a href="Jsp_Proscenium/M_ShowNews.jsp" target="_parent" style="text-decoration:none; color:#999999; font-size:13px;">上一页</a> | <a href="Jsp_Proscenium/M_ShowNews.jsp" target="_parent" style="text-decoration:none; color:#999999; font-size:13px;">下一页</a></div></td>
	    <td width="30">&nbsp;</td>
	  </tr>
	</table>
  </body>
</html>
