<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>注册-大学生二手交易网</title>
	<%
	String path = request.getContextPath();
	%>
	<script type="text/javascript" src="<%=path%>/static/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path%>/static/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="<%=path%>/static/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css"
	href="<%=path%>/static/css/registercss.css" />
</head>
<body>

	<div class="row up-div">
		<h1 class="myh font h">校园二手网</h1>
	</div>
	<div class="registerMain-div">
		<div>
			<h1 class="myh">用户登录</h1>
		</div>
		<div class="row">
			<input type="text" id="phoneNumber" name="phoneNumber"
			placeholder="账号/手机号" autocomplete="off" class="input">
		</div>
		<div class="row">
			<input type="password" id="password" name="password"
			placeholder="请输入密码" autocomplete="off" class="input">
		</div>
		<div>
			<button class="btn btn-success mybtn">登录</button>
		</div>
		<div>
			<a class="btn btn-success mybtn" href="http://localhost:8080/ssm_graduation/user/list.action">注册</a>
		</div>
	</div>
</body>
</html>
