<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>系统选择大厅</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<meta name="_csrf_parameter" content="${_csrf.parameterName}" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="author" content="es">
<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico">
<!-- Bootstrap 4.0-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/vendor_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Bootstrap 4.0-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/vendor_components/bootstrap/dist/css/bootstrap-extend.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/master_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/hall.css">
<!-- jQuery 3 -->
<script
	src="${pageContext.request.contextPath}/assets/vendor_components/jquery/dist/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/plugins/pagination.js"></script>
</head>
<body class="">
	<div class="container">
		<section class="content">
			<div class="row content-center" id="system-container">
				<!-- <div class="system-item col-5 col-md-4 col-lg-3 col-xl-3">
                        <div class="box box-body">
                            <div class="text-center pt-3">
                                <img class="avatar avatar-lg" src="../images/avatar/8.jpg">
                                <div class="mt-15 mb-0 title">用户管理系统</div>
                            </div>
                        </div>
                    </div> -->
			</div>
			<nav>
				<ul class="pagination justify-content-center" id="pagination"
					onselectstart="return false">
				</ul>
			</nav>
		</section>
	</div>
	<a href="javascript:void(0);" onclick="logout();">注销</a>
	<script src="${pageContext.request.contextPath}/js/pages/hall.js"></script>
</body>
</html>