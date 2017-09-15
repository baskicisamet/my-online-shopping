<div class="container">


	<!-- BreadCrumb -->
	<div class="row">
		<div class="col-lg-12">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
				<li class="breadcrumb-item"><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="breadcrumb-item active">${product.name}</li>
			</ol>
		</div>
	</div>
	
	
	<div class="row">
	
		<!-- display product image -->
		<div class="col-xs-12 col-sm-4">
		 	<div class="thumbnail">
		 		<img src="${images}/${product.code}.jpg" class="img img-responsive"/>  
		 	</div>
		</div>
		
		
		<!-- display product description-->
		<div class="col-xs-12 col-sm-4">
			<h3>${product.name}</h3>
			<hr/>
			<p>${product.description}</p>
			<hr/>
			<h4>Price : <strong>&#8377;  ${product.unitPrice} /-</strong></h4>
			<hr/>
			<h6>Qty. available : ${product.quantity}</h6>
			
			<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Add to Cart</a>
			<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
			<p>${product.description}</p>
			
			
		
		
		</div> 
		
		
	</div>


</div>