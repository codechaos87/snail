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
    
    <title>My JSP 'MessageBoard.jsp' starting page</title>
    
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
	.newMessage {
		font-size: 12px;
		font-weight: bold;
	}
	.gray {
		color: #999999;
	}
	a{
		text-decoration:none; color:#000000;
	}
	a:hover{
		text-decoration:underline; color:#FF0000;
	}
	.lt{
		border-left:#6699FF 1px solid;
		border-top:#6699FF 1px solid;
	}
	.ltr{
		border-left:#6699FF 1px solid;
		border-top:#6699FF 1px solid;
		border-right:#6699FF 1px solid;
	}
	.ltb{
		border-left:#6699FF 1px solid;
		border-top:#6699FF 1px solid;
		border-bottom:#6699FF 1px solid;
	}
	.ltrb{
		border-left:#6699FF 1px solid;
		border-top:#6699FF 1px solid;
		border-right:#6699FF 1px solid;
		border-bottom:#6699FF 1px solid;
	}
	.lb{
		border-left:#6699FF 1px solid;
		border-bottom:#6699FF 1px solid;	
	}
	.lrb{
		border-left:#6699FF 1px solid;
		border-right:#6699FF 1px solid;
		border-bottom:#6699FF 1px solid;
	}
	-->
	</style>
  </head>
  
  <body background="Img_Background/1/bookbg.gif">
    <table width="750" border="0" align="center" cellpadding="0" cellspacing="0" style="top:0;">
	  <tr>
	    <td width="12"><img src="Img_Background/1/titlemu_1.gif" width="12" height="25" /></td>
	    <td width="45" background="Img_Background/1/titlemu_2.gif"><div align="center" class="newMessage" style="margin-top:4px;"><a href="Jsp_Proscenium/MessageBoard_replay.jsp" target="_parent">新留言</a></div></td>
	    <td width="12"><img src="Img_Background/1/titlemu_3.gif" width="12" height="25" /></td>
	    <td width="681">&nbsp;</td>
	  </tr>
	  <tr>
	    <td colspan="4"><img src="Img_Background/1/T_left.gif" width="140" height="21" /><img src="Img_Background/1/Tt_bg.gif" width="554" height="21" /><img src="Img_Background/1/T_right.gif" width="56" height="21" /></td>
	  </tr>
	  <tr>
	    <td colspan="4"></td>
	  </tr>
	  <tr>
	    <td colspan="4"><table width="750" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td>
	        <table width="750" border="0" cellspacing="0" cellpadding="0" style="font-size:12px;">
	          <tr>
	            <td width="44" class="ltb"><div align="center">回复</div></td>
	            <td width="437" height="25" class="ltb"><div align="center">
	              <div align="center">标题</div>
	            </div></td>
	            <td width="133" class="ltb"><div align="center">作者</div></td>
	            <td width="136" class="ltrb"><div align="center">时间</div></td>
	          </tr>
			  <c:if test="${not empty messList}">
			  	<c:forEach items="${messList}" var="m">
	           	  <tr>
		            <td class="lb"><div align="center">${m.count }</div></td>
		            <td height="25" class="lb"><span class="gray">&nbsp;<img src="Img_Background/1/jd-to.gif" width="13" height="13" border="0" />&nbsp;<a href="NewsDetails?id=${m.messageid }" target="_parent">${m.title }</a></span></td>
		            <td class="lb"><div align="center"><span class="gray">${m.writer }</span></div></td>
		            <td class="lrb"><span class="gray">&nbsp;${m.writeDate }</span></td>
		          </tr>
			  	</c:forEach>
			  </c:if>
	        </table>
	        </td>
	      </tr>
	    </table>
	    </td>
	  </tr>
	  <tr>
	    <td colspan="4"><img src="Img_Background/1/T_bottomleft.gif" width="145" height="17" /><img src="Img_Background/1/T_bottombg.gif" width="460" height="17" /><img src="Img_Background/1/T_bottomright.gif" width="145" height="17" /></td>
	  </tr>
	</table>
  </body>
</html>
