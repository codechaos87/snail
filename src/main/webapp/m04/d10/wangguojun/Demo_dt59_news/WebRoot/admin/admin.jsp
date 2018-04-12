<%@page import="com.dt59.entity.Page"%>
<%@page import="com.dt59.entity.NewsInfo"%>
<%@page import="com.dt59.service.impl.BizServiceImpl"%>
<%@page import="com.dt59.dao.impl.BizDaoImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
	<title>添加主题--管理后台</title>
	
<link href="CSS/admin.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
    <div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="Images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="Images/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员：<span id="sp"><%=session.getAttribute("uname") %></span> 登录  &#160;&#160;&#160;&#160; <a href="index.html">login out</a></div>
  <div id="channel"> </div>
</div>
<div id="main">
  <div id="opt_list">
    <ul>
      <li><a href="news_add.html">添加新闻</a></li>
      <li><a href="admin.html">编辑新闻</a></li>
      <li><a href="topic_add.html">添加主题</a></li>
      <li><a href="topic_list.html">编辑主题</a></li>
    </ul>
  </div>
  <div id="opt_area">
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<script language="javascript">
	function clickdel(){
		return confirm("删除请点击确认");
	}
	function del(id){
		//alert("del:"+id);
		window.location.href="resultDel.jsp?id="+id;
	}
</script>
    <ul class="classlist">
   	<%
   		/* BizDaoImpl bdi=new BizDaoImpl();
    	BizServiceImpl bsi=new BizServiceImpl();
    	bsi.setBizDao(bdi);//注入
   		List<NewsInfo> listnews= bsi.getNews(); */
   		List<NewsInfo> listnews=(List<NewsInfo>)request.getAttribute("listpage");
   		for(int i=0;i<listnews.size();i++){
   			out.print("<li>"+listnews.get(i).getNewstitle()+"<span>作者:"+
   			listnews.get(i).getNewsauthor()+"&#160;&#160;&#160;&#160; <a href='admin/news_modify.jsp?nid="+listnews.get(i).getNewsid()+"&ntitle="+listnews.get(i).getNewstitle()+"&nauthor="+listnews.get(i).getNewsauthor()+"&nsummary="+listnews.get(i).getNewssummary()+"&ncontent="+listnews.get(i).getNewscontent()+"'>修改</a> &#160;&#160;&#160;&#160; "+
   			"<a href='javascript:;' onclick='del("+listnews.get(i).getNewsid()+");'>删除</a> </span></li>");
   	}
   	 %>
     <!--  <li> 深足教练组：说我们买球是侮辱 朱广沪常暗中支招 <span> 作者：
        sport                                             
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>删除</a> </span> </li>
      -->
      <li class='space'></li>
      <%
      	Page pg=(Page)request.getAttribute("page2");
      %>
      <p align="right"> 
      <a href="spage.jsp?currentpage=1">首页</a>&nbsp;&nbsp;
       <a href="spage.jsp?currentpage=<%=(Integer)request.getAttribute("page2")-1%>">上一页</a>&nbsp;&nbsp; 
       <a href="spage.jsp?currentpage=<%=(Integer)request.getAttribute("page2")+1%>">下一页</a>&nbsp;&nbsp; 
       <a href="#">末页</a>&nbsp;&nbsp;</p>
    </ul>
  </div>
</div>
<div id="site_link"> <a href="#">关于我们</a><span>|</span> <a href="#">Aboue Us</a><span>|</span> <a href="#">联系我们</a><span>|</span> <a href="#">广告服务</a><span>|</span> <a href="#">供稿服务</a><span>|</span> <a href="#">法律声明</a><span>|</span> <a href="#">招聘信息</a><span>|</span> <a href="#">网站地图</a><span>|</span> <a href="#">留言反馈</a> </div>
<div id="footer">
  <p class="">24小时客户服务热线：010-68988888  &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a> &#160;&#160;&#160;&#160;  新闻热线：010-627488888<br />
    文明办网文明上网举报电话：010-627488888  &#160;&#160;&#160;&#160;  举报邮箱：<a href="#">jubao@jb-aptech.com.cn</a></p>
  <p class="copyright">Copyright &copy; 1999-2009 News China gov, All Right Reserver<br />
    新闻中国   版权所有</p>
</div>
  </body>
</html>
