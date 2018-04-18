<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>品红公司-站内消息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.border{
			border-left:1px #CCCCCC dashed;
			border-right:1px #CCCCCC dashed;
			border-top:1px #CCCCCC dashed;
			border-bottom:1px #CCCCCC dashed;			
		}
	</style>
	
  </head>
  
  <body>
	<table class="border" width="799" align="center" style="position: absolute; top: 0px; left: 10%;" border="0" cellpadding="0" cellspacing="0">
		<tr height="217" align="center">
			<td colspan="2" align="center">
				<iframe src="Jsp_Proscenium/Top.jsp" width="799" marginheight="0" scrolling="no" frameborder="0" height="100%"></iframe>
			</td>
		</tr>
		<tr height="30">
			<td colspan="2" style="border-bottom: #E3E3E3 1px solid;">
				<iframe src="Jsp_Proscenium/WebSrc2.jsp" width="799" marginheight="0" scrolling="no" frameborder="0" height="100%"></iframe>				
			</td>
		</tr>
		<tr height="420">
			<td style="border-right: #E3E3E3 1px solid;">
				<iframe src="Jsp_Proscenium/ShowProduct.jsp" width="186" marginheight="0" scrolling="no" frameborder="0" height="100%"></iframe>
			</td>
			<td>
				<iframe src="Jsp_Proscenium/NewsList.jsp" width="613" marginheight="0" scrolling="no" frameborder="0" height="100%"></iframe>
			</td>
		</tr>
		<tr height="30">
			<td colspan="2" align="center">
				<iframe src="Jsp_Proscenium/Bottom.jsp" width="799" marginheight="0" scrolling="no" frameborder="0" height="100%"></iframe>
			</td>
		</tr>
	</table>
  </body>
</html>
