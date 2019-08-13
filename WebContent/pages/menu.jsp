<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/menu.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/zui/css/zui.css"/>
		<script type="text/javascript">
			window.onload = function (){
				var stu = document.getElementsByClassName("student");
				var tch = document.getElementsByClassName("teacher");
				var admin = document.getElementsByClassName("admin");
				if("${type}"=="老师"){
					for(var i=0; i<stu.length; i++){
						stu[i].style.display="none";
					}
					for(var i=0; i<admin.length; i++){
						admin[i].style.display="none";
					}
				}
				if("${type}"=="学生"){
					for(var i=0; i<tch.length; i++){
						tch[i].style.display="none";
					}
					for(var i=0; i<admin.length; i++){
						admin[i].style.display="none";
					}
				}
				if("${type}"=="管理员"){
					for(var i=0; i<stu.length; i++){
						stu[i].style.display="none";
					}
					for(var i=0; i<admin.length; i++){
						tch[i].style.display="none";
					}
				}
				/* for(var i=0; i<stu.length; i++){
					stu[i].style.display="none";
				}
				for(var i=0; i<tch.length; i++){
					tch[i].style.display="none";
				}
				for(var i=0; i<admin.length; i++){
					admin[i].style.display="none";
				} */
			};
		</script>
</head>
	<body>
		<nav class="menu" data-ride="menu" style="width: 200px">
		<div class="card">
		  <img src="${user.getAvatar()}" class="round_icon">
		  <div class="card-heading text-center"><strong> ${user.getName()}</strong></div>
		  <div class="card-actions">
			<span class="label label-warning">CSUST</span>
			<div class="pull-right"><i class="icon-comments-alt"></i> ${type}</div>
		  </div>
		 </div>
		  <ul id="treeMenu" class="tree tree-menu" data-ride="tree">
			<li><a href="${pageContext.servletContext.contextPath}/pages/index.jsp" target="right"><i class="icon icon-th"></i>首页</a></li>
			<li><a href="${pageContext.servletContext.contextPath}/personinfo.do" target="right"><i class="icon icon-user"></i>个人资料</a></li>
			<!-- 学生功能 -->
			<li class="student"><a href="${pageContext.servletContext.contextPath}/searchGrades.do" target="right"><i class="icon icon-search"></i>查看成绩</a></li>
			<li class="student">
				<a href="#"><i class="icon icon-check-board"></i>课表及选课</a>
				<ul>
					<li><a href="${pageContext.servletContext.contextPath}/myCourse.do" target="right"><i class="icon icon-calendar"></i>我的课表</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/subject.do" target="right"><i class="icon icon-list-alt"></i>自主选课</a></li>
				</ul>
			</li>
			
			<li class="student"><a href="${pageContext.servletContext.contextPath}/class.do" target="right"><i class="icon icon-group"></i>班级信息</a></li>
			<!-- 老师功能 -->
			<li class="teacher"><a href="${pageContext.servletContext.contextPath}/mark.do" target="right"><i class="icon icon-tags"></i>成绩打分</a></li>
			<li class="teacher"><a href="${pageContext.servletContext.contextPath}/class.do" target="right"><i class="icon icon-group"></i>班级信息</a></li>
			<!-- 管理员功能 -->
			<li class="admin">
				<ul>
					<li><a href="${pageContext.servletContext.contextPath}/pages/admin/tmodifyclass.jsp" target="right">老师</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/pages/admin/smodifyclass.jsp" target="right">同学</a></li>
				</ul>
			</li>
			<li class="admin">
				<a href="#"><i class="icon icon-plus-sign"></i>添加人员</a>
				<ul>
					<li><a href="${pageContext.servletContext.contextPath}/pages/admin/addteacher.jsp" target="right">老师</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/pages/admin/addstudent.jsp" target="right">同学</a></li>
				</ul>
			</li>
			<li class="admin"><a href="${pageContext.servletContext.contextPath}/pages/admin/addsubject.jsp" target="right"><i class="icon icon-plus-sign-alt"></i>添加课程</a></li>
		  </ul>
		</nav>
		<script src="${pageContext.servletContext.contextPath}/zui/lib/jquery/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.servletContext.contextPath}/zui/js/zui.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
