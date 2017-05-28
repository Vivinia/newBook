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

		<title>My JSP 'register.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="css/register.css">


		<script>
function chkData() {
	var uname = document.getElementById("uname").value;
	var upass = document.getElementById("upass").value;
	var uspass = document.getElementById("uspass").value;

	if (uname == "") {
		document.getElementById("namereminder").innerHTML = "<font color='red'>请输入用户名</font>"
		uname.focus();
		return false;
	}
	if (upass == "") {
		document.getElementById("passreminder").innerHTML = "<font color='red'>请输入密码</font>"
		upass.focus();
		return false;
	}

	if (uspass == "") {
		document.getElementById("passsecondreminder").innerHTML = "<font color='red'>请填写重复密码</font>"
		confirmpass.focus();
		return false;
	}
	return true;
}

function passValidate1() {
	var UserPass = document.getElementById("upass").value;
	var UserPassSecond = document.getElementById("uspass").value;
	if (UserPass.length < 6) {
		document.getElementById("passreminder").innerHTML = "<font color='red'>密码不能少于6位</font>"
		document.getElementById("submit").disabled = true;
	} else {
		document.getElementById("passreminder").innerHTML = "<font color='green'>密码长度合法</font>"
		document.getElementById("submit").disabled = false;
	}
}
function passValidate2() {
	var UserPass = document.getElementById("upass").value;
	var UserPassSecond = document.getElementById("uspass").value;
	if (UserPass == UserPassSecond) {
		document.getElementById("passsecondreminder").innerHTML = "<font color='green'>两次密码相同</font>";
		document.getElementById("submit").disabled = false;
	} else {
		document.getElementById("passsecondreminder").innerHTML = "<font color='red'>两次密码不相同</font>";
		document.getElementById("submit").disabled = true;
	}
}
function nameValidate() {
	var uname = document.getElementById("uname");
	var strUname = uname.value;
	for ( var i = 0; i < strUname.length; i++) {
		var myChar = strUname.toLowerCase().charAt(i);
		if (!(myChar >= 'a' && myChar <= 'z')
				&& !(myChar >= '0' && myChar <= '9') && (myChar != '_')) {
			document.getElementById("namereminder").innerHTML = "<font color='red'>用户名格式非法</font>"
			document.getElementById("submit").disabled = true;
		} else {
			document.getElementById("namereminder").innerHTML = "<font color='green'>用户名格式合法</font>"
			document.getElementById("submit").disabled = false;
		}
	}
}
</script>
	</head>

	<body>
		<p align="right">
			<a href="index.jsp">退出</a>
		</p>
		<form action="doRegisterServlet" method="post"
			onsubmit="return chkData();">
			<table style="margin-top: 170px;margin-left: 565px">
				<tr>
					<td>
						用户名：
					</td>
					<td>
						<input type="text" id="uname" name="uname" placeholder="请输入用户名"
							onblur="nameValidate()" class="text" />
					</td>
					<td>
						<span id="namereminder"></span>
					</td>
				</tr>
				<tr>
					<td>
						密码：
					</td>
					<td>
						<input type="password" id="upass" name="upass" placeholder="请输入密码"
							onblur="passValidate1()" class="text" />
					</td>
					<td>
						<span id="passreminder"></span>
					</td>
				</tr>
				<tr>
					<td>
						验证密码：
					</td>
					<td>
						<input type="password" id="uspass" name="uspass"
							placeholder="请再次输入密码" onblur="passValidate2()" class="text" />
					</td>
					<td>
						<span id="passsecondreminder"></span>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" id="submit" value="确定" class="button" />
						<input type="reset" id="reset" value="重置" class="button" />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<a href="login.jsp" class="login">已有账号</a>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
