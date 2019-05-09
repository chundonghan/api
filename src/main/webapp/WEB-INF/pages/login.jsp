<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录页面</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="description" content="api login">
<meta name="author" content="es">
<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico">
<!-- Bootstrap 4.0-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/vendor_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Bootstrap 4.0-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/vendor_components/bootstrap/dist/css/bootstrap-extend.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/master_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/skins/_all-skins.css">
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<b>API</b> Admin
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">请登录</p>
			<div class="form-element">
				<div class="form-group has-feedback">
					<input id="account" type="text" class="form-control" placeholder="账号/邮箱/手机号">
					<span class="ion ion-person form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input id="passwd" type="password" class="form-control" placeholder="密码">
					<span class="ion ion-locked form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-6">
						<div class="checkbox">
							<input type="checkbox" id="basic_checkbox_1"> <label
								for="basic_checkbox_1">记住我</label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-6">
						<div class="fog-pwd">
							<a href="javascript:void(0)"><i class="ion ion-locked"></i>
								忘记密码?</a><br>
						</div>
					</div>
					<div class="col-12 text-center">
						<button id="login" class="btn btn-info btn-block margin-top-10">登录</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery 3 -->
	<script
		src="${pageContext.request.contextPath}/assets/vendor_components/jquery/dist/jquery.min.js"></script>

	<!-- popper -->
	<script
		src="${pageContext.request.contextPath}/assets/vendor_components/popper/dist/popper.min.js"></script>

	<!-- Bootstrap 4.0-->
	<script
		src="${pageContext.request.contextPath}/assets/vendor_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/login.js"></script>
</body>
</html>