<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>通知公告</title>
<jsp:include page="../commonJS.jsp"/>
<jsp:include page="../commonCSS.jsp"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
<!-- <style type="text/css">
#noticepage{
	margin: 20px; 
	overflow: scroll;
	height: calc(100vh - 40px);
}
.perNotice{
	background-color: rgba(0, 0, 0, 0.5);
	border-radius: 10px;
	/* color: white; */
	border:none;
}
.noticeTitle{
	color: white;
}
.noticeText,.noticeTime{
	color: lightgrey;
}
.noticeTime,.btnGroup{
	margin-top: 20px;
	text-align: right;
}
.editBtn{
	margin-right:20px;
}

#noticeAddBox{/* 新增公告表单 */
	margin: 20px 0px 80px 0px; 
	display: none;
}
#noticeAddForm{
	background-color: #fff;
	padding: 10px 30px 30px 30px;
}
#noticeAddForm hr{
	margin-bottom: 30px;
}
</style> -->
</head>
<body>
	<div class="whole qingchu">
		<jsp:include page="../main/top.jsp"/> 
		<jsp:include page="../main/left.jsp"/> 
			<div class="wrapper">
				<div class="container">
					<div class="row" id="noticepage">
						<div class="row" id="nEditBtn"> 
							<div class="col-lg-7">
								<p><a id="AddBtn" class="btn btn-primary btn-lg" href="#" role="button">新增公告</a></p>
							</div>
						</div>
						<div class="row" id="noticeAddBox">
							<div class="col-lg-8 col-md-8 col-sm-8">
								<form class="form-horizontal" id="noticeAddForm">
								<h3>新增公告</h3>
								<hr/>
							  <div class="form-group">
							    <label for="noticetitle" class="col-sm-2 control-label">公告标题</label>
							    <div class="col-sm-10">
							      <input type="text" name="title" class="form-control" id="productname" placeholder="noticetitle">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="noticedetail" class="col-sm-2 control-label">公告详情</label>
							    <div class="col-sm-10">
							      <textarea class="form-control" name="detail" rows="8" id="noticedetail" maxlength="255" placeholder="max255"></textarea>
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="col-sm-offset-2 col-sm-10">
							      <button type="submit" id="noticeSave" class="btn btn-default">Save</button>
							    </div>
							  </div>
							</form>
							</div>
						</div> 
						<div class="row">
							<div class="col-lg-12 col-sm-12 col-md-12" id="noticeBoard">
							<div class="row col-lg-12 col-sm-12 col-md-12 ">
								<c:forEach items="${requestScope.notice}" var="item">
								  <div class="col-sm-12 col-md-8 col-lg-8 col-md-offset-2 col-lg-offset-2 itembox">
								    <div class="thumbnail perNotice">
								      <div class="caption noticeContent">
								        <h3 class="noticeTitle">${item.title}</h3>
								        <hr/>
								        <p class="noticeText">${item.detail}</p>
								        <p class="noticeTime">${item.createtime}</p>
								        <p class="btnGroup"><a href="#" class="btn btn-primary editBtn" editid="${item.id}" role="button">编辑</a> <button class="btn btn-default deleteBtn" role="button" deleteid="${item.id}">删除</button></p>
								      </div>
								    </div>
								   </div>
							</c:forEach>
							</div>
							
						</div>
						
						 </div>
							
				</div>
			</div> 
			</div>
			<form id="forwardform" action='<c:url value="/admin/notice/EditGet"/>' method='GET'>
				<input type="hidden" name="id" id="orderId"/>
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
		/* var results;
		 $.ajax({
			type:"GET",
			contentType:"application/json;charset=utf-8",
			url:"${pageContext.request.contextPath}/api/v1/product/findAllProducts",
			async:true,
			dataType: "json",
			success:function(res){
				results = res.data
				console.log(results)
				$table = $("#productInfoTable");
				for(var i=0; i < results.length ;i++){
					$("<tr></tr>")
					.addClass("row")
					.append($("<td></td>").text(results[i].id).addClass("col-lg-1 col-sm-1 col-md-1 pid"))
					.append($("<td></td>").html("<img src="+contextPath+results[i].imgurl+" class='img-responsive bookimg center-block' alt='商品图片'>").addClass("col-lg-3 col-sm-3 col-md-3 pimg"))
					.append($("<td></td>").text(results[i].name).addClass("col-lg-2 col-sm-2 col-md-2 pname"))
					.append($("<td></td>").text(results[i].category).addClass("col-lg-2 col-sm-2 col-md-2 pcate"))
					.append($("<td></td>").text(results[i].price).addClass("col-lg-1 col-sm-1 col-md-1 pprice"))
					.append($("<td></td>").text(results[i].pnum).addClass("col-lg-1 col-sm-1 col-md-1 ppnum"))
					.append($("<td></td>").html("<span class='editProduct'><a href='#' role='button' class='editProductA' editid='"+results[i].id+"'>编辑</a></span><span class='deleteProduct'><a href='#' role='button' class='deleteProductA' prudctid='"+results[i].id+"'>删除</a></span>").addClass("col-lg-2 col-sm-2 col-md-2 paction"))
					.appendTo($("#productTbody"))
				}
				
			},
			error: function(res) {
				alert(res);
			}
		})  */
		
		//编辑消息公告
		$("#noticeBoard").on("click",".editBtn",function(){
			var editid = $(this).attr("editid");
			$("#orderId").val(editid);
 			$("#forwardform").submit();
		})
		//删除消息公告
		$("#noticeBoard").on("click",".deleteBtn",function(){
			var $id = $(this).attr("deleteid");
			console.log($id)
			var that = this;
			$.ajax({
				type:"POST",
				contentType:"application/json;charset=utf-8",
				url:"${pageContext.request.contextPath}/api/v1/notice/deleteNoticePost",
				async:true,
				dataType: "json",
				data: JSON.stringify({id:$id}),
				success:function(res){
					$(that).parents($(".itembox")).remove();
					window.location.reload();
				},
				error: function(res) {
					alert(res);
				}
			}) 
		})
		//新增公告
		$("#AddBtn").on("click",function(){
			 $("#noticeAddBox").toggle();
		 });
		 
		 
		 
		 
		 
		 
 		 $("#noticeAddForm").validate({
			focusInvalid: true,//光标移至不通过的地方
			onfocusout: false,
			onkeyup: false,
			onclick: false,
			onsubmit:true,
		    rules: {
			    title: "required",
			    detail: "required"
		   },
		    messages: {
			    title: "请输入公告标题",
			    detail: "请输入公告详情"
				
		   },
		   submitHandler: function() { //验证成功时调用
		       $.ajax({
			   	type:"POST",
				contentType:"application/json;charset=utf-8",
				url:"${pageContext.request.contextPath}/api/v1/notice/addNoticePost",
				async:true,
				dataType: "json",
				data: formToJson($("#noticeAddForm")),
				success:function(res){
					if(res.data == "true"){
						window.location.reload();
					}else{
						alert("新增公告失败！")
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