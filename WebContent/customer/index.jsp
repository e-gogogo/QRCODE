<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
	<meta name="viewport" content="height=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0">
	<title>Insert title here</title>
	<link rel="stylesheet" href="css/common.css"/>
    <link rel="stylesheet" href="css/register.css"/>
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
            <form action="">
                <div class="message">
                    <input type="text" placeholder="请输入邮箱"  required/>
                    <input type="password" placeholder="请输入4-10位密码" pattern="[0-9A-Za-z]{4,10}" required/>
                    <input type="password" placeholder="请再次输入密码" pattern="[0-9A-Za-z]{4,10}" required/>
                    <input type="text" placeholder="输入验证码" pattern="[0-9]{6}" required/>
                    <a class="code" href="default.htm" required>获取验证码</a>
                </div>
                <div class="agree">
                    <input type="checkbox"/><span>&nbsp;同意&nbsp;</span><a href="default.htm">《注册协议》</a>
                </div>
                <button class="submit" type="submit" >注册</button>
            </form>
        </div>
    </div>
</body>
</html>