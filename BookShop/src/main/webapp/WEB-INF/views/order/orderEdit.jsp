<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑订单信息</title>
<jsp:include page="../commonJS.jsp"/>
<jsp:include page="../commonCSS.jsp"/>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<!-- <style type="text/css">
#orderEdit{
	margin: 20px; 
	overflow: scroll;
	height: calc(100vh - 40px);
}
#orderEditBox{
	margin-top: 60px;
	background-color: #fff;
	padding:10px 30px 30px 30px;
}
#orderEditBox div{
	margin-bottom:30px;
}
#orderEditBox hr{
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
					<div class="row" id="orderEdit">
						<div class="row">
							<div class="col-lg-8 col-sm-8 col-sm-offset-2 col-lg-offset-2" id="orderEditBox">
								<form:form modelAttribute="order" id="form_orderEditInfo" name="form_orderEditInfo" method="GET">
									<h3>编辑订单信息</h3>
									<hr>
									<div class="form-group">
									    <label for="guestname" class="col-lg-2 col-md-3 col-sm-3 control-label">用户名称</label>
									    <div class="col-lg-10 col-md-9 col-sm-9">
									      <input type="text" name="guestName" class="form-control" id="guestname" value="${order.guestName}">
									      <input type="hidden" name="id" class="form-control" id="orderid" value="${order.id}">
									    </div>
								   </div>
								   <div class="form-group">
								    <label for="ordermoney" class="col-lg-2 col-md-3 col-sm-3 control-label">支付金额</label>
								    <div class="col-lg-10 col-md-9 col-sm-9">
								      <input type="number" name="money" class="form-control" id="ordermoney" value="${order.money}">
								    </div>
								  </div>
								   <div class="form-group">
								  	<label  class="col-sm-2 control-label">支付状态</label>
								  	<div class="col-sm-10">
								  	<c:choose>
								  		<c:when test="${order.payState ==1}">
								  			<label class="radio-inline">
											  <input type="radio" name="payState" id="inlineRadio1" value="1" checked="checked"> 已支付
											</label>
											<label class="radio-inline">
											  <input type="radio" name="payState" id="inlineRadio2" value="0"> 未支付
											</label>
								  		</c:when>
								  		<c:otherwise>
								  			<label class="radio-inline">
											  <input type="radio" name="payState" id="inlineRadio1" value="1" > 已支付
											</label>
								  			<label class="radio-inline">
											  <input type="radio" name="payState" id="inlineRadio2" value="0" checked="checked"> 未支付
											</label>
								  		</c:otherwise>
								  	</c:choose>
							  		<!-- <label class="radio-inline">
									  <input type="radio" name="payState" id="inlineRadio1" value="1"> 已支付
									</label>
									<label class="radio-inline">
									  <input type="radio" name="payState" id="inlineRadio2" value="0"> 未支付
									</label> -->
							  	</div>
							    
							  </div>
								  <div class="form-group">
								    <label for="guestaddress" class="col-lg-2 col-md-3 col-sm-3 control-label">用户地址</label>
								    <div class="col-lg-10 col-md-9 col-sm-9">
								      <input type="text" name="guestAddress" class="form-control" id="guestaddress" value="${order.guestAddress}">
								    </div>
								  </div>
								  <div class="form-group">
								    <label for="guestphone" class="col-lg-2 col-md-3 col-sm-3 control-label">用户电话</label>
								    <div class="col-lg-10 col-md-9 col-sm-9">
								      <input type="text" name="guestPhone" class="form-control" id="guestphone" value="${order.guestPhone}">
								    </div>
								  </div>
								  <div class="form-group">
								    <label for="ordertime" class="col-lg-2 col-md-3 col-sm-3 control-label">下单时间</label>
								    <div class="col-lg-10 col-md-9 col-sm-9">
								      <input type="text" name="orderTime"  class="form-control" id="ordertime" value="<fmt:formatDate value='${order.orderTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
								  </div>
								  <div class="form-group">
								    <div class="col-sm-offset-2 col-lg-offset-2 col-md-offset-2 col-sm-3 col-lg-3 col-md-3">
								      <button type="button" id="orderEditSave" class="btn btn-default">Save</button>
								    </div>
								    <div class="col-sm-7 col-lg-7 col-lg-7">
								      <button type="button" id="backToOrderInfo" class="btn btn-default">GoBack</button>
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
		$("#backToOrderInfo").click(function(){
			window.location.href="${pageContext.request.contextPath}/admin/orderInfo";
		})
		//保存编辑后的商品信息
		$("#orderEditSave").click(function(){
			var data = formToJson($("#form_orderEditInfo"));
			console.log(data);
			var that = this;
			 $.ajax({
				type:"POST",
				contentType:"application/json;charset=utf-8",
				url:"${pageContext.request.contextPath}/api/v1/order/editOrderPost",
				async:true,
				dataType: "json",
				data: formToJson($("#form_orderEditInfo")),
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