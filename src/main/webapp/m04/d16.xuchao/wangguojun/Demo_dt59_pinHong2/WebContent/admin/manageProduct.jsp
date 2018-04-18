<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>管理人员-管理</title>
		<link rel="stylesheet" type="text/css" href="../css/style_admin.css">
</head>
<body>
	<form name="form1" action="showUserList.jsp" method="post">
		<table cellspacing="1" cellpadding="4" width="100%"
			class="tableborder" id="table3">
			<tr>
				<td colspan="7" class="header"> 
					商品管理 
				</td>
			</tr>
			<tr>
				<td align="center" class="altbg1">
					<b>商品编号</b>
				</td>
				<td align="center" class="altbg1">
					<b>商品名称</b>
				</td>
				<td align="center" class="altbg1">
					<b>商品商标</b>
				</td>
				<td align="center" class="altbg1">
					<b>商品型号</b>
				</td>
				<td align="center" class="altbg1">
					<b>商品价格</b>
				</td>				
				<td align="center" class="altbg1">
					<b>修改</b>
				</td>
				<td align="center" class="altbg1">
					<b>删除</b>
				</td>
			</tr>
			
			<c:forEach items="${prods}" var="p">
			
			<tr>
				<td align="center" class="altbg2">
					${p.pid }
				</td>
				<td class="altbg2" align="center">
					${p.pname }
				</td>
				<td class="altbg2" align="center">
					${p.pbrand }
				</td>
				<td class="altbg2" align="center">
					${p.ptype }
				</td>
				<td class="altbg2"  align="center">&nbsp;
					${p.price }
				</td>
				<td class="altbg2" align="center">
					<a href="#">修改</a>
				</td>				
				<td class="altbg2" align="center">
					<a href="#" onclick="return window.confirm('确定要删除该产品信息吗？')">删除</a>
				</td>
			</tr>
			
			</c:forEach>
			
			</table>
	</form>
</body>
</html>