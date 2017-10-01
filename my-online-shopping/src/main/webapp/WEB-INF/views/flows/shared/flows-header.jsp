<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

	<meta charset="utf-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>Online shopping - ${title}</title>

	<script type="text/javascript">
		window.menu = '${title}'; //javascript hangi sayfada oldugumuzu bu degisken uzerinden alicak(actve menu icin)
		window.contextRoot = '${contextRoot}';
	</script>

	<!-- Bootstrap core CSS -->
	<link href="${css}/bootstrap.min.css" rel="stylesheet">


	
	
	<!-- Bootstrap Theme CSS -->
	<%-- <link href="${css}/bootstrap-yeti-theme.css" rel="stylesheet"> --%>
	
	<!-- Bootstrap DataTable CSS -->
	<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
	
	<!--  for icons  -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	
	<!-- Custom styles for this template -->
	<link href="${css}/myapp.css" rel="stylesheet">
	
	
	

</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="flows-navbar.jsp" %>



		<!-- Page Content -->
		<div class="content">