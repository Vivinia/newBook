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

		<title>My JSP 'updateConsignee.jsp' starting page</title>

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
		<c:set var="consignee" value="${requestScope.consignee}"></c:set>
		<form action="submitUpdateConsigneeServlet" method="post">
			<table style="margin-top: 80px;margin-left: 570px">
				<tr>
					<td><input type="hidden" idn="consigneeId" name="consigneeId"
							value="${consignee.consigneeId }" />
					</td>
				</tr>
				<tr>
					<td>
						邮编：
					</td>
					<td>
						<input type="text" id="consigneeZipcode" name="consigneeZipcode"
							class="text" value="${consignee.consigneeZipcode }" />
					</td>
				</tr>
				<tr>
					<td>
						电话：
					</td>
					<td>
						<input type="text" id="consigneePhone" name="consigneePhone"
						class="text" value="${consignee.consigneePhone }" />
					</td>
				</tr>
				<tr>
					<td>
						地址：
					</td>
					<td>
						<input type="text" id="consigneeAddress" name="consigneeAddress"
						class="text" value="${consignee.consigneeAddress }" />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" id="submit" value="确定" class="button"/>
						<input type="reset" id="reset" value="重置" class="button"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
