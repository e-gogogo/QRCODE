<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
<jsp:useBean id="loginBean" scope="request" class="domain.CustomerLogin"></jsp:useBean>
<c:url var="url" scope="request" value="/customer/login" />
	<center>
		<div id="main_body">
			<div id="main_login">
				<form:form modelAttribute="loginBean" action="${url}" method="post">
					<p><font color="red" size="4"><form:errors /></font></p>
					<table>
						<tr id = "login_username">
							<td><form:input path="Cname" id = "login_Cname" value = ""/><br><br></td>
							<td><font color="red" id = "login_Cname_error" size="4"><form:errors path="Cname" /></font><br><br></td>
						</tr>
						<tr id = "login_password">
							<td><form:password path="Cpw" id = "login_Cpw" value = ""/><br><br></td>
							<td><font color="red" id = "login_Cpw_error" size="4"><form:errors path="Cpw" /></font><br><br></td>
						</tr>
					</table>
					<div id="button">
						<input type="submit" id="login_button" value="LOG IN">&nbsp;&nbsp;
						<input type="button" id="signup_button" value = "SIGN UP" onclick = "window.location.href=('register.jsp')">
					</div>
				</form:form>
			</div>
		</div>
	</center>
</body>
</html>