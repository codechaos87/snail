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
    
    <title>My JSP 'MessageBoard_replay.jsp' starting page</title>
    
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
	.title {font-size: 12px}
	.r {
		font-size: 12px;
		font-weight: bold;
		margin-top:3px;
	}
	.contentsty {
		font-size: 14px;
	}
	.gray{
		font-size: 12px; color: #999999; 
	}
	.ltr{
		border-left: #6699FF 1px solid;
		border-top: #6699FF 1px solid;
		border-right: #6699FF 1px solid;
	}
	.lr{
		border-left: #6699FF 1px solid;
		border-right: #6699FF 1px solid;
	}
	.lrb{
		border-left: #6699FF 1px solid;
		border-right: #6699FF 1px solid;
		border-bottom: #6699FF 1px solid;
	}
	.minbold {
		font-size: 12px;
		font-weight: bold;
	}
	.red {color: #FF0000}
	.ltrbbb{
		border-left: #6699FF 1px solid;
		border-top: #6699FF 1px solid;
		border-right: #6699FF 1px solid;
		border-bottom: #999999 1px solid;
	}
	.l{
		border-left: #6699FF 1px solid;
	}
	.right{
		border-right: #6699FF 1px solid;
	}
	.lb{
		border-left: #6699FF 1px solid;
		border-bottom: #6699FF 1px solid;
	}
	.b{
		border-bottom: #6699FF 1px solid;
	}
	.rb{
		border-right: #6699FF 1px solid;
		border-bottom: #6699FF 1px solid;
	}
	-->
	</style>
  </head>
  
<body background="Img_Background/1/bookbg.gif">
	<table width="750" border="0" cellspacing="0" cellpadding="0" align="center">
	  <tr>
	    <td height="25" colspan="4"><span class="title">主题: ${messListById.title }</span></td>
	  </tr>
	  <tr>
	    <td width="12"><img src="Img_Background/1/titlemu_1.gif" width="12" height="25" /></td>
	    <td width="42" background="Img_Background/1/titlemu_2.gif"><div align="center" class="r">留言</div></td>
	    <td width="12"><img src="Img_Background/1/titlemu_3.gif" width="12" height="25" /></td>
	    <td width="684">&nbsp;</td>
	  </tr>
	  <tr>
	    <td colspan="4"><img src="Img_Background/1/T_left.gif" width="140" height="21" /><img src="Img_Background/1/Tt_bg.gif" width="554" height="21" /><img src="Img_Background/1/T_right.gif" width="56" height="21" /></td>
	  </tr>
	  <tr>
	    <td colspan="4"><table width="750" height="148" border="0" cellpadding="0" cellspacing="0">
	      <tr>
	        <td><table width="750" height="54" border="0" cellpadding="0" cellspacing="0">
	          <tr>
	            <td height="22" background="Img_Background/1/title.gif" class="ltr"><font style="font-size: 12px; font-weight: bold;">&nbsp;&nbsp;※&nbsp;&nbsp;${messListById.title }</font></td>
	          </tr>
	          <tr>
	            <td height="20" class="lr" ><p class="content">&nbsp;${messListById.content }</p></td>
	          </tr>
	          <tr>
	            <td height="100" class="lrb">&nbsp;</td>
	          </tr>
	          <tr>
	            <td height="20" class="lrb"><span class="gray">&nbsp;${messListById.writer }&nbsp;写于&nbsp;${messListById.writeDate }</span></td>
	          </tr>
	        </table></td>
	      </tr>
	    </table></td>
	  </tr>
	  <tr>
	    <td colspan="4"><img src="Img_Background/1/T_bottomleft.gif" width="145" height="17" /><img src="Img_Background/1/T_bottombg.gif" width="460" height="17" /><img src="Img_Background/1/T_bottomright.gif" width="145" height="17" /></td>
	  </tr>
	  <tr>
	    <td height="25" colspan="4">&nbsp;</td>
	  </tr>
	  <tr>
	    <td height="18" colspan="4"><table width="750" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td width="12"><img src="Img_Background/1/titlemu_1.gif" width="12" height="25" /></td>
	        <td width="60" background="Img_Background/1/titlemu_2.gif"><div align="center" class="r">回复内容</div></td>
	        <td width="12"><img src="Img_Background/1/titlemu_3.gif" width="12" height="25" /></td>
	        <td width="666">&nbsp;</td>
	      </tr>
	      <c:if test="${not empty revertListById}">
	      <c:forEach items="${revertListById}" var="re">
	      <tr>
	        <td colspan="4"><table width="750" border="0" cellspacing="0" cellpadding="0">
	            <tr>
	              <td><table width="750" height="100" border="0" cellpadding="0" cellspacing="0">
	                <tr>
	                  <td><table width="750" border="0" cellspacing="0" cellpadding="0">
	                    <tr>
	                      <td><img src="Img_Background/1/T_left.gif" width="140" height="21" /><img src="Img_Background/1/Tt_bg.gif" width="554" height="21" /><img src="Img_Background/1/T_right.gif" width="56" height="21" /></td>
	                    </tr>
	                    <tr>
	                      <td><table width="750" height="54" border="0" cellpadding="0" cellspacing="0">
	                        <tr>
	                          <td height="22" class="ltr"><p class="content">&nbsp;${re.content }</p></td>
	                        </tr>
	                        <tr>
	                          <td height="100" class="lrb" ><p class="content">&nbsp;</p></td>
	                        </tr>
	                        <tr>
	                          <td height="20" class="lrb"><span class="gray">&nbsp;${re.writer }&nbsp;写于&nbsp;${re.writeDate }</span></td>
	                        </tr>
	                      </table></td>
	                    </tr>
	                    <tr>
	                      <td><img src="Img_Background/1/T_bottomleft.gif" width="145" height="17" /><img src="Img_Background/1/T_bottombg.gif" width="460" height="17" /><img src="Img_Background/1/T_bottomright.gif" width="145" height="17" /></td>
	                    </tr>
	                    <tr>
	                      <td>&nbsp;</td>
	                    </tr>
	                  </table></td>
	                </tr>
	              </table></td>
	            </tr>
	          </table>
	         </td>
	        </tr>
	       </c:forEach>
	      </c:if>
	    </table></td>
	  </tr>
	  <tr>
	    <td height="25" colspan="4"><form id="form1" name="form1" method="get" action="Sub" target="_parent">
	      <table width="750" border="0" cellpadding="0" cellspacing="0">
	        <tr>
	          <td>
	          <table width="750" border="0" cellpadding="0" cellspacing="0">
	            <tr>
	              <td height="10" colspan="3">&nbsp;</td>
	            </tr>
	            <tr>
	              <td height="23" colspan="3" class="ltrbbb"><div align="center" class="minbold">快 速 回 复</div></td>
	            </tr>
	            <tr>
	              <td width="71" height="25" class="l">&nbsp;</td>
	              <td width="37"><span class="title">姓名：</span></td>
	              <td width="642" class="right"><label>
	                <input type="text" name="name" size="15"/><input name="messageid" type="hidden" value="${id }" size="5" />
	                </label></td>
	            </tr>
	            <tr>
	              <td class="l">&nbsp;</td>
	              <td><span class="title">内容：</span></td>
	              <td class="right"><label>
	                <textarea name="content" cols="78" rows="6"></textarea>
	              </label></td>
	            </tr>
	            <tr>
	              <td height="28" class="lb">&nbsp;</td>
	              <td class="b">&nbsp;</td>
	              <td class="rb"><label>
	                <input type="image" src="Img_Background/1/post.gif">
	              </label></td>
	            </tr>
	            <tr>
	              <td colspan="3">&nbsp;</td>
	              </tr>
	          </table></td>
	        </tr>
	      </table>
	        </form>
	    </td>
	  </tr>
	</table>
	</body>
</html>
