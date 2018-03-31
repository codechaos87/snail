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
			<form action="reginfo.jsp" method="post" name="form1">
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<td colspan="2" align="center">Data</td>
					</tr>
					<tr>
						<td>用户名：</td>
						<td><input type="text" name="name"  value="" /></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" name="password" value="" /></td>
					</tr>
					<tr>
						<td>信息来源：</td>
						<td>
							<input type="checkbox" name="from" value="报刊" />报刊
							<input type="checkbox" name="from" value="网络" />网络
							<br />
							<input type="checkbox" name="from" value="朋友推荐" />朋友推荐
							<input type="checkbox" name="from" value="网络" />网络
						</td>
					</tr>
				</table>
				<input type="submit" name="Submit" value="提交"/>
				<input type="reset" name="Reset" value="取消" />
			</form>
		</div>
</body>
</html>