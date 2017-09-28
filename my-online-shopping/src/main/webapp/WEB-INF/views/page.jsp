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
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">

			<!-- looding the page content -->
			<c:if test="${userClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- looding the about -->
			<c:if test="${userClickAbout == true }">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- looding the contact -->
			<c:if test="${userClickContact == true }">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<!-- load products -->
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			<!-- load single Product -->
			<c:if test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			
			<!-- load Manage product -->
			<c:if test="${userClickManageProducts == true}">
				<%@include file="manageProduct.jsp"%>
			</c:if>


		</div>

		<!-- /.container -->
		

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
		
	
		<!--  JAVA SCRIPT NECASSERY -->
		
		<!-- jquery -->
		<script src="${js}/jquery.js"></script>
		<!-- jquery validator-->
		<script src="${js}/jquery.validate.js"></script>
		<!-- Bootstrap core JavaScript -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
		<script src="${js}/bootstrap.min.js"></script>
		
		
		<!-- DataTable plugin -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!-- DataTable Bootstrap  Script  -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		
		
		<!-- Bootbox  -->
		<script src="${js}/bootbox.min.js"></script>

		
		


		<!-- Self coded javascript  -->
		<script src="${js}/myapp.js"></script>

		<!-- // ############################################################# -->

	</div>
</body>

</html>
