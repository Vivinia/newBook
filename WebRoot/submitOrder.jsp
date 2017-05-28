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

		<title>My JSP 'submitOrder.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
	<link rel="stylesheet" type="text/css" href="css/submitOrder.css">
	
	</head>

	<body>
	<p align="right">
			<a href="lookCarServlet">退出</a>
		</p>
		<c:set var="total" value="${requestScope.total}"></c:set>
		<c:set var="number" value="${requestScope.number}"></c:set>
		<c:set var="name" value="${requestScope.name}"></c:set>
		<c:set var="consigneeInfo" value="${requestScope.consigneeInfo}"></c:set>
		<c:set var="uname" value="${requestScope.uname}"></c:set>
		<form action="doSubmitOrderServlet" method="post">
			<table style="margin-top: 175px;margin-left: 570px">
				<tr class="a">
					<td>
						书名：
					</td>
					<td>
						<input type="text" id="name" name="name" value="${name}" class="text" readonly />
					</td>
				</tr>
				<tr class="a">
					<td>
						数目：
					</td>
					<td>
						<input type="text" id="number" name="number" value="${number}" class="text" readonly />
					</td>
				</tr>
				<tr class="a">
					<td>
						总价：
					</td>
					<td>
						<input type="text" id="total" name="total" value="${total}" class="text" readonly />
					</td>
				</tr>
				<tr><td><input type="hidden" id="consigneeId" name="consigneeId" value="${consigneeInfo.consigneeId }"/></td></tr>
				<tr class="a" >
					<td>
						收货姓名：
					</td>
					<td>
						<input type="text" id="consigneeName" name="consigneeName"  value="${uname}" class="text"/>
					</td>
				</tr>
				
				<tr class="a">
					<td>
						邮编：
					</td>
					<td>
						<input type="text" id="consigneeZipcode" name="consigneeZipcode" value="${consigneeInfo.consigneeZipcode }" class="text"/>
					</td>
				</tr>
				<tr class="a">
					<td>
						电话：
					</td>
					<td>
						<input type="text" id="consigneePhone" name="consigneePhone" value="${consigneeInfo.consigneePhone }" class="text"/>
					</td>
				</tr>
				<tr class="a">
					<td>
						地址：
					</td>
					<td>
						<input type="text" id="consigneeAddress" name="consigneeAddress" value="${consigneeInfo.consigneeAddress }" class="text"/>
					</td>
				</tr>
				<tr class="a">
					<td colspan="2" align="center">
						<input type="submit" id="submit" value="提交订单" class="button"/>
						<input type="reset" id="reset" value="取消" class="button"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
