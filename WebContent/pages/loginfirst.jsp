<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/zui/css/zui.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/main.css"/>
	</head>
	<body>
		<div class="main">
			<div class="middlediv auto">
				<form action="${pageContext.servletContext.contextPath}/login.do"  method="post">
					<h2 class="title">欢迎登陆学生管理系统</h2>
					<div class="iconsfdiv auto">
						<div class="iconimg">
							<i class="icon icon-user icon-5x"></i>
						</div>
						<div class="selecter auto">
							<span>身份选择</span>
							<select class="form-control sfselect" name="type">
							  <option value="学生">学生</option>
							  <option value="老师">老师</option>
							  <option value="管理员">管理员</option>
							</select>
						</div>
					</div>
					
					
					<div class="input-control has-icon-left">
					  <input id="inputAccountExample1" name="account" type="text" class="form-control" placeholder="用户名">
					  <label for="inputAccountExample1" class="input-control-icon-left"><i class="icon icon-user "></i></label>
					</div>
					
					<div class="input-control has-icon-left has-icon-right">
					  <input id="inputEmailExample1" name="password" type="password" class="form-control" placeholder="密码">
					  <label for="inputEmailExample1" class="input-control-icon-left"><i class="icon icon-lock "></i></label>
					</div>
					<div class="input-control has-icon-right left yzm">
					  <input id="inputPasswordExample1" name="vcode" type="text" class="form-control" placeholder="验证码">
					</div>
					<div class="left">
						<img src="${pageContext.servletContext.contextPath}/code.do" class="yzmdiv" onclick="changeCode(this)">
					</div>
					<div class="clear"></div>
					<button class="btn btn-blue login auto" type="submit">
						登录
						<div class="hidding">${msg}</div>
					</button>
					<div class="bottomdiv">
						<p>长沙理工大学学生管理系统</p>
						<p>建议浏览器：谷歌、火狐或IE10以上版本</p>
					</div>
				</form>
				
			</div>
		</div>
		
		<script type="text/javascript">
			function changeCode(o){
				o.src = "${pageContext.servletContext.contextPath}/code.do?"+new Date().getTime();
			}
		</script>
		<script src="${pageContext.servletContext.contextPath}/zui/js/zui.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
