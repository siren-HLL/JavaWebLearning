<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公告编辑页面</title>
<jsp:include page="../commonJS.jsp"/>
<jsp:include page="../commonCSS.jsp"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
<!-- <style type="text/css">
#niticeEdit{
	margin: 20px; 
	overflow: scroll;
	height: calc(100vh - 40px);
}
#noticeEditBox{
	margin-top: 60px;
	background-color: #fff;
	padding:10px 30px 30px 30px;
}
#noticeEditBox div{
	margin-bottom:30px;
}
#noticeEditBox hr{
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
					<div class="row" id="noticeEdit">
						<div class="row">
							<div class="col-lg-8 col-sm-8 col-sm-offset-2 col-lg-offset-2" id="noticeEditBox">
								<form:form modelAttribute="notice" id="form_noticeEditInfo" name="form_noticeEditInfo" method="GET">
									<h3>编辑公告信息</h3>
									<hr>
									<div class="form-group">
									    <label for="noticetitle" class="col-lg-2 col-md-3 col-sm-3 control-label">公告标题</label>
									    <div class="col-lg-10 col-md-9 col-sm-9">
									      <input type="text" name="title" class="form-control" id="noticetitle" value="${notice.title}">
									      <input type="hidden" name="id" class="form-control" id="noticeid" value="${notice.id}">
									    </div>
								   </div>
								  <div class="form-group">
								    <label for="noticetime" class="col-lg-2 col-md-3 col-sm-3 control-label">发布时间</label>
								    <div class="col-lg-10 col-md-9 col-sm-9">
								      <input type="text" name="createtime"  class="form-control" id="noticetime" value="<fmt:formatDate value='${notice.createtime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
								  </div>
								  <div class="form-group">
								    <label for="noticedetail" class="col-lg-2 col-md-3 col-sm-3 control-label">公告内容</label>
								    <div class="col-lg-10 col-md-9 col-sm-9">
								      <textarea type="text" name="detail" class="form-control" id="noticedetail" rows="8"  maxlength="255">${notice.detail}</textarea>
								    </div>
								  </div>
								  <div class="form-group">
								    <div class="col-sm-offset-2 col-lg-offset-2 col-md-offset-2 col-sm-3 col-lg-3 col-md-3">
								      <button type="button" id="noticeEditSave" class="btn btn-default">Save</button>
								    </div>
								    <div class="col-sm-7 col-lg-7 col-lg-7">
								      <button type="button" id="backToNoticeInfo" class="btn btn-default">GoBack</button>
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
		$("#backToNoticeInfo").click(function(){
			window.location.href="${pageContext.request.contextPath}/admin/noticeInfo";
		})
		//保存编辑后的商品信息
		$("#noticeEditSave").click(function(){
			var data = formToJson($("#form_noticeEditInfo"));
			console.log(data);
			var that = this;
			 $.ajax({
				type:"POST",
				contentType:"application/json;charset=utf-8",
				url:"${pageContext.request.contextPath}/api/v1/notice/editNoticePost",
				async:true,
				dataType: "json",
				data: formToJson($("#form_noticeEditInfo")),
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