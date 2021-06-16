<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Navigation -->
<aside id="menu">
    <div id="navigation">
        <div class="profile-picture">
            <a href="javascript:void(0)">
                <img style="width: 150px" src="${pageContext.request.contextPath}/resources/admin/images/logo.gif" class="img-circle m-b" alt="logo">
            </a>
        </div>
        <ul class="nav" id="side-menu">
            <li id="leftMenuProduct">
                <a href="javascript:void(0)"><span class="nav-label">商品管理</span><span class="fa arrow"></span> </a>
                <ul class="nav nav-second-level">
                    <li><a href="${pageContext.request.contextPath}/admin/productList">商品详情管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/jiFen">用户积分管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/test">用户发票管理</a></li>
                </ul>
            </li>
        </ul>
    </div>
</aside>