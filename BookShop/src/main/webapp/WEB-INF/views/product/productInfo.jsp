<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品信息</title>
<jsp:include page="../commonCSS.jsp"/>
<jsp:include page="../commonJS.jsp"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
<!-- <style type="text/css">
#productInfoTable{/* 商品信息表格 */
	background-color: #fff;
}
#productThead th{
	text-align : center ;
	font-size: 18px;
}
.bookimg{
	display:block;
	max-width:60%;
	max-height:40%;
	/* height: 50%;
	width:50%; */
}
#productTbody td{
	vertical-align: middle;
	text-align : center ;
	font-size: 16px;
}
.editProduct{
	margin-right:5px;
	padding-right:5px;
	border-right: grey 1px solid;
} 
#productAddBox{/* 新增商品表单 */
	margin: 20px 0px 80px 0px; 

}
#prodctAddForm{
	background-color: #fff;
	padding: 10px 30px 30px 30px;
}
#prodctAddForm hr{
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
					<div class="row" id="productpage">
						<div class="row" id="pEditBtn">
							<div class="col-lg-7">
								<p><a id="AddBtn" class="btn btn-primary btn-lg" href="#" role="button">新增商品</a></p>
							</div>
						</div>
						<div class="row" id="productAddBox">
							<div class="col-lg-8 col-md-8 col-sm-8">
								<form class="form-horizontal" id="prodctAddForm">
								<h3>新增商品</h3>
								<hr/>
							  <div class="form-group">
							    <label for="productname" class="col-sm-2 control-label">商品名称</label>
							    <div class="col-sm-6">
							      <input type="text" name="name" class="form-control" id="productname" placeholder="productname">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="productprice" class="col-sm-2 control-label">商品价格</label>
							    <div class="col-sm-6">
							      <input type="number" name="price" class="form-control" id="productprice" placeholder="productprice">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="productnumble" class="col-sm-2 control-label">商品库存</label>
							    <div class="col-sm-6">
							      <input type="number" name="pnum" class="form-control" id="productnumble" placeholder="productnumble">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="productcategory" class="col-sm-2 control-label">商品类别</label>
							    <div class="col-sm-6">
							      <input type="text" name="category" class="form-control" id="productcategory" placeholder="productcategory">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="productimg" class="col-sm-2 control-label">商品图片</label>
							    <div class="col-sm-6">
							      <input type="text" name="imgurl" class="form-control" id="productimg" placeholder="productimg">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="productdescription" class="col-sm-2 control-label">商品描述</label>
							    <div class="col-sm-6">
							      <textarea class="form-control" name="description" rows="3" id="productdescription" placeholder="max255"></textarea>
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="col-sm-offset-2 col-sm-10">
							      <button type="submit" id="productSave" class="btn btn-default">Save</button>
							    </div>
							  </div>
							</form>
							</div>
						</div>
							
						<div class="row" id="pTableBox">
							<div class="col-lg-12">
								<div class="table-responsive">
								<table id="productInfoTable" class="table table-hover">
								<thead id="productThead">
							            <tr class="row">
							                <th class="col-lg-1 col-sm-1 col-md-1">商品ID</th>
							                <th class="col-lg-3 col-sm-3 col-md-3">商品图片</th>
							                <th class="col-lg-2 col-sm-2 col-md-2">商品名称</th>
							                <th class="col-lg-2 col-sm-2 col-md-2">商品类别</th>
							                <th class="col-lg-1 col-sm-1 col-md-1">商品价格</th>
							                <th class="col-lg-1 col-sm-1 col-md-1">库存</th>
							                <th class="col-lg-2 col-sm-2 col-md-2">操作</th>
							            </tr>
       			 				</thead> 
       			 			<tbody id="productTbody"></tbody>
								</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div> 
			<form id="forwardform" action='<c:url value="/admin/product/EditGet"/>' method='GET'>
				<input type="hidden" name="id" id="productId"/>
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
		})
		//删除商品
/* 		$("#productTbody").on("click",".deleteProductA",function(){
			var req = $(this).attr("prudctid");
			req = "id="+req
			console.log(req);
			var that = this;
			$.ajax({
				type:"GET",
				contentType:"application/json;charset=utf-8",
				url:"${pageContext.request.contextPath}/api/v1/product/deleteProduct",
				async:true,
				dataType: "json",
				data: req,
				success:function(res){
					results = res.data
					console.log(results)
					$(that).parents("tr").remove();
				}
			})
		}) */
		
		//编辑商品
		$("#productTbody").on("click",".editProductA",function(){
			var editid = $(this).attr("editid");
			$("#productId").val(editid);
 			$("#forwardform").submit();
		})
		//删除商品
		$("#productTbody").on("click",".deleteProductA",function(){
			var $id = $(this).attr("prudctid");
			var that = this;
			$.ajax({
				type:"POST",
				contentType:"application/json;charset=utf-8",
				url:"${pageContext.request.contextPath}/api/v1/product/deleteProductPost",
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
		//新增商品
		$("#AddBtn").on("click",function(){
			 $("#productAddBox").toggle();
		 });
 		 $("#prodctAddForm").validate({
			focusInvalid: true,//光标移至不通过的地方
			onfocusout: false,
			onkeyup: false,
			onclick: false,
			onsubmit:true,
		    rules: {
		    name: "required",
		    price: "required",
			pnum: "required"
		   },
		    messages: {
		    name: "请输入商品名称",
		    price: "请输入商品价格",
			pnum:"请输入商品库存"
		   },
		   submitHandler: function() { //验证成功时调用
		       $.ajax({
			   	type:"POST",
				contentType:"application/json;charset=utf-8",
				url:"${pageContext.request.contextPath}/api/v1/product/addProductPost",
				async:true,
				dataType: "json",
				data: formToJson($("#prodctAddForm")),
				success:function(res){
					if(res.data == "true"){
						window.location.reload();
					}else{
						alert("新增商品失败！")
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