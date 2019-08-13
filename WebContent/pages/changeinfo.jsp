<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/changeinfo.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/zui/css/zui.css"/>
	<head>
		<meta charset="utf-8">
		<title></title>
		<script type="text/javascript">
			window.onload = function(){
				var sex1 = document.getElementById("sex1");
				var sex2 = document.getElementById("sex2");
				var bloodtype = document.getElementById("bloodtype");
				var age = document.getElementById("age");
				var qq = document.getElementById("qq");
				var constellation = document.getElementById("constellation");
				var site = document.getElementById("site");
				var interest = document.getElementById("interest");
				if("${info.getSex()}"=="男"){
					sex1.checked = true;
				}else{
					sex2.checked = true;
				}
				bloodtype.value = "${info.getBloodType()}";
				age.value = "${info.getAge()}";
				qq.value = "${info.getQq()}";
				constellation.value = "${info.getConstellation()}";
				site.value = "${info.getSite()}";
				interest.value = "${info.getInterest()}";
			};
		</script>
	</head>
	<body>
		<div class="title">
			<div class="titleword">
				基本信息
			</div>
		</div>
		<div class="down">
			<form action="${pageContext.servletContext.contextPath}/changeinfo.do" method="post">
				<div class="eachinfo">
					<div class="left" style="width: 26px;height: 29.6px;"></div>
					<div class="left">性别：</div>
					<div class="left">
						<div class="radio-primary left"><input type="radio" name="sex" id="sex1" value="男"><label for="primaryradio1">男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></div>
						<div class="radio-primary left"><input type="radio" name="sex" checked="checked" id="sex2"  value="女"><label for="primaryradio2">女&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></div>	
					</div>
				</div>
				<div class="clear"></div>
				<div class="eachinfo">
					<div class="left" style="width: 26px;height: 29.6px;"></div>
					<div class="left lineheight">血型：</div>
					<div class="left">
						<div class="input-control has-label-left">
						  <input id="bloodtype" type="text" name="bloodtype" class="form-control padidngleft" placeholder="">
						</div>
					</div>
				</div>
				<div class="clear"></div>
				<div class="eachinfo">
					<div class="left" style="width: 26px;height: 29.6px;"></div>
					<div class="left lineheight">年龄：</div>
					<div class="left">
						<div class="input-control has-label-left">
						  <input id="age" type="text" name="age" class="form-control padidngleft">
						</div>
					</div>
				</div>
				<div class="clear"></div>
				<div class="eachinfo">
					<div class="left" style="width: 31.77px;height: 29.6px;"></div>
					<div class="left lineheight">QQ：</div>
					<div class="left">
						<div class="input-control has-label-left">
						  <input id="qq" type="text" name="qq" class="form-control padidngleft">
						</div>
					</div>
				</div>
				<div class="clear"></div>
				<div class="eachinfo">
					<div class="left" style="width: 26px;height: 29.6px;"></div>
					<div class="left lineheight">星座：</div>
					<div class="left">
						<div class="input-control has-label-left">
						  <input id=constellation type="text" name="constellation" class="form-control padidngleft">
						</div>
					</div>
				</div>
				<div class="clear"></div>
				<div class="eachinfo">
					<div class="left" style="width: 13px;height: 29.6px;"></div>
					<div class="left lineheight">居住地：</div>
					<div class="left">
						<div class="input-control has-label-left">
						  <input id="site" type="text" name="site" class="form-control padidngleft" placeholder="">
						</div>
					</div>
				</div>
				<div class="clear"></div>
				<div class="eachinfo">
					<div class="left lineheight">兴趣爱好：</div>
					<div class="left">
						<div class="input-control has-label-left">
						  <input id="interest" type="text" name="interest" class="form-control padidngleft" placeholder="">
						</div>
					</div>
				</div>
				<div class="clear"></div>
				<button class="btn btn-blue btn-success marginleft" type="submit">
					保存
				</button>
			</form>	
		</div>
			
			
		<script src="${pageContext.servletContext.contextPath}/zui/lib/jquery/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.servletContext.contextPath}/zui/js/zui.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
