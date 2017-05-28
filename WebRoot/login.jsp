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

		<title>My JSP 'login.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="css/login.css">


		<script type="text/javascript">
function judge() {
	var uname = document.getElementById("uname").value;
	var upass = document.getElementById("upass").value;
	if (uname == "") {
		document.getElementById("namereminder").innerHTML = "<font color='red'>请输入用户名</font>"
		uname.focus();
		return false;
	}
	if(upass=="") {
		document.getElementById("passreminder").innerHTML = "<font color='green'>请输入密码</font>"
		upass.focus();
		return false;
	}
	return true;
}
</script>
	</head>

	<body>
		<%
			String username = ""; //定义变量，获取Cookie值
			String userpass = "";
			Cookie[] cookies = request.getCookies(); //获取Cookie的对象
			if (cookies != null && cookies.length > 0) { //如果Cookie对象不为空，说明曾经保存过用户名和密码
				for (Cookie c : cookies) { //遍历Cookie对象
					if (c.getName().equals("username")) { //如果找到键为username的Cookie
						username = c.getValue(); //将用户名Cookie解码并赋值到字符串username中
					}
					if (c.getName().equals("userpass")) { //如果找到键为userpass的Cookie
						userpass = c.getValue(); //将密码Cookie赋值到字符串userpass中
					}
				}
			}
		%>


		<p align="right">
			<a href="index.jsp">退出</a>
		</p>

		<form method="post" action="doLoginServlet"  onsubmit="return judge();">
			<table align="center" style="margin-top: 170px;margin-left: 575px">
				<tr>
					<td>
						用户名:
					</td>
					<td>
						<input type="text" id="uname" name="uname" value="<%=username%>"
							class="text" />
					</td>
					<td>
						<span id="namereminder"></span>
					</td>
				</tr>
				<tr style="height: 50px">
					<td>
						密&nbsp;&nbsp;码:
					</td>
					<td>
						<input type="password" id="upass" name="upass"
							value="<%=userpass%>" class="text" />
					</td>
					<td>
						<span id="passreminder"></span>
					</td>
				</tr>
				<tr>
					<td align="left">
						<input type="checkbox" id="remenber" name="remenber" />
						记住密码
					</td>
					<td align="right">
						<a href="register.jsp" class="register">注册账号</a>
					</td>

				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" id="submit" value="登录" class="button" />
						<input type="reset" id="reset" value="重置" class="button" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
