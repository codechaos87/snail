<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String psw = request.getParameter("password");
	String[] froms = request.getParameterValues("from");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table>
			<tr>
				<td align="center">
					你输入的注册信息
				</td>
			</tr>
			<tr>
				<td>
					用户名：
				</td>
				<td>
					<%=name %>
				</td>
			</tr>
			<tr>
				<td>
					密码：
				</td>
				<td>
					<%=psw %>
				</td>
			</tr>
			<tr>
				<td>
					信息来源：
				</td>
				<td>
					<%
						if(froms!=null){
						    for(String from:froms){
						        out.println(from);
						    }
						}
					%>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>