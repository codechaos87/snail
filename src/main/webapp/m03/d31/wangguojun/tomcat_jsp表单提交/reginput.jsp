<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学员注册</title>
</head>
<body>
<div align="center">
			<form name="form1" method="get" action="reginfo.jsp">
				<table>
					<tr>
						<td>用户名：</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td height="19">密码:</td>
						<td height="19"><input type="password" name="pwd"></td>
					</tr>
					<tr>
						<td>信息来源：</td>
						<td>
							<input type="checkbox" name="chanel" value="报刊" />报刊
							<input type="checkbox" name="chanel" value="网络" />网络<br />
							<input type="checkbox" name="chanel" value="朋友推荐" />朋友推荐
							<input type="checkbox" name="chanel" value="电视" />电视
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" name="submit" value="提交"/>
							<input type="submit" name="submit" value="取消"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
</body>
</html>