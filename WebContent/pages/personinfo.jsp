<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/personalinfo.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/zui/css/zui.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/zui/lib/uploader/zui.uploader.min.css" />
		<script type="text/javascript">
			window.onload = function(){
				var per = document.getElementById("per");
				per.style.width = "${per}%";
			};
		</script>
	</head>
	<body>
		<div class="infotop">
			
			<div class="topleft">
			  <img src="${user.getAvatar()}" class="tximg">
			  <a class="changeword" data-toggle="modal" href="#myModal"><div class="changeimg">更换头像</div></a>
			  <div class="modal fade" id="myModal">
				  <div class="modal-dialog">
					<div class="modal-content">
					  <div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">关闭</span></button>
						<h4 class="modal-title">上传头像</h4>
					  </div>
					  <div class="modal-body">
						
						<!-- 头像上传 -->
						<div id='uploaderExample' class="uploader" data-ride="uploader" data-url="${pageContext.servletContext.contextPath}/upload.do">
						  <div class="uploader-message text-center">
							<div class="content"></div>
							<button type="button" class="close">×</button>
						  </div>
						  <div class="uploader-files file-list file-list-lg file-rename-by-click" data-drag-placeholder="请拖拽文件到此处"></div>
						  <div>
							<hr class="divider">
							<div class="uploader-status pull-right text-muted"></div>
							<button type="button" class="btn btn-link uploader-btn-browse"><i class="icon icon-plus"></i> 选择文件</button>
							<button type="button" class="btn btn-link uploader-btn-start"><i class="icon icon-cloud-upload"></i> 开始上传</button>
						  </div>
						</div>
					  </div>
					  <div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal"><a href="${pageContext.servletContext.contextPath}/refresh.do" target="_top">关闭</a></button>
					  </div>
					</div>
				  </div>
				</div>
			</div>
			
			<div class="topright">
				<div>昵称：&nbsp;&nbsp;<span>${user.getName()}</span></div>
				<div class="margintop">账户类型：<span>${type}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></div>
				<div class="margintop">UID：&nbsp;&nbsp;<span>${user.getAccount()}</span></div>
				<div class="margintop">
					<div class="left">资料完整度：</div>
					<div class="progress progress-striped active">
					  <div id="per" class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
					  </div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="infodown">
			<table class="table table-striped" style="border:1px solid #ddd;">
			  <tbody>
				<tr>
				  <td>性别</td>
				  <td>${info.getSex()}</td>
				  <td> </td>
				  <td><span class="label label-warning"><a href="${pageContext.servletContext.contextPath}/pages/changeinfo.jsp">设置</a></span></td>
				</tr>
				<tr>
				  <td>血型</td>
				  <td>${info.getBloodType()}</td>
				  <td> </td>
				  <td><span class="label label-warning"><a href="${pageContext.servletContext.contextPath}/pages/changeinfo.jsp">设置</a></span></td>
				</tr>
				<tr>
				  <td>年龄</td>
				  <td>${info.getAge()}</td>
				  <td> </td>
				  <td><span class="label label-warning"><a href="${pageContext.servletContext.contextPath}/pages/changeinfo.jsp">设置</a></span></td>
				</tr>
				<tr>
				  <td>居住地</td>
				  <td>${info.getSite()}</td>
				  <td> </td>
				  <td><span class="label label-warning"><a href="${pageContext.servletContext.contextPath}/pages/changeinfo.jsp">设置</a></span></td>
				</tr>
				<tr>
				  <td>QQ</td>
				  <td>${info.getQq()}</td>
				  <td> </td>
				  <td><span class="label label-warning"><a href="${pageContext.servletContext.contextPath}/pages/changeinfo.jsp">设置</a></span></td>
				</tr>
				<tr>
				  <td>星座</td>
				  <td>${info.getConstellation()}</td>
				  <td> </td>
				  <td><span class="label label-warning"><a href="${pageContext.servletContext.contextPath}/pages/changeinfo.jsp">设置</a></span></td>
				</tr>
				<tr>
				  <td>兴趣爱好</td>
				  <td>${info.getInterest()}</td>
				  <td> </td>
				  <td><span class="label label-warning"><a href="${pageContext.servletContext.contextPath}/pages/changeinfo.jsp">设置</a></span></td>
				</tr>
			  </tbody>
			</table>
		</div>
		
		
		<script type="text/javascript">
			$('#uploaderExample').uploader({
				autoUpload: false,            // 当选择文件后立即自动进行上传操作
				url: '${pageContext.servletContext.contextPath}/upload.do'  // 文件上传提交地址
			});
		</script>
		<script src="${pageContext.servletContext.contextPath}/zui/lib/jquery/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.servletContext.contextPath}/zui/js/zui.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.servletContext.contextPath}/zui/lib/uploader/zui.uploader.min.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
