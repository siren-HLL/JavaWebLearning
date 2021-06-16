<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<meta http-equiv="refresh" content="0;url=${root}/login">
<title>index</title>
<style type="text/css">
h1 {
	margin-left: 40px;
}
</style>
</head>
<body>
	<br>
	<br>
	<h1><a href="${root}/login">管理后台</a></h1>
	<br>
	<br>
	<br>
	<h1><a href="${root}/createrInfo">创建者信息</a></h1>
	<br>
	<br>
</body>
</html>