<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<jsp:include page="commonCss.jsp" />
</head>
<body class="blank">

	<div class="color-line"></div>
	<div class="error-container">
		<i class="pe-7s-way text-success big-icon"></i>
		<c:if test="${type==1}">
			<h1>未通过认证，请联系管理员！</h1>
		</c:if>
		<c:if test="${type==2}">
			<h1>Ip地址非法，请联系管理员！</h1>
		</c:if>
	</div>
</body>
</html>
