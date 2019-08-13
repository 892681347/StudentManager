<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/zui/css/zui.css"/>
	</head>
	<body>
		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<!-- 导航头部 -->
				<div class="navbar-header">
					<!-- 品牌名称或logo -->
					<div class="navbar-brand" href="#">CSUST</div>
				</div>
				<!-- 导航项目 -->
				<div class="collapse navbar-collapse navbar-collapse-example">
					<!-- 一般导航项目 -->
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">项目</a></li>
						<!-- 导航中的下拉菜单 -->
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">管理 <b class="caret"></b></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">任务</a></li>
							</ul>
						</li>
					</ul>
					<!-- 右侧的导航项目 -->
					<ul class="nav navbar-nav navbar-right">
						<li><a href="${pageContext.servletContext.contextPath}/personinfo.do" target="right">欢迎  ${user.getName()}</a></li>
						<li class="dropdown">
							<a href="${pageContext.servletContext.contextPath}/pages/loginfirst.jsp" class="dropdown-toggle" data-toggle="dropdown" target="_top">退出</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		
		<script src="${pageContext.servletContext.contextPath}/zui/js/zui.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
