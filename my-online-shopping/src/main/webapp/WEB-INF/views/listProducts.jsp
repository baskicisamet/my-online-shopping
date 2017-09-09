<div class="container">

	<div class="row">

		<!-- wold be display sidebar -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<!-- would be display products -->
		<div class="col-md-9">

			<!-- added breadcumb component -->
			<div class="row">

				<div class="col-lg-12">

					<c:if test="${userClickAllProducts == true}">
						<ol class="breadcrumb">

							<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/home">Home</a></li>
							<li class="breadcrumb-item active">All products</li>

						</ol>
						
					</c:if>

					<c:if test="${userClickCategoryProducts == true}">
					
						<ol class="breadcrumb">

							<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/home">Home</a></li>
							<li class="breadcrumb-item active">Category</li>
							<li class="breadcrumb-item active">${category.name}</li>

						</ol>
					</c:if>

				</div>

			</div>

		</div>

	</div>

</div>