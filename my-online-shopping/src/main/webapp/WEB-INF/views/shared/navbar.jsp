
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="${contextRoot}/home">Online
			shopping</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
			
				<li class="nav-item" id="home">
					<a class="nav-link" href="${contextRoot}/home">Home <span class="sr-only">(current)</span></a>
				</li>
				
				<li class="nav-item" id="about">
					<a class="nav-link" href="${contextRoot }/about">About</a>
				</li>
				
				<li class="nav-item" id="contact">
					<a class="nav-link" href="${contextRoot}/contact">Contact</a>
				</li>
				
				<li id="listProducts"  class="nav-item">
					<a class="nav-link" href="${contextRoot}/show/all/products">View Product</a>
				</li>
				
				<li id="manageProduct"  class="nav-item">
					<a class="nav-link" href="${contextRoot}/manage/products">Manage Product</a>
				</li>
				
			</ul>
			
			
			
			
			<ul class="nav navbar-nav navbar-right">
			
				<li id="register"  class="nav-item">
					<a class="nav-link" href="${contextRoot}/register">Sign Up</a>
				</li>
				<li id="login"  class="nav-item">
					<a class="nav-link" href="${contextRoot}/login">Login</a>
				</li>
				
				
				<li class="dropdown">
					
					<a href="javascript:void(0)" class="btn  btn-default dropdown-toggle" id="dropwoenMenu1" data-toggle="dropdown">
						${userModel.fullName}
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="${contextRoot}/cart">
								<i class="fa fa-shopping-cart" aria-hidden="true"></i>
								<span class="badge">${userModel.cart.cartLines}</span>
								- &#8377; ${userModel.cart.grandTotal}
							</a>
						</li>
						<li class="divider" role="separator"></li>
						
						<li>
							<a href="${contextRoot}logout">Logout</a>
						</li>
					
					</ul>
					
				</li>
				
			</ul>
		</div>
	</div>
</nav>
