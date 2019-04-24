<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.1.1.js"></script>
</head>
<body>

	<form action="">
		用户名:<input type="text" id="username"><br>
		密码:<input type="text" id="password"><br>
		<input type="button" onclick="jsonSubmit()" value="登录">
	</form>
	
	<script type="text/javascript">
		//$(function(){
			function jsonSubmit(){
				// 1.获取用户输入的数据
				var username = $('#username').val();
				var password = $('#password').val();
				
				
				// 创建json对象
				var jsonObj = {
					'username':username,
					'password':password
				};
				// 把json对象转换为json字符串
				var jsonStr = JSON.stringify(jsonObj);
				// 把json字符串转换成json对象
				var jsonObject = JSON.parse(jsonStr);
				//alert(jsonObject.username)
				
				
				// 2.ajax请求
				$.ajax({
					url:'${pageContext.request.contextPath}/login3',
					type:'post',
					// 传递json对象比较方便,如果一定要传递json字符串,则需要修改响应头的contentType
					// data:jsonObj,
					data:jsonStr,
					// 修改contentType请求的数据格式类型,定义为json字符串类型
					contentType:'application/json; charset=UTF-8',
					// 返回数据类型
					dataType:'json',
					success:function(data){
						alert(data.code);
					}
				})
			};
		//})
	</script>

</body>
</html>