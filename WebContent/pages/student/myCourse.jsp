<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/myCourse.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/zui/css/zui.css"/>
	</head>
	<body>
		
		<div class="course">
			<div class="panel panel-info">
			  <div class="panel-heading">
				我的课程表
			  </div>
			  <table class="table table-bordered">
			  <thead>
				<tr>
				  <th>星期一</th>
				  <th>星期二</th>
				  <th>星期三</th>
				  <th>星期四</th>
				  <th>星期五</th>
				  <th>星期六</th>
				  <th>星期七</th>
				</tr>
			  </thead>
			  <tbody>
				<script type="text/javascript">
					for(var i=1;i<=5;i++){
						document.write("<tr>");
						for(var j=1;j<=7;j++){
							var a = '${myCourse}';
								var b = JSON.parse(a);
								var result = 0;
								for(var k=0;k<b.length;k++){
									
									if(j==b[k].day && i==b[k].time){
										var color = b[k].color;
										var subject = b[k].subject;
										document.write("<td class='td ");
									document.write(color);
									document.write("'>");
									document.write(subject);
									document.write("</td>"); 
									result++;
									}
									
								}
								if(result==0){
									document.write("<td class='td'></td>");
								}
							 
						}
						document.write("</tr>");
					}
				</script>
				
			  </tbody>
			</table>
			</div>
		</div>
		
		
		<script src="${pageContext.servletContext.contextPath}/zui/lib/jquery/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.servletContext.contextPath}/zui/js/zui.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
