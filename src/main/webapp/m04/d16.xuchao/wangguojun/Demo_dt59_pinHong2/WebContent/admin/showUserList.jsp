<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>管理人员-管理</title>
		<link rel="stylesheet" type="text/css" href="../css/style_admin.css">
</head>
<body>
		<table cellspacing="1" cellpadding="4" width="100%" class="tableborder" id="table3" align="center">
			<!-- <form name="form1" action="showUserList.jsp" method="post"> -->
			<tr>
				<td colspan="3" class="header">&nbsp; 
					用户管理 
				</td>
			</tr>
			<tr>
				<td align="center" class="altbg1">
					<b>用户名</b>
				</td>
				<td align="center" class="altbg1">
					<b>身份代码</b>
				</td>
				<td align="center" class="altbg1">
					<b>操作</b>
				</td>
			</tr>
			<c:if test="${listUser!=null}">
			<c:forEach items="${listUser}" var="u">
			<tr>
				<td align="center" class="altbg2">
					${u.uname }
				</td>
				<td class="altbg2" align="center">
					${u.ustatus }
				</td>
				<c:if test="${u.uname != loginName  }">
					<td class="altbg2" align="center">
						<a href="/fuchsin/deleUser?userID=${u.uid }" onclick="return window.confirm('确定要删除该用户吗？')">删除</a>
					</td>
				</c:if>
				
			</tr>
			
			</c:forEach>
			</c:if>
			<!-- </form> -->
		</table>
</body>
</html>