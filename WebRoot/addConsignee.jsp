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

		<title>My JSP 'addConsignee.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="css/login.css">


	</head>

	<body>
		<table align="right" style="margin-top: -13px; width: 39px">
			<tr>
				<td>
					<a href="doGetConsigneeServlet">退出</a>
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td></td>
			</tr>
		</table>
		<form action="doAddConsigneeServlet" method="post">
			<table style="margin-top: 130px;margin-left: 575px">
				<tr>
					<td>
						邮编：
					</td>
					<td>
						<input type="text" id="consigneeZipcode" name="consigneeZipcode"
							class="text" />
					</td>
				</tr>
				<tr>
					<td>
						电话：
					</td>
					<td>
						<input type="text" id="consigneePhone" name="consigneePhone"
							class="text" />
					</td>
				</tr>
				<tr>
					<td>
						地址：
					</td>
					<td>
						<input type="text" id="consigneeAddress" name="consigneeAddress"
							class="text" />
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
