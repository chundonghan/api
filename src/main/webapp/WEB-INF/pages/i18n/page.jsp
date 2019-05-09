<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>springmvc 国际化</title>
</head>
<body>
	<spring:message code="msg"/><br>
	Locale:${pageContext.response.locale }
</body>
</html>