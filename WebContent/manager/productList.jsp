<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
<title>商品列表</title>
<script type="text/javascript">
	function showInfo(Pid) {
			//ajax将邮箱传入后台			
			$.ajax({
				type : "POST", //请求的方式，默认get请求
				url : "createQrcode", //请求地址，后台提供的
				data : {
					Pid : Pid
				},//data是传给后台的字段，后台需要哪些就传入哪些
				success : function(data) {
					console.log(data);
					//alert(data);
					var str = data.replace("}","").replace(/\"/g, "").split(":");
					var add = str[1]+":"+str[2];
					//alert(add);
					url= "qrcode.jsp?add="+add;
					window.location.href = url;
					//alert("suc");
				},
				error : function(data) {
					alert("此邮箱未注册");
				}
			})
		}
	


</script>
</head>
<body>
<div id="header"></div>
<div class="page_one">
    <div class="contant">
        <div class="crumbs">
            
            <p>黑马旅行><span>搜索结果</span></p>
        </div>
        <div class="xinxi clearfix">
            <div class="left">
                <div class="header">
                    <span>商品信息</span>
                    <span class="jg">价格</span>
                </div>
                <ul id="route">
                    <li>
                        <div class="img"><img src="../image/img1.jpg" width="150" height="150" ></div>
                        <div class="text1">
                            <p>一朵小发发</p>
                            <br/>
                            <p>合欢花</p>
                        </div>
                        <div class="price">
                            <p class="price_num">
                                <span>&yen;</span>
                                <span>299</span>
                                <span>起</span>
                            </p>
                            <p><a href="javascript:void(0);" onclick="showInfo(1)">查看详情</a></p>
                        </div>
                    </li>
                    <li>
                        <div class="img"><img src="images/04-search_03.jpg" alt=""></div>
                        <div class="text1">
                            <p>浪花朵朵旅行普吉岛丛林飞跃空中飞人探险游中文服务泰国旅游</p>
                            <br/>
                            <p>1-2月出发，网付立享￥1099/2人起！爆款位置有限，抢完即止！</p>
                        </div>
                        <div class="price">
                            <p class="price_num">
                                <span>&yen;</span>
                                <span>899</span>
                                <span>起</span>
                            </p>
                            <p><a href="route_detail.html">查看详情</a></p>
                        </div>
                    </li>
                    <li>
                        <div class="img"><img src="images/04-search_03.jpg" alt=""></div>
                        <div class="text1">
                            <p>黑妞皇家旅行普吉岛攀牙湾大船星光之旅皮划艇日落休闲特色体验</p>
                            <br/>
                            <p>1-2月出发，网付立享￥1099/2人起！爆款位置有限，抢完即止！</p>
                        </div>
                        <div class="price">
                            <p class="price_num">
                                <span>&yen;</span>
                                <span>999</span>
                                <span>起</span>
                            </p>
                            <p><a href="route_detail.html">查看详情</a></p>
                        </div>
                    </li>
                    <li>
                        <div class="img"><img src="images/04-search_03.jpg" alt=""></div>
                        <div class="text1">
                            <p>浪花朵朵旅行普吉岛皇帝岛珊瑚岛香蕉船拖拽伞水上项目</p>
                            <br/>
                            <p>1-2月出发，网付立享￥1099/2人起！爆款位置有限，抢完即止！</p>
                        </div>
                        <div class="price">
                            <p class="price_num">
                                <span>&yen;</span>
                                <span>99</span>
                                <span>起</span>
                            </p>
                            <p><a href="route_detail.html">查看详情</a></p>
                        </div>
                    </li>
                    <li>
                        <div class="img"><img src="images/04-search_03.jpg" alt=""></div>
                        <div class="text1">
                            <p>环游记 泰国清迈Lila massage女子监狱spa 丽菈泰式按摩马杀鸡</p>
                            <br/>
                            <p>1-2月出发，网付立享￥1099/2人起！爆款位置有限，抢完即止！</p>
                        </div>
                        <div class="price">
                            <p class="price_num">
                                <span>&yen;</span>
                                <span>199</span>
                                <span>起</span>
                            </p>
                            <p><a href="route_detail.html">查看详情</a></p>
                        </div>
                    </li>
                    <li>
                        <div class="img"><img src="images/04-search_03.jpg" alt=""></div>
                        <div class="text1">
                            <p>【减100元 含除夕/春节出发】广州增城三英温泉度假酒店/自由行套票</p>
                            <br/>
                            <p>1-2月出发，网付立享￥1099/2人起！爆款位置有限，抢完即止！</p>
                        </div>
                        <div class="price">
                            <p class="price_num">
                                <span>&yen;</span>
                                <span>899</span>
                                <span>起</span>
                            </p>
                            <p><a href="route_detail.html">查看详情</a></p>
                        </div>
                    </li>
                    <li>
                        <div class="img"><img src="images/04-search_03.jpg" alt=""></div>
                        <div class="text1">
                            <p>【减100元 含除夕/春节出发】广州增城三英温泉度假酒店/自由行套票</p>
                            <br/>
                            <p>1-2月出发，网付立享￥1099/2人起！爆款位置有限，抢完即止！</p>
                        </div>
                        <div class="price">
                            <p class="price_num">
                                <span>&yen;</span>
                                <span>1199</span>
                                <span>起</span>
                            </p>
                            <p><a href="route_detail.html">查看详情</a></p>
                        </div>
                    </li>
                    <li>
                        <div class="img"><img src="images/04-search_03.jpg" alt=""></div>
                        <div class="text1">
                            <p>泰国芭提雅三合一日游芭提雅蒂芬妮人妖秀成人门票bigeye含接送</p>
                            <br/>
                            <p>1-2月出发，网付立享￥1099/2人起！爆款位置有限，抢完即止！</p>
                        </div>
                        <div class="price">
                            <p class="price_num">
                                <span>&yen;</span>
                                <span>1589</span>
                                <span>起</span>
                            </p>
                            <p><a href="route_detail.html">查看详情</a></p>
                        </div>
                    </li>
                </ul>
                <div class="page_num_inf">
                    <i></i> 共
                    <span id="totalPage">12</span>页<span id="totalCount">132</span>条
                </div>
                <div class="pageNum">
                    <ul id="pageNum">
                        <li><a href="">首页</a></li>
                        <li class="threeword"><a href="#">上一页</a></li>
                        <li class="curPage"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">6</a></li>
                        <li><a href="#">7</a></li>
                        <li><a href="#">8</a></li>
                        <li><a href="#">9</a></li>
                        <li><a href="#">10</a></li>
                        <li class="threeword"><a href="javascript:;">下一页</a></li>
                        <li class="threeword"><a href="javascript:;">末页</a></li>
                    </ul>
                </div>
            </div>
            <div class="right">
                <div class="top">
                    <div class="hot">HOT</div>
                    <span>热门推荐</span>
                </div>
                <ul>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>



</body>
</html>