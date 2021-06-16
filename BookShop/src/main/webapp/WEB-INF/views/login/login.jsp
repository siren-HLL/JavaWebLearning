<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>传智书城_登录</title>
<jsp:include page="../commonJS.jsp" />
<jsp:include page="../commonCSS.jsp"/>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/login.css">
</head>
<body>
	<div id="page">
		<div id="header" class="qingchu">
			<div class="logo">
				<img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="logo" width="286" height="62"/>
				<span>传智书城后台管理</span>
			</div>
			<nav>
				<ul>
					<li><a href="#">企业邮箱</a></li>
					<li><a href="#">VIP邮箱</a></li>
					<li><a href="#">商城会员</a></li>
					<li><a href="#">海外用户登录</a></li>
					<li><a href="#">官方App</a></li>
					<li id="lii"><a href="#">帮助</a></li>
					<li><a href="#">登录反馈</a></li>
				</ul>
			</nav>
		</div>
		<div id="main" class="qingchu">
			<div id="bgwrap">
				<ul id="lbul">
					<li><img src="${pageContext.request.contextPath}/resources/images/pic1.png" width="1100" height="640" alt="广告"/></li>
					<li><img src="${pageContext.request.contextPath}/resources/images/pic2.png" width="1100" height="640" alt="广告"/></li>
					<li><img src="${pageContext.request.contextPath}/resources/images/pic3.png" width="1100" height="640" alt="广告"/></li>
				</ul>
				<div id="changepic">
					<img src="${pageContext.request.contextPath}/resources/images/prebtn.png" id="pre" alt="上一张"/>
					<img src="${pageContext.request.contextPath}/resources/images/nextbtn.png" id="next" alt="下一张"/>
				</div>
			</div>
			<div class="rightwrap">
					 <form action="">
						<table border="0">
							<tr><td id="dlbt">用户账号登录</td></tr>
							<tr><td><label for="username">账号</label><input type="text" id="username" name="username" placeholder="用户账号"/></td></tr>
							<tr><td><label for="password">密码</label><input type="password" id="password" name="password" placeholder="输入密码"/></td></tr>
							<tr><td><input type="checkbox" id="rememberme" name="rememberme"/><label id="shitian" name="remmberme">十天内免登录</label><span class="spanstyle"><a href="#">忘记密码？</a></span></td></tr>
							<tr><td><input type="button" id="login" value="登录"/></td></tr>
							<tr><td><a href="${pageContext.request.contextPath}/register">注册商城账号</a><a class="spanstyle" href="#">商城官方APP</a></td></tr>
						</table>
					</form> 
					<img id="ewm" src="${pageContext.request.contextPath}/resources/images/ewm.png" alt="扫码登录"/>
					<div id="adv"><a href="#">升级会员，商城纯净，无广告!</a></div>
			</div>
		</div>
		<div id="footer">
			<div class="copyright">
				<div>传智首页 | 传智严选 | 传智有钱 | 政府公益热线 | 隐私政策 | 儿童隐私政策</div>
				<p>	&copy;2021,余晓枫,0410190109<img src="${pageContext.request.contextPath}/resources/images/gonganlogo.png"> 粤公网安备 44010602006299增值电信业务许可证 粤B2-20090191  B2-20090058 </p>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var contextPath = '${pageContext.request.contextPath}';
		$(function(){
			$("#login").on("click",function(){
				var data = new Array();
				var $username = $("#username").val();
				var $password = $("#password").val();
				$.ajax({
					url:"${pageContext.request.contextPath}/api/v1/user/checkUserPost",
					contentType: "application/json",
					type:"POST",
					dataType: "json",
					data:JSON.stringify({username:$username,password:$password}),
					success:function(res){
						if(res.data != ""){
							window.location.href = contextPath + '/admin/home';
						}else{
							alert("登录失败,账号或密码错误")
						}
					}
					
				})
			})
		})
			var ul = document.getElementById("lbul");
			var lis = ul.getElementsByTagName("li");
			var pre = document.getElementById("pre");
			var next = document.getElementById("next");
			var num = 0;
			//图片轮播
			function show_pic(){
				for(var i=0 ; i<lis.length; i++){
					lis[i].style.display = "none";
				}
				num ++;//显示图片
				if(num == 3){
					num = 0;
				}
				lis[num].style.display = "block";
			}
			var lbintervar = setInterval("show_pic()",3000);
		
			//切换图片
			next.onclick = function(){
			 	clearInterval(lbintervar);
				num++;
			 	if(num == 3 ){
			 		num=0;
			 	}
				for(var i=0 ; i<lis.length; i++){
					lis[i].style.display = "none";
				}
			 	lis[num].style.display = "block";
				lbintervar = setInterval("show_pic()",3000);
			 }
			 pre.onclick = function(){
			  	clearInterval(lbintervar);
			  	num--;
			  	if(num <0 ){
			  		num=2;
			  	}
			  	for(var i=0 ; i<lis.length; i++){
			  		lis[i].style.display = "none";
			  	}
			  	lis[num].style.display = "block";
			  	lbintervar = setInterval("show_pic()",3000);
			  }


	</script>	

</body>
</html>