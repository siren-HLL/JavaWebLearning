<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.cswu.entity.Loginer" %>
 <%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>测试页面</title>
</head>
<body>
	<p>hello world</p>
	<%String st ="这是五百万行java代码";
	Loginer myloginer = new Loginer();
	myloginer.setUsername("lee");
	%>
	<!-- jsp表达式后面你猜能不能不能带分号 -->
	<%=st %><br/>
	<%=myloginer.getUsername() %><br/>
	
	<%--这种注释只有后端能看到，不属于html的一部分 --%>
	<!-- jsp隐式对象（该注释属于html的一部分） -->
	<% out.print("Squeeze it"); %><br/>
	<% String name = request.getParameter("name");
		//response输出流会打印在页面最前面，不含在html代码中
		PrintWriter pw = response.getWriter();
		pw.write("The terrifold dance");
	%>
	<%=name %><br/>
	<% String sname = config.getServletName(); %>
	<%=sname %><br/>
	
<%-- 	<% //从session中读取当前登录的用户信息=>不登录会报错
	Loginer loginer = (Loginer)session.getAttribute("loginer"); %>
	<%=loginer.getUsername() %> --%>
	
	
	
</body>
</html>