<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/eachMark.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/zui/css/zui.css"/>
	</head>
	<body>
		<div class="alert alert-success" style="text-align: center;font-size: 20px;">${UName}的成绩单</div>
		<div class="middle" id="middle">
			<form action="${pageContext.servletContext.contextPath}/saveGrades.do" method="post">
				<c:forEach items="${myCourseName}" var="courseName">
				    <div class="input-control has-label-left margind">
					  <div>${courseName}：</div><input type="text" class="form-control paddingleft" name="${courseName}"/>
					</div>
			    </c:forEach>
				<button class="btn btn-primary auto" type="button" data-toggle="modal" data-target="#myModal">保存并提交</button>
				<div class="modal fade"  id="myModal">
				  <div class="modal-dialog">
					<div class="modal-content">
					  <div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">关闭</span></button>
						<h4 class="modal-title"></h4>
					  </div>
					  <div class="modal-body">
						<h3>是否确定提交，可重复打分以最后一次为准</h3>
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
		</script>
		<script src="${pageContext.servletContext.contextPath}/zui/lib/jquery/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.servletContext.contextPath}/zui/js/zui.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
