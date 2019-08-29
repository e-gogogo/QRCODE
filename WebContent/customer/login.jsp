<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<meta name="viewport" content="height=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0">
<title>用户登录</title>
<style type="text/css">
body {background-color:gray}
* {
  padding: 0;
  margin: 0;
  font-family: "微软雅黑";
}
/*右边登陆框开始*/
.gcs-login {
  position: absolute;
  right: 0px;
  box-sizing: border-box;
  width: 400px;
  height:90%;
  background-color:transparent;
  z-index: 100;
}
.gcs-login .gcs-login-panel{
  height: 360px;
  position:absolute;
  margin:auto;
  left: 0;
  right:0;
  top: 0px;
  bottom: 0;
}
.gcs-login .login-title {
  text-align: center;
  color: #CC0000;
}
.gcs-login .login-title h2 {
  letter-spacing: 10px;
}
.gcs-login .login-title h3 {
  letter-spacing: 10px;
}
.gcs-login-container {
  width: 100%;
  box-sizing: border-box;
  width: 90%;
  margin: 20px 0 0;
  text-align: center;
}
.gcs-login .input {
  border: 1px solid white;
  display: inline-block;
  box-sizing: border-box;
  width: 80%;
  height: 46px;
  padding-left: 10px;
  margin: 0 auto;
  font-size: 14px;
  outline: none;
  color:  #CC0000;
}

.gcs-login .input:focus {
  outline: none;
  border: 1px solid #CC0000;
}
.gcs-login .btn-login {
  background-color: #CC0000;
  border: none;
  width: 80%;
  height: 45px;
  line-height: 45px;
  color: white;
  cursor: pointer;
  font-size: 16px;
  font-weight: bold;
}
.gcs-login .btn-login:hover{
  opacity: 0.9;
}
.forget-mm{
  display: inline-block;
  box-sizing: border-box;
  width: 80%;
  height: 16px;
  padding-left: 230px;
  margin: 0 auto;
  font-size: 14px;
  outline: none;
  color:  #FFFFFF;		
}
.register{
  display: inline-block;
  box-sizing: border-box;
  width: 80%;
  height: 16px;
  padding-left: 230px;
  margin: 0 auto;
  font-size: 14px;
  outline: none;
  color:  #FFFFFF;	
}
/*右边登陆框结束*/
</style>
</head>
<body>
<jsp:useBean id="loginBean" scope="request" class="domain.CustomerLogin"></jsp:useBean>
<c:url var="url" scope="request" value="/customer/login" />

<div class='gcs-login'>
	<div class="gcs-login-panel">
		<div class="login-title">
			<h2>欢迎登录</h2>
		</div>
		<center>
			<form:form modelAttribute="loginBean" action="${url}" method="post">
            	<p><font color="red" size="4"><form:errors /></font></p>
				
                <div class="gcs-login-container">
					<form:input path="Cname" type="text" class="input" placeholder="请输入用户名或邮箱" />
				</div>
				<div class="gcs-login-container">
					<form:input path="Cpw" type="password"  class="input" placeholder="请输入密码"/>
				</div>
				<div class="forget-mm" >
					<p>忘记密码？</p>
				</div>
				<div class="register" >
					<p> <a href="index.jsp"> 立即注册</a> </p>
				</div>
				</form:form>


		<div class="gcs-login-container">
			<input type="button" value="立即登录" class="btn-login" />
			<body background="img/background2.jpg">
		</div>
		</center>
	</div>
</div>	
</body>
</html>