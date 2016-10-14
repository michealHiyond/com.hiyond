<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<script type="text/javascript" src="${jsPath}/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${jsPath}/jquery/jquery.sha1.js"></script>
<script>
function register(){
	var password = $.sha1($("#password").val().trim());
	console.log("password"+password);
	$("#password").val(password);
	$("#loginAndRegister").attr("action","/user/register.htm");
	$("#loginAndRegister").submit();
}
function login(){
	var password = $.sha1($("#password").val().trim());
	console.log("password"+password);
	$("#password").val(password);
	$("#loginAndRegister").attr("action","/user/login.htm");
	$("#loginAndRegister").submit();
}

</script>
<body>
<h2>Hello World!</h2>
	<div>
		<form action="" id="loginAndRegister" method="post">
			<input type="hidden" name="rebackUrl" value="${rebackUrl}">
			<table>
				<tr>
					<td>名字：</td>	<td><input type="text" name="name" value="${name}" id="name" /></td>
				</tr>
				<tr>
					<td>密码：</td>	<td><input type="password" name="password" value="${password}" id="password" /></td>
				</tr>
				<tr>
					<td><input type="button" value="登录" onclick="login();"/></td>
					<td><input type="button" value="注册" onclick="register();"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
