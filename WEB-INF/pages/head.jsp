<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>校园二手网</title>
<script type="text/javascript" src="../../static/js/jquery.min.js"></script>
<script type="text/javascript" src="../../static/js/bootstrap.min.js"></script>
<%
	String path = request.getContextPath();
%>
<link rel="stylesheet" href=" <%=path %>/static/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=path %>/static/css/headcss.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="row head-warp1">
		<div class="col-1"></div>
		<div class="col-2  div1">校园二手网</div>
		<div class="col-1">
			<div class="row div2">信大二手网</div>
			<div class="row div3">www.taobao.com</div>
		</div>

		<div class="col-3 div4">
			<ul class="nav nav-tabs rmline navbar-static-top">
				<li role="presentation" class="li"><a class="navfont"
					href="body.html" target="body">首页</a></li>
				<li role="presentation" class="li"><a class="navfont"
					href="http://www.taoertao.com/quan" target="_Blank">优惠券</a></li>
				<li role="presentation" class="li"><a class="navfont"
					href="http://www.taobao.com" target="_Blank">爱淘宝</a></li>
			</ul>
		</div>
		<div class="col-2"></div>
		<div class="col-1 div4">
			<a class="a" href="http://www.taobao.com" target="_parent">登录</a>
		</div>
		<div class="col-1 div4">
			<a class="a" href="http://www.taobao.com" target="_parent">注册</a>
		</div>
	</div>
	<div class="row head-warp2">
		<div class="col-1"></div>
		<div class="col-5">
			<form class="form-inline">
				<div class="form-group">
					<input type="text" class="form-control" id="exampleInputName2"
						placeholder="Jane Doe">
				</div>
				<button class="btn btn-default" type="submit" display="inline">搜索</button>
			</form>
		</div>
		<div class="col-6"></div>
		<div class="col-1">
			<button type="button" class="btn btn-success mybtn">发布</button>
		</div>
	</div>
</body>
</html>