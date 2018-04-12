<%@page import="main.java.pinhong.entity.Product"%>
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
    
    <title>My JSP 'Right.jsp' starting page</title>
    
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
			border-left: 1px #CCCCCC dashed; 
			border-top: 1px #CCCCCC dashed;
			border-bottom: 1px #CCCCCC dashed;
		}
	</style>
  </head>
  
  <body>
	<table width="179" height="632" border="0" cellpadding="0" cellspacing="0" class="border">
	  <tr>
		<td height="42"><a href="Jsp_Proscenium/M_ShowProduct.jsp" target="_parent""><img src="Img_Proscenium/d_r11_6.jpg" width="179" height="42" border="0" /></a></td>
	  </tr>
	  <%-- <c:if test="${not empty productList}"> --%>
	
	  		<tr align="center">
	  			<td>
	  				<div id=a style="overflow:hidden; height: 632px; width: 179px;">
	  				<div id=b>
	  					  	<%-- <c:forEach items="${productList}" var="p"> --%>
	  					  	<%
	  					  		List<Product> listPro=(List<Product>)session.getAttribute("listPro");
	  					  		for(int i=0;i<listPro.size();i++){
	  					  		    out.print("<img src='Img_Proscenium/"+listPro.get(i).getpPicture()+"' width='100%' height='112' align='middle' />");
	  					  		}
	  					  	%>
	  							<%-- <img src="Img_Proscenium/${p.picture}" width="100%" height="112" align="middle" /> --%>
	  						<%-- </c:forEach> --%>
	  				</div>
	  				<div id=c></div>
	  				</div>
  					<script type="text/javascript">
						var speed=30;
							c.innerHTML=b.innerHTML;
							a.scrollTop=b.offsetHeight;
						function Marquee(){
							if(a.scrollTop<=0)
								a.scrollTop=b.offsetHeight;
							else{
								a.scrollTop--;
							}
						}
						var MyMar=setInterval(Marquee,speed);
						a.onmouseover=function() {clearInterval(MyMar)}
						a.onmouseout=function() {MyMar=setInterval(Marquee,speed);}
					</script>
				</td>
	  		</tr>
	<%--   </c:if> --%>
	</table>
  </body>
</html>
