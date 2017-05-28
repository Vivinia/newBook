<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="org.wxy.impl.CarDaoImpl"%>
<%@page import="org.wxy.dao.ICarDao"%>
<%@page import="org.wxy.dao.IUserDao"%>
<%@page import="org.wxy.impl.UserDaoImpl"%>
<%@page import="org.wxy.entity.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'book.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="css/allbook.css">


	</head>

	<body>
		<table align="right" style="margin-top: -6px">
			<tr>
				<%
					if (session.getAttribute("user") == null) {
				%>
				<td>
					<a href="login.jsp">亲，请登录</a>
				</td>

				<%
					} else {
				%>
				<td style="width: 150px">
					亲爱的
					<a href="doGetConsigneeServlet" target="_blank"><%=session.getAttribute("uname")%></a>，
				</td>
				<td>
					<script language="javaScript">
now = new Date(), hour = now.getHours()
if (hour >= 0 && hour < 6) {
	document.write("凌晨了，该休息了！")
} else if (hour >= 6 && hour < 8) {
	document.write("早上好，心情愉快每一天！")
} else if (hour >= 8 && hour < 12) {
	document.write("上午好！")
} else if (hour >= 12 && hour < 14) {
	document.write("中午好！")
} else if (hour >= 14 && hour < 17) {
	document.write("下午好！")
} else if (hour >= 17 && hour < 19) {
	document.write("傍晚好！")
} else if (hour >= 19 && hour < 21) {
	document.write("晚上好！")
} else {
	document.write("夜深了，记得早点休息！")
}

function saveCar()
{
	drawToast("添加成功");   
}
function saveCollect()
{
	drawToast("收藏成功");   
}
function drawToast(message)
{   
	var alert = document.getElementById("toast");   
	if (alert == null)
	{   
		var toastHTML = '<div id="toast">' + message + '</div>';   
		document.body.insertAdjacentHTML('beforeEnd', toastHTML);   
	}   
	else
	{   
		alert.style.opacity = .9;  
	}   
	intervalCounter = setInterval("hideToast()", 10000);   
} 
function hideToast()
{     
	var alert = document.getElementById("toast");   
	alert.style.opacity = 0;   
	clearInterval(0);   
}  
</script>
					<%
						}
					%>
				</td>
				<td>
					<a href="lookOrderServlet">查看订单</a>
				</td>
				<td>
					<a href="lookCarServlet">查看购物车</a>
				</td>
				<td>
					<a href="lookCollectServlet">查看收藏</a>
				</td>
				<td style="width: 33px">
					<a href="index.jsp">退出</a>
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td></td>
			</tr>
		</table>
		<table align="center" style="margin-top: 160px;margin-left: 480px">
			<tr class="title">
				<td>
					书名
				</td>
				<td>
					作者
				</td>
				<td>
					页码
				</td>
				<td>
					单价
				</td>
			</tr>
			<tbody>
				<c:set var="BookList" value="${requestScope.BookList}"></c:set>
				<c:forEach items="${BookList}" var="item">
					<tr class="content">
						<td>
							${item.bookName}
						</td>
						<td>
							${item.bookAuthor}
						</td>
						<td>
							${item.bookPage}
						</td>
						<td>
							${item.bookPrice}
						</td>
						<td>
							<a href="addCarServlet?bookId=${item.bookId}" class="car" onclick="saveCar();">空</a>
							<a href="addCollectServlet?bookId=${item.bookId}" class="collect" onclick="saveCollect();">空</a>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</body>
</html>
