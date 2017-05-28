<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userCar.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/userCar.css">
	

  </head>
  
  <body>
  <p align="right">
			<a href="bookListServlet">退出</a>
		</p>
    <table style="margin-top: 175px;margin-left: 495px">
    	<tr class="title">
    		<td>书名</td>
    		<td>作者</td>
    		<td>页码</td>
    		<td>单价</td>
    	</tr>
    	<tbody>
    		<c:set var="BookList" value="${requestScope.BookList}"></c:set>
    		<c:forEach items="${BookList}" var="item">
    		<tr class="content">
    			<td>${item.bookName}</td>
    			<td>${item.bookAuthor}</td>
    			<td>${item.bookPage}</td>
    			<td>${item.bookPrice}</td>
    			<td><a href="doDeleteCarServlet?bookId=${item.bookId }" class="del">空</a></td>
    		</tr>
    		</c:forEach>
    	</tbody>
    	<tr>
    		<td colspan="4" align="center"><a href="doSettleAccountServlet" class="a">结算</a></td>
    	</tr>
    </table>
  </body>
</html>
