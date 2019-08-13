<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/zui/css/zui.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/grades.css"/>
	</head>
	<body>
		<div class="title">
			<h2>长沙理工大学成绩查询</h2>
		</div>
		<div class="msg">
			姓名：<div class="spanstyle">张毅豪</div>
			账号：<div class="spanstyle">892681347</div>
			考试批次：<div class="spanstyle">2019学年期末考试</div>
		</div>
		<table class="table tablestyle table-bordered">
		  <thead>
			<tr>
			  <th class="textcenter"><h4>科目名称</h4></th>
			  <th class="textcenter"><h4>成绩</h4></th>
			</tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${myGrades}" var="myOneGrade">
			    <tr class="textcenter">
				  <td>${myOneGrade.getCourseName()}</td>
				  <td>${myOneGrade.getGrade()}</td>
				</tr>
		    </c:forEach>
			<!-- <tr class="textcenter">
			  <td>高等数学</td>
			  <td>98</td>
			</tr>
			<tr class="textcenter">
			  <td>初级会计实务</td>
			  <td>80</td>
			</tr> -->
		  </tbody>
		</table>
		
		<script src="${pageContext.servletContext.contextPath}/zui/lib/jquery/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.servletContext.contextPath}/zui/js/zui.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
