<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单信息</title>
<jsp:include page="../commonCSS.jsp"/>
<jsp:include page="../commonJS.jsp"/>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<!-- <style type="text/css">
#orderInfoTable{/* 订单信息表格 */
	background-color: #fff;
}
#orderThead th{
	text-align : center;
	
}
#orderTbody td{
	vertical-align: middle;
	text-align : center ;
	font-size: 16px;
}
.editOrder{
	margin-right:5px;
	padding-right:5px;
	border-right: grey 1px solid;
} 
#orderAddBox{/* 新增商品表单 */
	margin: 20px 0px 80px 0px; 
	display: none;
}
#orderAddForm{
	background-color: #fff;
	padding: 10px 30px 30px 30px;
}
.paystate{
	margin-bottom:20px;
}
#orderAddForm hr{
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
					<div class="row" id="orderpage">
						 <div class="row" id="oEditBtn">
							<div class="col-lg-7">
								<p><a id="AddBtn" class="btn btn-primary btn-lg" href="#" role="button">新增订单</a></p>
							</div>
						</div> 
						<div class="row" id="orderAddBox">
							<div class="col-lg-8 col-md-8 col-sm-8">
								<form class="form-horizontal" id="orderAddForm">
								<h3>新增订单</h3>
								<hr/>
							  <div class="form-group">
							    <label for="guestname" class="col-sm-2 control-label">用户名称</label>
							    <div class="col-sm-6">
							      <input type="text" name="guestName" class="form-control" id="guestname" placeholder="guestname">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="money" class="col-sm-2 control-label">支付金额</label>
							    <div class="col-sm-6">
							      <input type="number" name="money" class="form-control" id="money" placeholder="money">
							    </div>
							  </div>
							  <div class="row paystate">
							  	<label  class="col-sm-2 control-label">支付状态</label>
							  	<div class="col-sm-6">
							  		<label class="radio-inline">
									  <input type="radio" name="payState" id="inlineRadio1" value="1"> 已支付
									</label>
									<label class="radio-inline">
									  <input type="radio" name="payState" id="inlineRadio2" value="0"> 未支付
									</label>
							  	</div>
							  </div>
							  <div class="form-group">
							    <label for="guestphone" class="col-sm-2 control-label">用户电话</label>
							    <div class="col-sm-6">
							      <input type="text" name="guestPhone" class="form-control" id="guestphone" placeholder="guestphone">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="guestaddress" class="col-sm-2 control-label">用户地址</label>
							    <div class="col-sm-10">
							      <input type="text" name="guestAddress" class="form-control" id="guestaddress" placeholder="guestaddress">
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="col-sm-offset-2 col-sm-10">
							      <button type="submit" id="orderSave" class="btn btn-default">Save</button>
							    </div>
							  </div>
							</form>
							</div>
						</div>
							
						<div class="row" id="oTableBox">
							<div class="col-lg-12">
								<div class="table-responsive">
								<table id="orderInfoTable" class="table table-hover">
								<thead id="orderThead">
							            <tr class="row">
							                <th class="col-lg-1 col-sm-1 col-md-1">订单ID</th>
							                <th class="col-lg-1 col-sm-1 col-md-1">用户账号</th>
							                <th class="col-lg-1 col-sm-1 col-md-1">支付金额</th>
							                <th class="col-lg-2 col-sm-2 col-md-2">用户地址</th>
							                <th class="col-lg-2 col-sm-2 col-md-2">用户电话</th>
							                <th class="col-lg-3 col-sm-3 col-md-3">下单时间</th>
							                <th class="col-lg-2 col-sm-2 col-md-2">操作</th>
							            </tr>
       			 				</thead> 
       			 			<tbody id="orderTbody"></tbody>
								</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div> 
			<form id="forwardform" action='<c:url value="/admin/order/EditGet"/>' method='GET'>
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
		var results;
		$.ajax({
			type:"GET",
			contentType:"application/json;charset=utf-8",
			url:"${pageContext.request.contextPath}/api/v1/order/findAllOrders",
			async:true,
			dataType: "json",
			success:function(res){
				results = res.data
				console.log(results)
				for(var i=0; i < results.length ;i++){
					$("<tr></tr>")
					.addClass("row")
					.append($("<td></td>").text(results[i].id).addClass("col-lg-1 col-sm-1 col-md-1 oid"))
					.append($("<td></td>").text(results[i].guestName).addClass("col-lg-1 col-sm-1 col-md-1 oname"))
					.append($("<td></td>").text(results[i].money).addClass("col-lg-1 col-sm-1 col-md-1 omoney"))
					.append($("<td></td>").text(results[i].guestAddress).addClass("col-lg-2 col-sm-2 col-md-2 oaddress"))
					.append($("<td></td>").text(results[i].guestPhone).addClass("col-lg-2 col-sm-2 col-md-2 ophone"))
					.append($("<td></td>").text(results[i].orderTime).addClass("col-lg-3 col-sm-3 col-md31 otime"))
					.append($("<td></td>").html("<span class='editOrder'><a href='#' role='button' class='editOrderA' editid='"+results[i].id+"'>编辑</a></span><span class='deleteOrder'><a href='#' role='button' class='deleteOrderA' orderid='"+results[i].id+"'>删除</a></span>").addClass("col-lg-2 col-sm-2 col-md-2 action"))
					.appendTo($("#orderTbody"))
				}
				
			},
			error: function(res) {
				alert(res);
			}
		})
		
		//编辑订单信息
		$("#orderTbody").on("click",".editOrderA",function(){
			var editid = $(this).attr("editid");
			$("#orderId").val(editid);
 			$("#forwardform").submit();
		})
		//删除订单
		$("#orderTbody").on("click",".deleteOrderA",function(){
			var $id = $(this).attr("orderid");
			var that = this;
			$.ajax({
				type:"POST",
				contentType:"application/json;charset=utf-8",
				url:"${pageContext.request.contextPath}/api/v1/order/deleteOrderPost",
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
			 $("#orderAddBox").toggle();
		 });
 		 $("#orderAddForm").validate({
			focusInvalid: true,//光标移至不通过的地方
			onfocusout: false,
			onkeyup: false,
			onclick: false,
			onsubmit:true,
		    rules: {
			    money: "required",
			    guestName: "required",
				guestAddress: "required",
				guestPhone: "required"
		   },
		    messages: {
		    	money: "请输入订单金额",
			    guestName: "请输入用户名称",
				guestAddress: "请输入用户地址",
				guestPhone: "请输入用户地址"
		   },
		   submitHandler: function() { //验证成功时调用
		       $.ajax({
			   	type:"POST",
				contentType:"application/json;charset=utf-8",
				url:"${pageContext.request.contextPath}/api/v1/order/addOrderPost",
				async:true,
				dataType: "json",
				data: formToJson($("#orderAddForm")),
				success:function(res){
					if(res.data == "true"){
						window.location.reload();
					}else{
						alert("新增订单失败！")
					}
				},
				error: function(res) {
					alert("操作失败！请与管理员联系");
				} 
				
		   })  
		   },
		   invalidHandler: function(form, validator) {  //不通过回调
                       alert('验证不通过,请输入完整信息');
                       return false;
                  }
		     }); 
		
	})

	</script>
	
</body>
</html>