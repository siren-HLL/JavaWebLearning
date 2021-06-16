<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>发票管理</title>
<jsp:include page="../commonCss.jsp"/>
</head>
<body>
	<jsp:include page="../main/top.jsp"/> 
	<jsp:include page="../main/left.jsp"/>
	<jsp:include page="../commonJs.jsp"/> 
<div id="wrapper">
	<div class="small-header transition">
		<div class="content">	
		<div class="row">
			<div class="col-lg-12">
				<div class="hpanel">
					<div class="panel-body">
						<table id="fapiaoTable" style="width:100%" class="table table-striped table-bordered table-hover">
							<thead>
								<tr class="row">
									<th class="col-lg-2">纳税人识别码</th>
									<th class="col-lg-2">单位名称</th>
									<th class="col-lg-2">注册地址</th>
									<th class="col-lg-2">注册电话</th>
									<th class="col-lg-2">发票类型</th>
									<th class="col-lg-2">操作</th>
								</tr>
							</thead>
							<tbody id="tbody"></tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript">
var contextPath = '${pageContext.request.contextPath}';
var header = $("meta[name='_csrf_header']").attr("content");
var token = $("meta[name='_csrf']").attr("content");

$(function(){
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
	var results;
	function showData(results){
		for(var i=0; i<results.length;i++){
			$("<tr></tr>").addClass("row")
				.append($("<td></td>").text(results[i].id).addClass("col-lg-2"))
				.append($("<td></td>").text(results[i].dwmc).addClass("col-lg-2"))
				.append($("<td></td>").text(results[i].zcdz).addClass("col-lg-2"))
				.append($("<td></td>").text(results[i].phone).addClass("col-lg-2"))
				.append($("<td></td>").text(results[i].fplx).addClass("col-lg-2"))
				.append($("<td></td>").html("<input type='button' value='删除' name = " + results[i].id_table +" class='test'/>").addClass("col-lg-2"))
				.appendTo($("tbody"))
		}
	}
	$.ajax({
		type:"GET",
		url:"${pageContext.request.contextPath}/api/v2/fapiao/getInfo",
		dataType:"json",
		contentType:"application/json;charset=utf-8",
		async:true,
		success:function(res){
			results = res.data
			//console.log(results)
			showData(results)
		},
		error:function(res){
			alert(res)
		}
	})
	 $("#tbody").on("click",".test",function(){
		//alert("你好") 
		var req = this.name
		req = "id_table="+req
		//req = $(this).parent().next().serialize()
		//req = eval("("+req+")");
		console.log(req)
		var that = this;
		$.ajax({
			type:"GET",
			url:"${pageContext.request.contextPath}/api/v2/fapiao/deleteGet",
			data: req,
			dataType:"json",
			contentType:"application/json;charset=utf-8",
			async:true,
			success:function(res){
				results = res.data
				console.log(results)
				console.log($(that))
				$(that).parents("tr").remove();
			},
			error:function(res){
				alert(res)
			}
		})   
	})
	
})

</script>
</body>
</html>