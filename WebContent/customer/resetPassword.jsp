<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
<title>重置密码</title>
<script type="text/javascript">

    function resetPassword(){
    	var Cpw=document.getElementById("Cpw").value;
    	var reCpw=document.getElementById("reCpw").value;
		if(Cpw == null){
			alert("密码不能为空!");
			location.reload(); 
		}else if (Cpw != reCpw) {
			alert("确认密码与新密码不一致!");
			location.reload(); 
		}else{
			//ajax将新密码传入后台			
			$.ajax({
    	        type: "POST", //请求的方式，默认get请求
    	        url: "resetPassword", //请求地址，后台提供的
    	        data: {Cpw:Cpw},//data是传给后台的字段，后台需要哪些就传入哪些
    	        success: function(data){    	        	
    	          alert("密码修改成功！");
    	        },
    	        error: function(data){
    	        	alert("此邮箱未注册");
    	        }
    	    })
		} 
  }
</script>
</head>
<body>
	<center>
		<div id="main_body">
			<div id="main_resetPassword">
				新密码：<input type="text" id="Cpw" value="" /><br><br> 
				确认密码：<input type="text" id="reCpw" value="" /><br><br> 
				<input type="button" id="resetPassword_button" value="确认" onclick="resetPassword()"> 
			</div>
		</div>
	</center>
</body>
</html>