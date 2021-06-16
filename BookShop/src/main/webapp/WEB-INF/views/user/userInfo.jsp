<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息</title>
<jsp:include page="../commonCSS.jsp"/>
<jsp:include page="../commonJS.jsp"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
<!-- <style type="text/css">
#userpage{
	margin: 20px; 
	overflow: scroll;
	height: calc(100vh - 40px);
}
#userInfoTable{/* 用户信息表格 */
	background-color: #fff;
}
#userThead th{
	text-align : center;
	font-size: 18px;
}
#userTbody td{
	vertical-align: middle;
	text-align : center ;
	font-size: 16px;
}
.editUser{
	margin-right:5px;
	padding-right:5px;
	border-right: grey 1px solid;
} 
#userAddBox{/* 新增用户表单 */
	margin: 20px 0px 80px 0px; 
	display: none;
}
#userAddForm{
	background-color: #fff;
	padding: 10px 30px 30px 30px;
}
.genderGroup{
	margin-bottom:20px;
}
#userAddForm hr{
	margin-bottom: 30px;
}
</style>  -->
</head>
<body>
	<div class="whole qingchu">
		<jsp:include page="../main/top.jsp"/> 
		<jsp:include page="../main/left.jsp"/> 
			<div class="wrapper">
				<div class="container">
					<div class="row" id="userpage">
						 <div class="row" id="uEditBtn">
							<div class="col-lg-7">
								<p><a id="AddBtn" class="btn btn-primary btn-lg" href="#" role="button">新增用户</a></p>
							</div>
						</div> 
						<div class="row" id="userAddBox">
							<div class="col-lg-8 col-md-8 col-sm-8">
								<form class="form-horizontal" id="userAddForm">
								<h3>新增用户</h3>
								<hr/>
							  <div class="form-group">
							    <label for="userName" class="col-sm-2 control-label">用户名称</label>
							    <div class="col-sm-6">
							      <input type="text" name="username" class="form-control" id="userName" placeholder="userName">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="Password" class="col-sm-2 control-label">用户密码</label>
							    <div class="col-sm-6">
							      <input type="password" name="password" class="form-control" id="Password" placeholder="Password">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="RePassword" class="col-sm-2 control-label">确认密码</label>
							    <div class="col-sm-6">
							      <input type="password" name="confirm_password" class="form-control" id="RePassword" placeholder="RePassword">
							    </div>
							  </div>
							  <div class="row genderGroup">
							  	<label  class="col-sm-2 control-label">用户性别</label>
							  	<div class="col-sm-6">
							  		<label class="radio-inline">
									  <input type="radio" name="gender" id="inlineRadio1" value="男"> 男
									</label>
									<label class="radio-inline">
									  <input type="radio" name="gender" id="inlineRadio2" value="女"> 女
									</label>
							  	</div>
							  </div>
							  <div class="form-group">
							    <label for="Telephone" class="col-sm-2 control-label">用户电话</label>
							    <div class="col-sm-6">
							      <input type="text" name="telephone" class="form-control" id="Telephone" placeholder="Telephone">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="Email" class="col-sm-2 control-label">用户邮箱</label>
							    <div class="col-sm-6">
							      <input type="email" name="email" class="form-control" id="Email" placeholder="Email">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="Introduce" class="col-sm-2 control-label">个人简介</label>
							    <div class="col-sm-6">
							      <textarea class="form-control" name="introduce" rows="3" id="Introduce" maxlength="100" placeholder="max100"></textarea>
							    </div>
							  </div>
							  <div class="form-group" id="userBtnGroup">
							    <div class="col-sm-offset-2 col-sm-2">
							      <button type="submit" id="userSave" class="btn btn-primary">Save</button>
							    </div>
							    <div class="col-sm-8">
							      <button type="reset" id="userReset" class="btn btn-default">Reset</button>
							    </div>
							  </div>
							</form>
							</div>
						</div>
							
						<div class="row" id="uTableBox">
							<div class="col-lg-12">
								<div class="table-responsive">
								<table id="userInfoTable" class="table table-hover">
								<thead id="userThead">
							            <tr class="row">
							                <th class="col-lg-1 col-sm-1 col-md-1">用户名称</th>
							                <th class="col-lg-2 col-sm-2 col-md-2">用户密码</th>
							                <th class="col-lg-1 col-sm-1 col-md-1">用户性别</th>
							                <th class="col-lg-2 col-sm-2 col-md-2">用户邮箱</th>
							                <th class="col-lg-2 col-sm-2 col-md-2">用户电话</th>
							                <th class="col-lg-2 col-sm-2 col-md-2">注册时间</th>
							                <th class="col-lg-2 col-sm-2 col-md-2">操作</th>
							            </tr>
       			 				</thead> 
       			 			<tbody id="userTbody"></tbody>
								</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div> 
			<form id="forwardform" action='<c:url value="/admin/user/EditGet"/>' method='GET'>
				<input type="hidden" name="id" id="userId"/>
			</form>
			<jsp:include page="../main/footer.jsp"/> 
	</div>
	<script type="text/javascript">
	var contextPath = '${pageContext.request.contextPath}';
	$(function(){
		//格式化表单数据
		function formToJson($form) {
			var data = {};
			$($form.serializeArray()).each(function(i,v) {
					data[v.name] = v.value
			})
			return JSON.stringify(data);
		};
		//渲染页面
		var results;
		$.ajax({
			type:"GET",
			contentType:"application/json;charset=utf-8",
			url:"${pageContext.request.contextPath}/api/v1/user/findAllUsers",
			async:true,
			dataType: "json",
			success:function(res){
				results = res.data
				console.log(results)
				for(var i=0; i < results.length ;i++){
					$("<tr></tr>")
					.addClass("row")
					.append($("<td></td>").text(results[i].username).addClass("col-lg-1 col-sm-1 col-md-1 uname"))
					.append($("<td></td>").text(results[i].password).addClass("col-lg-2 col-sm-2 col-md-2 upassword"))
					.append($("<td></td>").text(results[i].gender).addClass("col-lg-1 col-sm-1 col-md-1 ugender"))
					.append($("<td></td>").text(results[i].email).addClass("col-lg-2 col-sm-2 col-md-2 uemail"))
					.append($("<td></td>").text(results[i].telephone).addClass("col-lg-2 col-sm-2 col-md-2 uphone"))
					.append($("<td></td>").text(results[i].registtime).addClass("col-lg-2 col-sm-2 col-md2 utime"))
					.append($("<td></td>").html("<span class='editUser'><a href='#' role='button' class='editUserA' editid='"+results[i].id+"'>编辑</a></span><span class='deleteUser'><a href='#' role='button' class='deleteUserA' userid='"+results[i].id+"'>删除</a></span>").addClass("col-lg-2 col-sm-2 col-md-2 action"))
					.appendTo($("#userTbody"))
				}
				
			},
			error: function(res) {
				alert(res);
			}
		})
		
		//编辑用户信息
		$("#userTbody").on("click",".editUserA",function(){
			var editid = $(this).attr("editid");
			$("#userId").val(editid);
 			$("#forwardform").submit();
		})
		//删除用户
		$("#userTbody").on("click",".deleteUserA",function(){
			var $id = $(this).attr("userid");
			var that = this;
			$.ajax({
				type:"POST",
				contentType:"application/json;charset=utf-8",
				url:"${pageContext.request.contextPath}/api/v1/user/deleteUserPost",
				async:true,
				dataType: "json",
				data: JSON.stringify({id:$id}),
				success:function(res){
					$(that).parents("tr").remove();
				},
				error: function(res) {
					alert(res);
				}
			})
		})
		//新增订单
		$("#AddBtn").on("click",function(){
			 $("#userAddBox").toggle();
		 });
 		$("#userAddForm").validate({
			focusInvalid: true,//光标移至不通过的地方
			onfocusout: false,
			onkeyup: false,
			onclick: false,
			onsubmit:true,
			 rules: {
                 username: "required",
                 email: {
                     required: true,
                     email: true
                 },
                 password: {
                     required: true,
                     minlength: 5,
                     maxlength: 12
                 },
                 confirm_password: {
                     required: true,
                     minlength: 5,
                     maxlength: 12,
                     equalTo: "#Password"
                 },
                 telephone:"required"
             },
             messages: {
                 username: "请输入姓名",
                 email: {
                     required: "请输入Email地址",
                     email: "请输入正确的email地址"
                 },
                 password: {
                     required: "请输入密码",
                     minlength: "密码不能小于5个字 符",
                     maxlength: "密码不能大于12个字 符"
     			 },
                 confirm_password: {
                     required: "请输入确认密码",
                     minlength: "确认密码不能小于5个字符",
                     maxlength: "确认密码不能大于12个字 符",
                     equalTo: "两次输入密码不一致"
         		 },
         		telephone:"请输入用户电话号码"
              },
		   submitHandler: function() { //验证成功时调用
		      $.ajax({
			   	type:"POST",
				contentType:"application/json;charset=utf-8",
				url:"${pageContext.request.contextPath}/api/v1/user/addUserPost",
				async:true,
				dataType: "json",
				data: formToJson($("#userAddForm")),
				success:function(res){
					if(res.data == "true"){
						window.location.reload();
					}else{
						alert("新增用户失败！")
					}
				},
				error: function(res) {
					alert("操作失败！请与管理员联系");
				} 
				
		   }) 
		   },
		   invalidHandler: function(form, validator) {  //不通过回调
                       alert('验证不通过,请输入正确信息');
                       return false;
                  }
		     }); 
		
	})

	</script>
</body>
</html>