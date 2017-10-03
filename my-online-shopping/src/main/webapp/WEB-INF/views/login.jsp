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
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href=""${contextRoot}/home">Online Shopping</a>
				</div>
			</div>
		</nav>
		
		


		<!-- Page Content -->
		<div class="content">
			
			<div class="container">

				<div class="row justify-content-md-center" >
				
				
					<c:if test="${not empty message}">
					
						<div class="row col-lg-12 justify-content-md-center ">
							<div class="col-xs-12 col-lg-10">
								
								<div class="alert alert-danger alert-dismissible">
								
								 	<button type="button" class="close" data-dismiss="alert">&times;</button>
								 	
								 	${message}
								
								</div>
							</div> 
						</div>
					</c:if>
				
					<div class=" col-md-6 ">
						<div class="card card-primary">
							<div class="card-header">
								<h4>Login</h4>
							</div>
							<div class="card-body">
								
								<div class="container " style="margin-top:10px">
								
								<!-- FORM ELEMENTS -->
								<form class="form-horizontal col-md-12 justify-content-md-center"  action="${contextRoot}/login" method="POST" id="loginForm">
								
								
									<div class="form-group row col-md-offset-2 ">
									
										<label class="col-form-label col-md-3" for="username">Email : </label>
										
										<div class="col-md-9">
											<input type="text" name="username" id="username" placeholder="Email" class="form-control" />						
										</div>
										
									</div>
									
									<div class="form-group row col-md-offset-2 ">
									
										<label class="col-form-label col-md-3" for="name">Password : </label>
										
										<div class="col-md-9">
											<input type="password" name="password" id="password" placeholder="Password" class="form-control" />
										</div>
										
									</div>
									
									
			
							
									<div class="form-group row "> 
									 
										<p class="col-md-3"><p>
										
										<div class="col-md-5 col-md-offset-5">
											<input type="submit" value="login"   id="submit" placeholder="Submit" class="btn btn-primary " />
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
 										</div>
									</div>
									
									
									
									
								
								</form>
			
								
								</div>
			
							</div>
							<div class="card-footer text-right">
							    <a href="${rootContext}/register">Register Here</a>
							</div>
						</div>
					</div>
				</div>



	






	
	
	


</div>
	 

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
		
		



		<!-- Self coded javascript  -->
		<script src="${js}/myapp.js"></script>

		<!-- // ############################################################# -->

	</div>
</body>

</html>
