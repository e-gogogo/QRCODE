<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
<title>忘记密码</title>
<script type="text/javascript">
	function getVerificationCode() {
		var mail = document.getElementById("Cmail").value;
		var pa2 = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if (!pa2.test(mail)) {
			alert("邮箱格式错误!");
			location.reload();
		} else {
			//ajax将邮箱传入后台			
			$.ajax({
				type : "POST", //请求的方式，默认get请求
				url : "forgetPassword", //请求地址，后台提供的
				data : {
					Cmail : mail
				},//data是传给后台的字段，后台需要哪些就传入哪些
				success : function(data) {
					alert("邮件发送成功！");
				},
				error : function(data) {
					alert("此邮箱未注册");
				}
			})
		}
	}

	function verify() {
		var mail = document.getElementById("Cmail").value;
		var code = document.getElementById("VerificationCode").value;
		var pa2 = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if (!pa2.test(mail)) {
			alert("邮箱格式错误!");
			location.reload();
		} else if (code == null) {
			alert("验证码不能为空!");
			location.reload();
		} else {
			//ajax将邮箱传入后台			
			$.ajax({
				type : "POST", //请求的方式，默认get请求
				url : "verify", //请求地址，后台提供的
				data : {
					Cmail : mail,
					Code : code
				},//data是传给后台的字段，后台需要哪些就传入哪些
				success : function(data) {
					window.location.href = 'resetPassword.jsp';
				},
				error : function(data) {
					alert("验证失败");
				}
			})
		}

	}
</script>
</head>
<body>


	<center>
		<div id="main_body">
			<div id="main_forgetPassword">
				邮箱：<input type="text" id="Cmail" value="" /><br>
				<br> <input type="text" id="VerificationCode" value="" /><br>
				<br> <input type="button" id="verification_button" value="获取验证码" onclick="getVerificationCode()"> 
					<input type="button" id="verify_button" value="确定" onclick="verify()">&nbsp;&nbsp;

			</div>
		</div>
	</center>


</body>
</html>