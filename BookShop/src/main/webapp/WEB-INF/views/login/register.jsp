<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
<jsp:include page="../commonCSS.jsp"/>
<jsp:include page="../commonJS.jsp"/>
<style type="text/css">
.userRegisterBox{
	margin-top: 50px;
	margin-bottom: 50px;
	background-color: rgba(57,48,81,1);
	border-radius: 10px;
	color: #f4ecec;
}
.userRegisterBox div{
	margin-bottom: 20px;
}
.genderGroup{
	margin-bottom:20px;
}
#checkmodel{
 display: none;
}

</style>
</head>
<body>
	 				<div>
							<div id="checkmodel" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							        <h4 class="modal-title" id="myModalLabel">Hlleo</h4>
							      </div>
							      <div class="modal-body">
							        <p>您已<strong>成功注册</strong>新的用户账号!</p>
							        <p>接下来想进行的操作是?</p>
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-default" data-dismiss="modal">关闭对话框</button>
							        <button type="button" class="btn btn-primary" id="backLogin">返回登录页</button>
							      </div>
							    </div>
							  </div>
							</div>
						</div> 
						<!-- <div class="modal fade" tabindex="-1" role="dialog" id="myModal">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							        <h4 class="modal-title">Modal title</h4>
							      </div>
							      <div class="modal-body">
							        <p>One fine body&hellip;</p>
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							        <button type="button" class="btn btn-primary">Save changes</button>
							      </div>
							    </div>/.modal-content
							  </div>/.modal-dialog
							</div>/.modal -->
	<div class="whole qingchu">
			<div id="register">
				<div class="container">
					<div class="row" >
						<div class="row">
							<div class="col-sm-offset-2 col-lg-offset-2 col-md-offset-2 col-lg-8 col-md-8 col-sm-8 userRegisterBox">
								<form class="form-horizontal" id="userAddForm">
								<h3>用户注册</h3>
								<hr/>
							  <div class="form-group">
							    <label for="userName" class="col-sm-2 control-label">用户名称</label>
							    <div class="col-sm-8">
							      <input type="text" name="username" class="form-control" id="userName" placeholder="userName">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="Password" class="col-sm-2 control-label">用户密码</label>
							    <div class="col-sm-8">
							      <input type="password" name="password" class="form-control" id="Password" placeholder="Password">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="RePassword" class="col-sm-2 control-label">确认密码</label>
							    <div class="col-sm-8">
							      <input type="password" name="confirm_password" class="form-control" id="RePassword" placeholder="RePassword">
							    </div>
							  </div>
							  <div class="row genderGroup">
							  	<label  class="col-sm-2 control-label">用户性别</label>
							  	<div class="col-sm-8">
							  		<label class="radio-inline">
									  <input type="radio" name="gender" id="inlineRadio1" value="男" checked="checked"> 男
									</label>
									<label class="radio-inline">
									  <input type="radio" name="gender" id="inlineRadio2" value="女"> 女
									</label>
							  	</div>
							  </div>
							  <div class="form-group">
							    <label for="Telephone" class="col-sm-2 control-label">用户电话</label>
							    <div class="col-sm-8">
							      <input type="text" name="telephone" class="form-control" id="Telephone" placeholder="Telephone">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="Email" class="col-sm-2 control-label">用户邮箱</label>
							    <div class="col-sm-8">
							      <input type="email" name="email" class="form-control" id="Email" placeholder="Email">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="Introduce" class="col-sm-2 control-label">个人简介</label>
							    <div class="col-sm-8">
							      <textarea class="form-control" name="introduce" rows="3" id="Introduce" maxlength="100" placeholder="max100"></textarea>
							    </div>
							  </div>
							  <div class="form-group" id="userBtnGroup">
							    <div class="col-sm-offset-2 col-sm-2">
							      <button type="submit" id="userSave" class="btn btn-primary">Save</button>
							    </div>
							    <div class="col-sm-2">
							      <button type="reset" id="userReset" class="btn btn-default">Reset</button>
							    </div>
							    <div class="col-sm-6">
								      <button type="button" id="backToLogin" class="btn btn-default">GoBack</button>
								 </div>
							  </div>
							</form>
							</div>
						</div>
						
					</div>
				</div>
			</div> 
			<jsp:include page="../main/footer.jsp"/> 
	</div>
	<script type="text/javascript">
	$(function(){
		//返回登录页面
		$("#backToLogin").click(function(){
			window.location.href="${pageContext.request.contextPath}/login";
		});
		$("#test").click(function(){
			
			$("#checkmodel").show();
		});
		$("#backLogin").on("click",function(){
			window.location.href="${pageContext.request.contextPath}/login";
		});
		
		//格式化表单数据
		function formToJson($form) {
			var data = {};
			$($form.serializeArray()).each(function(i,v) {
					data[v.name] = v.value
			})
			return JSON.stringify(data);
		};
		//用户注册
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
							$('#checkmodel').modal("show");
						}else{
							alert("注册失败");
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