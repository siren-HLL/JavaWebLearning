<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>用户积分管理</title>
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
						<table id="jiFenTable" style="width: 100%;" class="table table-striped table-bordered table-hover">
						
							<thead >
					            <tr class="row">
					                <th class="col-lg-2">用户ID</th>
					                <th class="col-lg-4">最后登陆时间</th>
					                <th class="col-lg-4">注册时间</th>
					                <th class="col-lg-1">积分</th>
					                <th class="col-lg-1">操作</th>
					            </tr>
       			 			</thead>
       			 			<tbody id="tbody" ></tbody>
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
	$.ajax({
		type:"GET",
		contentType:"application/json;charset=utf-8",
		url:"${pageContext.request.contextPath}/api/v2/user/getDynamicTableInfoGet",
		async:true,
		dataType: "json",
		success:function(json){
			results = json.data
			console.log(results)
			$table = $("<table>");
			for(var i=0; i < results.length ;i++){
				$("<tr></tr>")
				.addClass("row")
				.append($("<td></td>").text(results[i].userName).addClass("col-lg-2"))
				.append($("<td></td>").text(results[i].lastLoginTime).addClass("col-lg-4"))
				.append($("<td></td>").text(results[i].registerTime).addClass("col-lg-4"))
				.append($("<td></td>").text(results[i].integration).addClass("col-lg-1"))
				.append($("<td></td>").html("<a href='#'>编辑</a>").addClass("col-lg-1"))
				.appendTo($("tbody"))
			}
		},
		error: function(json) {
			alert(json);
		}
	})
	console.log("外面"+results);
	
	
	
})



</script>	
	

</body>
</html>