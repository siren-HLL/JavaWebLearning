<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>测试pageContext</title>
</head>
<body>
<!-- scriptLets -->
	<% 
	JspWriter out1 = pageContext.getOut();
	out1.write("xxxxxxxxxx");
	HttpServletRequest request1 = (HttpServletRequest)pageContext.getRequest();
	HttpServletResponse response1 = (HttpServletResponse)pageContext.getResponse();
	
	%>
</body>
</html>