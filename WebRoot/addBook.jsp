<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

		<title>My JSP 'addBook.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="css/addBook.css">


	</head>

	<body>
		<p align="right">
			<a href="bookListServlet">退出</a>
		</p>
		<form method="post" action="bookAddServlet">
			<table style="margin-top: 170px;margin-left: 570px">
				<tr>
					<td>
						书名：
					</td>
					<td>
						<input type="text" id="bName" name="bName" class="text" />
					</td>
				</tr>
				<tr>
					<td>
						作者：
					</td>
					<td>
						<input type="text" id="bAuthor" name="bAuthor" class="text" />
					</td>
				</tr>
				<tr>
					<td>
						页码：
					</td>
					<td>
						<input type="text" id="bPage" name="bPage" class="text" />
					</td>
				</tr>
				<tr>
					<td>
						单价：
					</td>
					<td>
						<input type="text" id="bPrice" name="bPrice" class="text" />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" id="submit" value="确定" class="button" />

						<input type="reset" id="reset" value="重置" class="button" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
