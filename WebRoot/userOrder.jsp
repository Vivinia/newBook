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
    
    <title>My JSP 'userOrder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/userCollect.css">
	

  </head>
  
 <body>
   <p align="right">
			<a href="bookListServlet">退出</a>
		</p>
     <table style="margin-top: 175px;margin-left: 440px">
    	<tr class="title">
    	<td>商品名</td>
    	<td>总价</td>
    	<td>邮编</td>
    	<td>电话</td>
    	<td>地址</td>
    	</tr>
    	<tbody>
    		<c:set var="orderShowtList" value="${requestScope.orderShowtList}"></c:set>
    		<c:forEach items="${orderShowtList}" var="item">
    		<tr class="content">
    			<td>${item.orderBook }</td>
    			<td>${item.orderTotal }</td>
    			<td>${item.consigneeZipcode }</td>
    			<td>${item.consigneePhone }</td>
    			<td>${item.consigneeAddress }</td>
    			<td><a href="doDeleteOrderServlet?orderId=${item.orderId }" class="del">空</a></td>
    		</tr>
    		</c:forEach>
    	</tbody>
    </table>
  </body>
</html>
