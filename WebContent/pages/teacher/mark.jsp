<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/mark.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/zui/css/zui.css"/>
	</head>
	<body>
			<div class="left" id="left">
				<div class="list-group">
				  <div class="title">
					  ${tclass}班的同学:
				  </div>
				  <c:forEach items="${slist}" var="list">
					    <a class="list-group-item courselist" onclick="actives(this)">${list.getName()}</a>
				  </c:forEach>
				</div>
			</div>
			
			<div class="right" id="right">
				<form action="${pageContext.servletContext.contextPath}/eachMark.do" method="post">
					<c:forEach items="${slist}" var="list">
						<input class="select" type="radio" name="select" value="${list.getName()}" />
				    </c:forEach>
					
					<button class="btn btn-lg btn-success" type="submit">打分</button>
						<!-- 对话框HTML -->
					 <!-- onclick="keepSuccess()" -->
				</form>
			</div>

		<script type="text/javascript">
			window.onload = function(){
				var selects = document.getElementsByClassName("select");
				for(var i=0;i<selects.length;i++){
					selects[i].style.height = "0px";
				}
				
				var right = document.getElementById("right");
				right.style.lineHeight = document.getElementById("left").offsetHeight+"px";
				console.log(hgt);
			};
			// function keepSuccess(){
			// 	
			// };
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
					for(var j=0;j<list.length;j++){
						if(j!=i){
							list[j].classList.remove("active");
							selects[j].checked = false;
						}
					}
				}
			};
		</script>
		<script src="${pageContext.servletContext.contextPath}/zui/lib/jquery/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.servletContext.contextPath}/zui/js/zui.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>

