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

		<title>My JSP 'editConsignee.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="css/editConsignee.css">


	</head>

	<body>
		<table align="right">
			<tr>
			<td style="width: 100px">
					<a href="updatePass.jsp">修改密码</a>
				</td>
				<td style="width: 33px">
					<a href="bookListServlet">退出</a>
				</td>
				
			</tr>
		</table>
		<table><tr><td></td></tr></table>
		<form action="saveOneConsigneeServlet">
			<table style="margin-top: 180px;margin-left: 520px">
				<tr>
					<td></td>
					<td class="td">
						邮编
					</td>
					<td class="td">
						电话
					</td>
					<td class="td">
						地址
					</td>
				</tr>
				<tbody>
					<c:set var="consigneeList" value="${requestScope.consigneeList}"></c:set>
					<c:forEach items="${consigneeList}" var="item">
						<tr class="content">
							<td>
								<input type="radio" id="selectConsignee" name="selectConsignee"
									value="${item.consigneeId }" />
							</td>
							<td>
								${item.consigneeZipcode }
							</td>
							<td>
								${item.consigneePhone }
							</td>
							<td>
								${item.consigneeAddress }
							</td>
							<td>
								<a href="doUpdateConsigneeServlet?consigneeId=${item.consigneeId}" class="pen">空</a>
							</td>
							<td>
								<a href="doDelConsigneeServlet?consigneeId=${item.consigneeId}" class="del">空</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<tr style="height: 40px">
					<td colspan="4" align="center"><a href="addConsignee.jsp"  class="a">添加收货信息</a></td>
				</tr>
				<tr style="height: 40px">
					<td colspan="4" align="center">
						<input type="submit" id="submit" class="button" value="确定" />
						<input type="reset" id="reset" class="button" value="重置" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
