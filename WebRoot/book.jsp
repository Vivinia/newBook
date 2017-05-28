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

		<title>My JSP 'book.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="css/allbook.css">


	</head>

	<body>
		<table align="right" style="margin-top: -12px">
			<tr align="right">
				<td style="width: 150px">
					亲爱的
					<%=session.getAttribute("uname")%>，
				</td>
				<td style="width: 100px">
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
</script>
				</td>
				<td style="33px">
					<a href="index.jsp">退出</a>
				</td>
			</tr>
		</table>
		<p align="center">
			<a href="userListServlet" style="margin-left: 430px">用户管理</a>
		</p>
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
							<a href="bookUpdateServlet?bookId=${item.bookId}" class="pen">空</a>
							<a href="bookDeleteServlet?bookId=${item.bookId}" class="del">空</a>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5">
						<a href="addBook.jsp" class="a" style="margin-left: 190px">添加图书</a>
					</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>
