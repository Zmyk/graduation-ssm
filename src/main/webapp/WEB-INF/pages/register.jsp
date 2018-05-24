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
			<h1 class="myh">用户注册</h1>
		</div>
		<div class="row">
			<input type="text" id="phoneNumber" name="phoneNumber"
			placeholder="请输入手机号" autocomplete="off" class="input">
		</div>
		<div class="row">
			<input type="password" id="password" name="password"
			placeholder="请输入密码" autocomplete="off" class="input">
		</div>
		<div class="row">
			<input type="password" id="repassword" name="repassword"
			placeholder="请重复输入密码" autocomplete="off" class="input">
		</div>
		<div class="row">
			<input type="text" id="checkCode" name="checkCode"
			placeholder="请输入短信验证码" autocomplete="off" class="input phoneCod">
			<button id="myButton" class="btn btn-success getbtn" onclick="getCheckCode()">获取验证码</button>
		</div>
		<div class="row">
			<button type="submit" class="btn btn-success mybtn" onclick="register()">注册</button>
		</div>
		<div class="row">
			<a class="btn btn-success mybtn" href="http://localhost:8080/ssm_graduation/skip/login.action">返回登录</a>
		</div>
	</div>
</body>
</html>

<script language="JavaScript">

function startCountDown() {
	$('#myButton').text(60)
	var myVar = setInterval(function() {
		$('#myButton').text($('#myButton').text() - 1)
		if ($('#myButton').text() === '0') {
			clearInterval(myVar)
			$('#myButton').text('重新发送')
			$('#myButton').removeAttr('disabled')
		}
	}, 1000)
	$('#myButton').attr('disabled', 'disabled')
}

//获取验证码
function getCheckCode() {
	window.location.href='http://www.jb51.net';
	console.log(1)
	break
	console.log(2)
	if(isPhoneNum()){
		$.ajax({
			type : 'POST',
			data : {
				phoneNumber : $("#phoneNumber").val()
			},
			url : "http://localhost:8080/ssm_graduation/register/getCheckCode.action",
			success : function(data) {
			},
			error : function() {
			},
			complete : function() {
			}
		});
		startCountDown();
	}
	else{
		alert('请输入有效的手机号码！'); 
	}
}

//验证手机号码格式
function isPhoneNum(){
	var phonenum = $("#phoneNumber").val();
	var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
	if(!myreg.test(phonenum)){ 
		return false; 
	}else{
		return true;
	}
}
</script>