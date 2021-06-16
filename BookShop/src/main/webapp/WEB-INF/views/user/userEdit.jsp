<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户编辑页面</title>
<jsp:include page="../commonJS.jsp"/>
<jsp:include page="../commonCSS.jsp"/>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<!-- <style type="text/css">
 #userEdit{
	margin: 20px; 
	overflow: scroll;
	height: calc(100vh - 40px);
}
#userEditBox{
	margin-top: 60px;
	background-color: #fff;
	padding:10px 30px 30px 30px;
}
#userEditBox div{
	margin-bottom:30px;
}
#userEditBox hr{
	margin-bottom:30px;
} 
</style> --> 
</head>
<body>
<div class="whole qingchu">
		<jsp:include page="../main/top.jsp"/> 
		<jsp:include page="../main/left.jsp"/> 
			<div class="wrapper">
				<div class="container">
					<div class="row" id="userEdit">
						<div class="row">
							<div class="col-lg-8 col-sm-8 col-sm-offset-2 col-lg-offset-2" id="userEditBox">
								<form:form modelAttribute="user" id="form_userEditInfo" name="form_userEditInfo" method="GET">
									<h3>编辑用户信息</h3>
									<hr>
									<div class="form-group">
									    <label for="userName" class="col-lg-2 col-md-3 col-sm-3 control-label">用户名称</label>
									    <div class="col-lg-10 col-md-9 col-sm-9">
									      <input type="text" name="username" class="form-control" id="userName" value="${user.username}">
									      <input type="hidden" name="id" class="form-control" id="userid" value="${user.id}">
									    </div>
								   </div>
								   <div class="form-group">
									    <label for="Password" class="col-lg-2 col-md-3 col-sm-3 control-label">用户密码</label>
									    <div class="col-lg-10 col-md-9 col-sm-9">
									      <input type="password" name="password" class="form-control" id="Password" value="${user.password}">
									    </div>
							 	   </div>
								   <div class="form-group">
								  	<label  class="col-sm-2 control-label">用户性别</label>
								  	<div class="col-sm-10">
								  	<c:choose>
								  		<c:when test="${user.gender =='男'}">
								  			<label class="radio-inline">
											  <input type="radio" name="gender" id="inlineRadio1" value="男" checked="checked"> 男
											</label>
											<label class="radio-inline">
											  <input type="radio" name="gender" id="inlineRadio2" value="女"> 女
											</label>
								  		</c:when>
								  		<c:otherwise>
								  			<label class="radio-inline">
											  <input type="radio" name="gender" id="inlineRadio1" value="男" >男
											</label>
								  			<label class="radio-inline">
											  <input type="radio" name="gender" id="inlineRadio2" value="女" checked="checked">女
											</label>
								  		</c:otherwise>
								  	</c:choose>
							  	</div>
							  	 <div class="form-group">
								    <label for="useremail" class="col-lg-2 col-md-3 col-sm-3 control-label">用户邮箱</label>
								    <div class="col-lg-10 col-md-9 col-sm-9">
								      <input type="email" name="email" class="form-control" id="useremail" value="${user.email}">
								    </div>
								  </div>
							    
							  </div>
								  <div class="form-group">
								    <label for="userPhone" class="col-lg-2 col-md-3 col-sm-3 control-label">用户电话</label>
								    <div class="col-lg-10 col-md-9 col-sm-9">
								      <input type="text" name="telephone" class="form-control" id="userPhone" value="${user.telephone}">
								    </div>
								  </div>
								  <div class="form-group">
								    <label for="usertime" class="col-lg-2 col-md-3 col-sm-3 control-label">注册时间</label>
								    <div class="col-lg-10 col-md-9 col-sm-9">
								      <input type="text" name="registtime"  class="form-control" id="usertime" value="<fmt:formatDate value='${user.registtime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
								  </div>
								  <div class="form-group">
								    <label for="Introduce" class="col-lg-2 col-md-3 col-sm-3 control-label">个人简介</label>
								    <div class="col-lg-10 col-md-9 col-sm-9">
								      <textarea type="text" name="introduce" class="form-control" id="Introduce" rows="3"  maxlength="100">${user.introduce}</textarea>
								    </div>
								  </div>
								  <div class="form-group">
								    <div class="col-sm-offset-2 col-lg-offset-2 col-md-offset-2 col-sm-3 col-lg-3 col-md-3">
								      <button type="button" id="userEditSave" class="btn btn-default">Save</button>
								    </div>
								    <div class="col-sm-7 col-lg-7 col-lg-7">
								      <button type="button" id="backToUserInfo" class="btn btn-default">GoBack</button>
								    </div>
								  </div>		
											
						</form:form>
							</div>
						</div>
					</div>
				</div>
			</div> 
			<jsp:include page="../main/footer.jsp"/> 
	</div>
<script language="javascript">
	$(function(){
		//格式化表单数据
		function formToJson($form) {
			var data = {};
			$($form.serializeArray()).each(function(i,v) {
					data[v.name] = v.value
			})
			return JSON.stringify(data);
		};
		//返回商品信息页面
		$("#backToUserInfo").click(function(){
			window.location.href="${pageContext.request.contextPath}/admin/userInfo";
		})
		//保存编辑后的商品信息
		$("#userEditSave").click(function(){
			var data = formToJson($("#form_userEditInfo"));
			console.log(data);
			var that = this;
			 $.ajax({
				type:"POST",
				contentType:"application/json;charset=utf-8",
				url:"${pageContext.request.contextPath}/api/v1/user/editUserPost",
				async:true,
				dataType: "json",
				data: formToJson($("#form_userEditInfo")),
				success:function(res){
					console.log(res)
					if(res.data == "true"){
						alert("编辑订单信息成功！")
						window.location.reload();
					}else{
						alert("编辑订单信息失败！")
					}
				},
				error: function(res) {
					alert("操作失败！请与管理员联系");
				}
			}) 
		})
	})
</script>

</body>
</html>