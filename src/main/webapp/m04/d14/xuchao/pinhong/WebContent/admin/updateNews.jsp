<%@ page language="java" import="java.util.*" pageEncoding="GB18030" isELIgnored="false"%>
<html>
  <head>

    
    <title>updateNews</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../css/style_admin.css">


  </head>
  
  <body>
    <form name="form1" action="" >
    	<table cellspacing="1" cellpadding="4" width="100%"  align="left" class="tableborder" id="table3">
			<tr><td colspan="2" class="header">更改新闻信息</td></tr>   
			<tr>
			<td class="altbg1">新闻编号：</td>
			<td class="altbg2"><input type="text" name="nid" size="30" readonly="readonly" value="${upnews.nid }" /></td>
			</tr> 
			<tr>
			<td class="altbg1">新闻标题：</td>
			<td class="altbg2"><input type="text" name="title" size="30" value="${upnews.ntitle }" /></td>
			</tr> 
			<tr>
			<td class="altbg1">新闻内容：</td>
			<td><textarea rows="5" cols="60" name="content">${upnews.ncontent}</textarea></td>
			</tr> 	
			<tr>
				<td class="altbg1">
				</td>
				<td class="altbg2" colspan="11">
					<input type="submit" value="提 交" name="B1" />
					&nbsp;
					<input type="reset" value="重 置" name="B2" />
				</td>
			</tr>
			
    	</table>
    
    </form>
  </body>
</html>
