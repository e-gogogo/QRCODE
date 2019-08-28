<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
<title>商品详情</title>

</head>
<body>
	<div class='pic1' div
		style='position: absolute; left: 70px; top: 120px'>
		<img src='img/1.jpg' width="250" height="250" />
	</div>
	<!--<div class='pic2' div style='position:absolute; left:0px; top:0px'>
		 	<img src='img/3.jpg' width="1000" height="70"/>
		 </div>-->
	<div class='pic3' div
		style='position: absolute; left: 70px; top: 420px'>
		<img src='img/7.jpg' width="250" height="80" />
	</div>
	<div class='pic4' div
		style='position: absolute; left: 70px; top: 510px'>
		<img src='img/4.jpg' width="250" height="500" />
	</div>
	<div class='pic5' div
		style='position: absolute; left: 70px; top: 1000px'>
		<img src='img/5.jpg' width="250" height="500" />
	</div>
	<div class='pic6' div
		style='position: absolute; left: 70px; top: 1500px'>
		<img src='img/6.jpg' width="250" height="500" />
	</div>
	<button class="button" onclick="buy_confrim(1)">立即购买</button>
	<p class="text1">￥2180.00</p>
	
	
	<script type="text/javascript">
	function buy_confrim(Pid) {
		var r = confirm("确认购买该商品？");
		if (r == true) {
			var url=document.URL;
			var add = url.split("?");
			//向后端传递数据
			$.ajax({
				type : "POST", //请求的方式，默认get请求
				url : "purchase", //请求地址，后台提供的
				data : {
					Mid : add[1],
					Pid : Pid
				},//data是传给后台的字段，后台需要哪些就传入哪些
				success : function(data) {
					alert("购买成功！");
				},
				error : function(data) {
					
				}
			})
			
			
		}
	}
</script>
</body>
</html>