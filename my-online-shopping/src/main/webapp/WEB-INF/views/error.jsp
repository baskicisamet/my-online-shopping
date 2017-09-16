<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />


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

		 <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/home">Home</a>
		
	</div>
</nav>
		

		<!-- Page Content -->
		<div class="content">
			<div class="container">
			
				<div class="row">
				
					<div class="col-lg-12">
					
						
						<div class="jumbotron">
						
							<h1>${errorTitle}</h1>
							<hr/>
						
							<blockquote style="word-wrap:break-word">
								
								${errorDescription}
							
							</blockquote>						
						
						</div>
						
											
					</div>					
				
				</div>
			
			</div>
		



		</div>

		<!-- /.container -->

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

	

	</div>
</body>

</html>
