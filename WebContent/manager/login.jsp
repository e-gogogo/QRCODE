<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户经理登录</title>
<style type="text/css">
body {background-color:antiquewhite}
* {
  padding: 0;
  margin: 0;
  font-family: "微软雅黑";
}
/*右边登陆框开始*/
.gcs-login {
  position: absolute;
  right: 430px;
  box-sizing: border-box;
  width: 460px;
  height: 100%;
  background-color: white;
  z-index: 100;
}
.gcs-login .gcs-login-panel{
 height: 360px;
  position:absolute;
  margin:auto;
  left: 0;
  right:0;
  top: 0;
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
  width: 100%;
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
/*右边登陆框结束*/
</style>
</head>
<body>
<jsp:useBean id="mloginBean" scope="request" class="domain.ManagerLogin"></jsp:useBean>
<c:url var="url" scope="request" value="/manager/login" />
<div class='gcs-login'>
	<div class="gcs-login-panel">
		<div class="login-title">
			<h2>营销人员登录</h2>
		</div>
		<center>
			<form:form modelAttribute="mloginBean" action="${url}" method="post">
				<p><font color="red" size="4"><form:errors /></font></p>
			<div class="gcs-login-container">
				<!--<form action="form_action.asp" method="get">-->
  				<form:input path="Mid" class="input" placeholder="请输入用户名"/>
			</div>
<!--<div class="gcs-login-container">
 <input type="text" onkeyup="value=value.replace(/\D/g,'')"   class="input" placeholder="请输入机构号" />
</div>-->
			<div class="gcs-login-container">
  				<form:password path="Mpw" class="input" placeholder="请输入密码"/>
			</div>

<br />
<br />
			<div class="gcs-login-container">
				<input type="submit" value="立即登录" class="btn-login" />
				<body background="img/20190820112137.gif">
			</div>
</center>
</form:form>
</body>
</html>