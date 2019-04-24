<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>第一个springmvc程序</title>
</head>
<body>
	【requestScope】: ${requestScope.msg }
	<br>
	【request】: ${msg }
	<br>
	【sessionScope】: ${sessionScope.msg }
	<hr>
	
	<!-- 注册功能 -->
	<form action="${pageContext.request.contextPath }/three/fifth.do" method="post">
		用户名:<input type="text" name="username"><br>
		密码:<input type="text" name="password"><br>
		性别:<input type="radio" name="sex" value="男">男
			<input type="radio" name="sex" value="女">女<br>
		汽车:<input type="text" name="car.carName"><br>
			<input type="submit" value="提交">
	</form>
	<hr>
	
	<!-- 数组类型-批量删除 -->
	<form action="${pageContext.request.contextPath }/three/delete.do" method="post">
		<input type="checkbox" value="1" name="ids">1<br>
		<input type="checkbox" value="2" name="ids">2<br>
		<input type="checkbox" value="3" name="ids">3<br>
		<input type="submit" value="批量删除">
	</form>
</body>
</html>