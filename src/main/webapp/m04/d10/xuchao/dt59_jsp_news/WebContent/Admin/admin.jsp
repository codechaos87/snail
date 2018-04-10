<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<%@ page import="main.java.dao.impl.BizDaoimpl" %>
<%@ page import="main.java.service.impl.BizServiceimpl" %>
<%@ page import="main.java.entity.NewsInfo" %>
<%@ page import="main.java.entity.PageLimit" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath %>">
	<title>admin</title>
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
  <div id="status">管理员：<%=session.getAttribute("uname") %> 登录  &#160;&#160;&#160;&#160; <a href="/index.html">login out</a></div>
  <div id="channel"> </div>
</div>
<div id="main">
  <div id="opt_list">
    <ul>
      <li><a href="Admin/news_add.jsp">添加新闻</a></li>
      <li><a href="admin.html">编辑新闻</a></li>
      <li><a href="topic_add.html">添加主题</a></li>
      <li><a href="topic_list.html">编辑主题</a></li>
    </ul>
  </div>
  <div id="opt_area">
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
    <script language="javascript">
	/* function clickdel(){
		return confirm("删除请点击确认");
	} */
		function del(id){
			//alert(id);
			window.location.href="del.jsp?id="+id;
		};
		/* function xiugai(id){
			window.location.href="modify.jsp?id="+id;
		}; */
	</script>
    <ul class="classlist">
      <!-- <li> 深足教练组：说我们买球是侮辱 朱广沪常暗中支招 <span> 作者：
        sport                                             
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>删除</a> </span>
      </li> -->
      <%
      		request.setCharacterEncoding("utf-8");
	      	PageLimit pageLimit =(PageLimit)request.getAttribute("pageLimit");
	        /* BizDaoimpl bdi = new BizDaoimpl();
			BizServiceimpl bsi = new BizServiceimpl();
			bsi.setBizDao(bdi); */ 
      		List<NewsInfo> listNews = (List<NewsInfo>)request.getAttribute("listPage");
      		for(int i = 0;i<listNews.size();i++){
      		    out.print("<li> "+listNews.get(i).getNewsTitle()+" <span> 作者："+listNews.get(i).getNewsAuthor()+
      		            "&#160;&#160;&#160;&#160; <a href='Admin/news_modify.jsp?nid="+listNews.get(i).getNewsId()+"&ntitle="+listNews.get(i).getNewsTitle()+"&nauthor="+listNews.get(i).getNewsAuthor()+"&nsummary="+listNews.get(i).getNewsSummary()+"&ncontent="+listNews.get(i).getNewsContent()+"'>修改</a> &#160;&#160;&#160;&#160; <a href='javascript:;' onclick='del("+listNews.get(i).getNewsId()+");'>删除</a> </span></li>");
      		}
      %>
      <p align="center">
      	<a href="limitpage.jsp?currentPage=1">首页</a>&nbsp;&nbsp;&nbsp;
      	<a href="limitpage.jsp?currentPage=<%=pageLimit.getCurrentPage()-1 %>">上一页</a>&nbsp;&nbsp;&nbsp;
      	<a href="limitpage.jsp?currentPage=<%=pageLimit.getCurrentPage()+1 %>">下一页</a>&nbsp;&nbsp;&nbsp;
      	<a href="limitpage.jsp?currentPage=<%=pageLimit.getLastPage() %>">尾页</a>&nbsp;&nbsp;&nbsp;
      </p>
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