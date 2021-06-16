<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>传智商城首页</title>
<jsp:include page="../commonCSS.jsp"/>
<jsp:include page="../commonJS.jsp"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css"/>
</head>
<body>
	<div class="whole qingchu">
		<jsp:include page="../main/top.jsp"/> 
		<jsp:include page="../main/left.jsp"/> 
			<div class="wrapper">
				<div class="container">
					<div class="row" id="homepage">
						<div class="row">
							<div class="col-lg-12">
								<div class="jumbotron center-block" id="welcomMsg">
								  <h1>${title}</h1>
								  <p>${msg}</p>
								  <p><a class="btn btn-primary btn-lg" href="#" @click="showCreaterInfo" role="button">contact whit creater</a></p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div> 
			<jsp:include page="../main/footer.jsp"/> 
	</div>
	
	<script>
		var welcomMsg = new Vue({
			el : '.whole',
			methods:{
				showCreaterInfo : function(){
					alert("联系网页创建者：余晓枫0410190109")
				}
			}
		});
	</script>
</body>
</html>