<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/courseSelect.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/zui/css/zui.css"/>
	</head>
	<body>
		<div class="list-group">
		  <c:forEach items="${courses}" var="course">
			    <a class="list-group-item courselist" onclick="actives(this)">${course}</a>
		  </c:forEach>
		</div>
		<form action="${pageContext.servletContext.contextPath}/saveCourse.do" method="post">
		
			<c:forEach items="${courses}" var="course">
			    <input class="select" type="checkbox" name="select" value="${course}" />
		    </c:forEach>
			
			<div class="clear"></div>
			<div class="keep">
				<button class="btn btn-lg btn-success" type="button" data-toggle="modal" data-target="#myModal">保存</button>
				<!-- 对话框HTML -->
				<div class="modal fade"  id="myModal">
				  <div class="modal-dialog">
					<div class="modal-content">
					  <div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">关闭</span></button>
						<h4 class="modal-title"></h4>
					  </div>
					  <div class="modal-body">
						<h3>是否提交所选课程，可多次选择以最后一次为准</h3>
					  </div>
					  <div class="modal-footer textcenter">
					  	<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-default btn-success" data-dismiss="modal">确定</button>
					  </div>
					</div>
				  </div>
				</div>
			</div>
		</form>

		<script type="text/javascript">
			window.onload = function(){
				var selects = document.getElementsByClassName("select");
				for(var i=0;i<selects.length;i++){
					selects[i].style.height = "0px";
				}
			};
			
			function actives(o){
				var index = 0;
				var list = document.getElementsByClassName("list-group-item");
				for(var i=0;i<list.length;i++){
					if(o==list[i]){
						index = i;
						break;
					}
				}
				var selects = document.getElementsByClassName("select");
				if(o.classList.contains('active')==true){
					o.classList.remove("active");
					selects[i].checked = false;
				}else{
					o.classList.add("active");
					selects[i].checked = true;
				}
			};
		</script>
		<script src="${pageContext.servletContext.contextPath}/zui/lib/jquery/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.servletContext.contextPath}/zui/js/zui.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
    