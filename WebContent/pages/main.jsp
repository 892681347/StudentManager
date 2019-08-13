<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html name="main">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<frameset rows="40,*" frameborder="1" border="1" noresize>
		<frame src="pages/top.jsp" scrolling="no">
		<frameset cols="200,*">
			<frame src="pages/menu.jsp" scrolling="no">
			<frame src="pages/index.jsp" name="right">
		</frameset>
	</frameset>
</html>