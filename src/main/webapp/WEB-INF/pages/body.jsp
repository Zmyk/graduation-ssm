<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="../../static/js/jquery.min.js"></script>
	<script type="text/javascript" src="../../static/js/bootstrap.min.js"></script>
	<%
	String path = request.getContextPath();
	%>
	<link rel="stylesheet" href="<%=path %>/static/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/static/css/bodycss.css" />	
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="row">
		<div class="col-1"></div>
		<div class="col-2">
			<ul class="nav flex-column leibie">
				<li class="nav-item li-background">
					<a class="a_navfont nav-link active" href="http://www.taobao.com">手机</a>
				</li>
				<li class="nav-item li-background">
					<a class="a_navfont nav-link" href="#">电脑</a>
				</li>
				<li class="nav-item li-background">
					<a class="a_navfont nav-link" href="#">配件</a>
				</li>
				<li class="nav-item li-background">
					<a class="a_navfont nav-link" href="#">电器</a>
				</li>
				<li class="nav-item li-background">
					<a class="a_navfont nav-link" href="#">书籍</a>
				</li>
				<li class="nav-item li-background">
					<a class="a_navfont nav-link" href="#">娱乐</a>
				</li>
				<li class="nav-item li-background">
					<a class="a_navfont nav-link" href="#">运动</a>
				</li>
				<li class="nav-item li-background">
					<a class="a_navfont nav-link" href="#">代步</a>
				</li>
			</ul>
		</div>
		<div class="col-6">
			<div>
				<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					</ol>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img class="d-block w-100 image-lunbotu" src="<%=path %>/static/images/lunbotu1.jpg" alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block w-100 image-lunbotu" src="<%=path %>/static/images/lunbotu2.png" alt="Second slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<div class="row image-good-div">
				<div class="col-4">
					<img src="<%=path %>/static/images/1.jpg" alt="#" class="img-rounded img-responsive image-good">
				</div>
				<div class="col-4">
					<img src="<%=path %>/static/images/2.png" alt="#" class="img-rounded img-responsive image-good">
				</div>
				<div class="col-4">
					<img src="<%=path %>/static/images/3.jpg" alt="#" class="img-thumbnail img-responsive image-good">
				</div>
			</div>
			<div class="row image-good-div">
				<div class="col-4">
					<img src="<%=path %>/static/images/1.jpg" alt="#" class="img-rounded img-responsive image-good">
				</div>
				<div class="col-4">
					<img src="<%=path %>/static/images/2.png" alt="#" class="img-rounded img-responsive image-good">
				</div>
				<div class="col-4">
					<img src="<%=path %>/static/images/3.jpg" alt="#" class="img-thumbnail img-responsive image-good">
				</div>
			</div>
			<div class="row image-good-div">
				<div class="col-4">
					<img src="<%=path %>/static/images/1.jpg" alt="#" class="img-rounded img-responsive image-good">
				</div>
				<div class="col-4">
					<img src="<%=path %>/static/images/2.png" alt="#" class="img-rounded img-responsive image-good">
				</div>
				<div class="col-4">
					<img src="<%=path %>/static/images/3.jpg" alt="#" class="img-thumbnail img-responsive image-good">
				</div>
			</div>
			<div class="row image-good-div">
				<div class="col-4">
					<img src="<%=path %>/static/images/1.jpg" alt="#" class="img-rounded img-responsive image-good">
				</div>
				<div class="col-4">
					<img src="<%=path %>/static/images/2.png" alt="#" class="img-rounded img-responsive image-good">
				</div>
				<div class="col-4">
					<img src="<%=path %>/static/images/3.jpg" alt="#" class="img-thumbnail img-responsive image-good">
				</div>
			</div>
			<div class="row image-good-div">
				<div class="col-4">
					<img src="<%=path %>/static/images/1.jpg" alt="#" class="img-rounded img-responsive image-good">
				</div>
				<div class="col-4">
					<img src="<%=path %>/static/images/2.png" alt="#" class="img-rounded img-responsive image-good">
				</div>
				<div class="col-4">
					<img src="<%=path %>/static/images/3.jpg" alt="#" class="img-thumbnail img-responsive image-good">
				</div>
			</div>
		</div>
		<div class="col-2">
			<div class="row justify-content-md-center"><a class="a_font" href="#">天猫优惠</a></div>
			<div class="row justify-content-md-center div-tianmao"><img class="image-tianmao" src="<%=path %>/static/images/3.jpg"></div>
			<div class="row justify-content-md-center div-tianmao"><img class="image-tianmao" src="<%=path %>/static/images/3.jpg"></div>
			<div class="row justify-content-md-center div-tianmao"><img class="image-tianmao" src="<%=path %>/static/images/3.jpg"></div>
			<div class="row justify-content-md-center div-tianmao"><img class="image-tianmao" src="<%=path %>/static/images/3.jpg"></div>
			<div class="row justify-content-md-center div-tianmao"><img class="image-tianmao" src="<%=path %>/static/images/3.jpg"></div>
			<div class="row justify-content-md-center div-tianmao"><img class="image-tianmao" src="<%=path %>/static/images/3.jpg"></div>
		</div>
	</div>
</body>
</html>