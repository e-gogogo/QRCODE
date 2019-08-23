<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
<title>用户注册</title>
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
				url : "registerVerify", //请求地址，后台提供的
				data : {
					Cmail : mail
				},//data是传给后台的字段，后台需要哪些就传入哪些
				success : function(data) {
					alert("邮件发送成功！");
				},
				error : function(data) {
					alert("此邮箱已被注册");
				}
			})
		}
	}

	function register() {
		var mail = document.getElementById("Cmail").value;
		var code = document.getElementById("VerificationCode").value;
		var Cpw=document.getElementById("Cpw").value;
    	var reCpw=document.getElementById("reCpw").value;
    	var Cname=document.getElementById("Cname").value;
		var pa2 = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if (!pa2.test(mail)) {
			alert("邮箱格式错误!");
			location.reload();
		} else if (code == null) {
			alert("验证码不能为空!");
			location.reload();
		} else if(Cpw == null){
			alert("密码不能为空!");
			location.reload(); 
		}else if (Cpw != reCpw) {
			alert("确认密码与新密码不一致!");
			location.reload(); 
		}else if(Cname == null){
			alert("用户名不能为空!");
			location.reload(); 
		}else{
			//ajax将邮箱传入后台			
			$.ajax({
				type : "POST", //请求的方式，默认get请求
				url : "register", //请求地址，后台提供的
				data : {
					Cmail : mail,
					Code : code,
					Cpw : Cpw,
					Cname : Cname
				},//data是传给后台的字段，后台需要哪些就传入哪些
				success : function(data) {
					window.location.href = 'resetPassword.jsp';
				},
				error : function(data) {
					alert("用户名已被占用");
				}
			})
		}

	}
</script>
</head>
<body>
<div class="register">
        <div class="regTop">
            <span>用户注册</span>
            <a class="back" href="index.html">&lt;&nbsp;返回</a>
        </div>
        <div class="content">
            <div class="point">
                <span></span>
            </div>
                <div class="message">
                    <input id="Cmail" type="text" placeholder="请输入邮箱"  required/>
                    <input id="VerificationCode" type="text" placeholder="输入验证码" pattern="[0-9]{6}" required/>
                    <input type="button" id="verification_button" value="获取验证码" onclick="getVerificationCode()">
                    <input id="Cname" type="text" placeholder="请输入用户名"  required/>
                    <input id="Cpw" type="password" placeholder="请输入4-10位密码" pattern="[0-9A-Za-z]{4,10}" required/>
                    <input id="reCpw"type="password" placeholder="请再次输入密码" pattern="[0-9A-Za-z]{4,10}" required/>
                    
                </div>
                <div class="agree">
                    <input type="checkbox"/><span>&nbsp;同意&nbsp;</span><a href="default.htm">《注册协议》</a>
                </div>
                <input type="button" class="submit" id="register_button" onclick="register()">注册</button>
        </div>
    </div>
</body>
</html>