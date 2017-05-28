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

		<title>My JSP 'updatePass.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="css/login.css">


	
	</head>

	<body>
	<%String pass=(String)session.getAttribute("upass");%>
		<table align="right" style="margin-top: -13px;width: 39px">
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
		<form action="doUpdatePassServlet" method="post">
			<table align="center" style="margin-top: 130px;margin-left: 570px">
				<tr>
					<td style="width: 100px">
						原密码：
					</td>
					<td>
						<input type="text" id="oldPass" name="oldPass" class="text" onblur="oldPassValidate()"/>
					</td>
					<td style="width: 150px">
						<span id="passreminderold"></span>
					</td>
				</tr>
				<tr>
					<td>
						新密码：
					</td>
					<td>
						<input type="password" id="newPassOne" name="newPassOne"
							class="text" onblur="passValidate1()"/>
					</td>
					<td>
						<span id="passreminderone"></span>
					</td>
				</tr>
				<tr>
					<td>
						确认密码：
					</td>
					<td>
						<input type="password" id="newPassTwo" name="newPassTwo"
							class="text" onkeyup="passValidate2()"/>
					</td>
					<td>
						<span id="passsecondremindertwo"></span>
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
		<script type="text/javascript">
	function passValidate1() {
            var old = document.getElementById("oldPass").value;
            var one= document.getElementById("newPassOne").value;
            var two= document.getElementById("newPassTwo").value;
              if(one.length<6){
				document.getElementById("passreminderone").innerHTML="<font color='red'>密码不能少于6位</font>"
				document.getElementById("submit").disabled= true;
			}
			else{
				document.getElementById("passreminderone").innerHTML="<font color='green'>密码长度合法</font>"
				document.getElementById("submit").disabled= false;
			}
        }
         function oldPassValidate() {
            var old = document.getElementById("oldPass").value;
            var Pass='<%=pass%>'
            if(Pass==old){
				document.getElementById("passreminderold").innerHTML="<font color='green'>原密码正确</font>"
				document.getElementById("submit").disabled= false;
			}
            else{
				document.getElementById("passreminderold").innerHTML="<font color='red'>原密码不正确</font>"
				document.getElementById("submit").disabled= true;
			}			
        }
        function passValidate2() {
            var old = document.getElementById("oldPass").value;
            var one= document.getElementById("newPassOne").value;
            var two= document.getElementById("newPassTwo").value;
            if(one == two) {
                document.getElementById("passsecondremindertwo").innerHTML="<font color='green'>两次密码相同</font>";
                document.getElementById("submit").disabled= false;
            }
            else {
                document.getElementById("passsecondremindertwo").innerHTML="<font color='red'>两次密码不相同</font>";
                document.getElementById("submit").disabled = true;
            }
        }      
	</script>
	</body>
</html>
