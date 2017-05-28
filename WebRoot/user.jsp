<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

		<title>My JSP 'user.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="css/allbook.css">


	</head>

	<body>
		<table  align="right" style="margin-top: -12px">
			<tr>
				<td align="right">
					<a href="bookListServlet">退出</a>
				</td>
			</tr>
		</table>
		<p align="center">
			<a href="bookListServlet" style="margin-left: 180px;">书籍管理</a>
		</p>
		<table style="margin-top: 150px;margin-left:650px">
			<tr class="title">
				<td>
					用户
				</td>
			</tr>
			<tbody>
				<c:set var="userList" value="${requestScope.userList}"></c:set>
				<c:forEach items="${userList}" var="item">
					<tr class="content">
						<td>
							${item.userName}
						</td>
						<td>
							<a href="userDeleteServlet?userId=${item.userId}" class="userdel">删除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>
