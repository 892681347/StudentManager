<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 引入下面这个c语法需要引入两个jar包 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/zui/css/zui.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/class.css"/>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
		<!-- 班级介绍 -->
		<div class="introduce">
			<span class="label label-dot label-warning"></span>
			<div class="btn"><i class="icon icon-home ic"></i>班级信息</div>
			<div class="incontent">
				<h3>你所在的班级是：</h3>
				<h5>203班</h5>
			</div>	
		</div>
		<!-- 班级老师 -->
		<div class="teacher">
			<span class="label label-dot label-success"></span>
			<div class="btn"><i class="icon icon-leaf tic"></i>老师列表</div>
			<div class="tecontent">
				<table class="table table-hover table-striped">
				  <thead>
					<tr>
					  <th class="success">头像</th>
					  <th class="success">姓名</th>
					  <th class="success">账号</th>
					  <th class="success">班级</th>
					</tr>
				  </thead>
				  <tbody>
				  
					<c:forEach items="${tlist}" var="t">
					   	<tr>
					      <td><img src="${t.getAvatar()}" width="50px"></td>
					      <td>${t.getName()}</td>
					      <td>${t.getAccount()}</td>
					      <td>${t.getTclass()}</td>
					    </tr>
				    </c:forEach>
				    <!-- <td>1</td>
				    <td>2</td>
				    <td>3</td>
				    <td>4</td> -->
				  </tbody>
				</table>
			</div>
		</div>
		<!-- 班级同学 -->
		<div class="student">
			<span class="label label-dot  label-danger"></span>
			<div class="btn"><i class="icon icon-gift sic"></i>同学列表</div>
			<div class="stcontent">
				<table class="table table-hover table-striped">
				  <thead>
					<tr>
					  <th class="danger">头像</th>
					  <th class="danger">姓名</th>
					  <th class="danger">账号</th>
					  <th class="danger">班级</th>
					</tr>
				  </thead>
				  <tbody>
				  
					<c:forEach items="${slist}" var="s">
					    <tr>
					      <td><img src="${s.getAvatar()}" width="50px"></td>
					      <td>${s.getName()}</td>
					      <td>${s.getAccount()}</td>
					      <td>${s.getSclass()}</td>
					    </tr>
				    </c:forEach>
				    
				    
				  </tbody>
				</table>
			</div>
		</div>
		<div style="height: 50px;"></div>
		<script src="${pageContext.servletContext.contextPath}/zui/lib/jquery/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.servletContext.contextPath}/zui/js/zui.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
