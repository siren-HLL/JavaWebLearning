<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <div id="sideNavigation">
		<!-- 侧边栏标签页 -->
		<ul class="nav nav-pills nav-stacked">
			<!-- 侧边栏选项 -->
			<%-- <li role="presentation"><a href="${pageContext.request.contextPath}/admin/productInfo">商品管理</a></li>
			<li role="presentation"><a href="#">用户信息</a></li>
			<li role="presentation"><a href="#">通知公告</a></li>
			<li role="presentation"><a href="#">菜单信息</a></li>
			<li role="presentation"><a href="${pageContext.request.contextPath}/productInfo0">订单信息</a></li>
			<li role="presentation"><a href="${pageContext.request.contextPath}/admin/jiFen">订单详情</a></li>   --%>
			<li role="presentation"><a href="${pageContext.request.contextPath}/admin/home">首页</a></li>
			<c:forEach items="${requestScope.menus}" var="item">
			<li role="presentation"><a href="${pageContext.request.contextPath}${item.url}">${item.name}</a></li>
			</c:forEach>
		</ul>
</div>

	