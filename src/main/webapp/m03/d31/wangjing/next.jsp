<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
request.setCharacterEncoding("utf-8");
String name=request.getParameter("name");
String psw=request.getParameter("psw");
String sourse=request.getParameter("sourse");


%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
 你输入的注册信息<br>
 用户名:<%=psw %><br>
  密码:<%=psw %><br>
   信息来源:<%=sourse %><br>
   
 
 
 </div>
</body>
</html>