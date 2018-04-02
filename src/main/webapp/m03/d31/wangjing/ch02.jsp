<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
请输入注册信息<br>
<form action="next.jsp">
用户名：<input type="text" name="username"><br>
密码：<input type="password" name="psw"><br>
信息来源：<input type="checkbox" name="sourse">报刊
<input type="checkbox" name="sourse">网络<br>
<input type="checkbox" name="sourse">朋友推荐
<input type="checkbox" name="sourse">电视<br>
<input type="submit" value="提交" name="submit">
<input type="reset" value="取消" name="reset">


</form>
</div>
</body>
</html>