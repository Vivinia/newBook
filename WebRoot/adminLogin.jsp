<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminLogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/login.css">
	

  </head>
  
  <body>
  <p align="right">
			<a href="index.jsp">退出</a>
		</p>
    <form method="post" action="doLoginServlet">
    	<table style="margin-top: 170px;margin-left: 575px">
    		<tr>
    			<td>用户名:</td>
    			<td><input type="text" id="uname" name="uname" class="text"/></td>
    		</tr>
    		<tr>
    			<td>密&nbsp;&nbsp;码:</td>
    			<td><input type="password" id="upass" name="upass" class="text"/></td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center">
    				<input type="submit" id="submit" value="登录" class="button"/>
    				<input type="reset" id="reset" value="重置" class="button"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
