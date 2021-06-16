<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑商品信息</title>
<jsp:include page="../commonCSS.jsp"/>
<jsp:include page="../commonJS.jsp"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
<!-- <style type="text/css">
#productEdit{
	margin: 20px; 
	overflow: scroll;
	height: calc(100vh - 40px);
}
#productEditBox{
	margin-top: 60px;
	background-color: #fff;
	padding:10px 30px 30px 30px;
}
#productEditBox div{
	margin-bottom:30px;
}
#productEditBox hr{
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
					<div class="row" id="productEdit">
						<div class="row">
							<div class="col-lg-8 col-sm-8 col-sm-offset-2 col-lg-offset-2" id="productEditBox">
								<form:form modelAttribute="product" id="form_productEditInfo" name="form_productEditInfo" method="GET">
									<h3>编辑商品信息</h3>
									<hr>
									<div class="form-group">
									    <label for="productname" class="col-lg-2 col-md-3 col-sm-3 control-label">商品名称</label>
									    <div class="col-lg-10 col-md-9 col-sm-9">
									      <input type="text" name="name" class="form-control" id="productname" value="${product.name}">
									      <input type="hidden" name="id" class="form-control" id="productid" value="${product.id}">
									    </div>
								   </div>
								   <div class="form-group">
								    <label for="productprice" class="col-lg-2 col-md-3 col-sm-3 control-label">商品价格</label>
								    <div class="col-lg-10 col-md-9 col-sm-9">
								      <input type="number" name="price" class="form-control" id="productprice" value="${product.price}">
								    </div>
								  </div>
								  <div class="form-group">
								    <label for="productnumble" class="col-lg-2 col-md-3 col-sm-3 control-label">商品库存</label>
								    <div class="col-lg-10 col-md-9 col-sm-9">
								      <input type="number" name="pnum" class="form-control" id="productnumble" value="${product.pnum}">
								    </div>
								  </div>
								  <div class="form-group">
								    <label for="productcategory" class="col-lg-2 col-md-3 col-sm-3 control-label">商品类别</label>
								    <div class="col-lg-10 col-md-9 col-sm-9">
								      <input type="text" name="category" class="form-control" id="productcategory" value="${product.category}">
								    </div>
								  </div>
								  <div class="form-group">
								    <label for="productimg" class="col-lg-2 col-md-3 col-sm-3 control-label">商品图片</label>
								    <div class="col-lg-10 col-md-9 col-sm-9">
								      <input type="text" name="imgurl" class="form-control" id="productimg" value="${product.imgurl}">
								    </div>
								  </div>
								  <div class="form-group">
								    <label for="productdescription" class="col-lg-2 col-md-3 col-sm-3 control-label">商品描述</label>
								    <div class="col-lg-10 col-md-9 col-sm-9">
								      <textarea class="form-control" name="description" rows="3" id="productdescription" >${product.description}</textarea>
								    </div>
								  </div>
								  <div class="form-group">
								    <div class="col-sm-offset-2 col-lg-offset-2 col-md-offset-2 col-sm-3 col-lg-3 col-md-3">
								      <button type="button" id="productEditSave" class="btn btn-default">Save</button>
								    </div>
								    <div class="col-sm-7 col-lg-7 col-lg-7">
								      <button type="button" id="backToProductInfo" class="btn btn-default">GoBack</button>
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
		$("#backToProductInfo").click(function(){
			window.location.href="${pageContext.request.contextPath}/admin/productInfo";
		})
		//保存编辑后的商品信息
		$("#productEditSave").click(function(){
			var data = formToJson($("#form_productEditInfo"));
			console.log(data);
			var that = this;
			 $.ajax({
				type:"POST",
				contentType:"application/json;charset=utf-8",
				url:"${pageContext.request.contextPath}/api/v1/product/editProductPost",
				async:true,
				dataType: "json",
				data: formToJson($("#form_productEditInfo")),
				success:function(res){
					console.log(res)
					if(res.data == "true"){
						alert("编辑商品信息成功！")
						window.location.reload();
					}else{
						alert("编辑商品信息失败！")
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