<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/addSubject.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/zui/css/zui.css"/>
	</head>
	<body>
		<div class="alert alert-success" style="text-align: center;font-size: 20px;">新增课程</div>
		<div class="middle" id="middle">
			<form action="${pageContext.servletContext.contextPath}/addSubject.do" method="post">
				<div class="input-control has-label-left margind">
				  <div>课程名称：</div><input type="text" class="form-control paddingleft" name="name"/>
				</div>
				<div class="input-control has-label-left margind">
				  <div>开课星期：</div>
				  <select class="form-control sfselect" name="daySelect">
					<option value="0"><-请选择开课星期-></option>
					<option value="1">星期一</option>
					<option value="2">星期二</option>
					<option value="3">星期三</option>
					<option value="4">星期四</option>
					<option value="5">星期五</option>
					<option value="6">星期六</option>
					<option value="7">星期天</option>
				  </select>
				</div>
				<div class="input-control has-label-left margind">
				  <div>开课时间：</div>
				  <select class="form-control sfselect" name="timeSelect">
					<option value="0"><-请选择开课时间-></option>
					<option value="1">第一节</option>
					<option value="2">第二节</option>
					<option value="3">第三节</option>
					<option value="4">第四节</option>
					<option value="5">晚修</option>
				  </select>
				</div>
				<div class="input-control has-label-left margind rela">
					
				  <div>课程颜色编号：</div>
				  <select class="form-control sfselect" name="colorSelect" id="color" onclick="colors()">
					<option value="0"><-请选择颜色代码-></option>
					<option value="success">success</option>
					<option value="danger">danger</option>
					<option value="warning">warning</option>
					<option value="active">active</option>
				  </select>
				  <div class="ablt" id="colordiv"></div>
				</div>
				<button class="btn btn-primary auto" type="button" data-toggle="modal" data-target="#myModal">保存并提交</button>
				<div class="modal fade"  id="myModal">
				  <div class="modal-dialog">
					<div class="modal-content">
					  <div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">关闭</span></button>
						<h4 class="modal-title"></h4>
					  </div>
					  <div class="modal-body">
						<h3>是否新增该课程</h3>
					  </div>
					  <div class="modal-footer textcenter">
					  	<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-default btn-success" data-dismiss="modal">确定</button>
					  </div>
					</div>
				  </div>
				</div>
			</form>
		</div>
		
		<script type="text/javascript">
			window.onload = function(){
				var selects = document.getElementsByClassName("form-control");
				for(var i=0;i<selects.length;i++){
					selects[i].style.paddingLeft = "10px";
				}
			};
			function colors(){
				var colordiv = document.getElementById("colordiv");
				var select = document.getElementById("color");
				var index=select.selectedIndex;
				var itcolor = select[index].value;
				console.log(itcolor);
				if(itcolor=="success"){
					colordiv.style.backgroundColor = "#ddf4df";
				}else if(itcolor=="active"){
					colordiv.style.backgroundColor = "#ffe7bc";
				}else if(itcolor=="warning"){
					colordiv.style.backgroundColor = "#fff0d5";
				}else if(itcolor=="danger"){
					colordiv.style.backgroundColor = "#ffe5e0";
				}else{
					colordiv.style.backgroundColor = "#ccc";
				}
			};
		</script>
		<script src="${pageContext.servletContext.contextPath}/zui/lib/jquery/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.servletContext.contextPath}/zui/js/zui.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
