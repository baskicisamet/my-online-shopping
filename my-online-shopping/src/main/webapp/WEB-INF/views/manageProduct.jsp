<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container">

	<div class="row justify-content-md-center" >
	
	
		<c:if test="${not empty message}">
		
			<div class="row col-lg-12 justify-content-md-center ">
				<div class="col-xs-12 col-lg-10">
					
					<div class="alert alert-success alert-dismissible">
					
					 	<button type="button" class="close" data-dismiss="alert">&times;</button>
					 	
					 	${message}
					
					</div>
				</div> 
			</div>
		</c:if>
	
		<div class=" col-md-12 ">
			<div class="card card-primary">
				<div class="card-header">
					<h4>Product Management</h4>
				</div>
				<div class="card-block">
					
					<div class="container " style="margin-top:10px">
					
					<!-- FORM ELEMENTS -->
					<sf:form class="form-horizontal col-md-12 justify-content-md-center" modelAttribute="product" action="${contextRoot}/manage/products" method="POST" enctype="multipart/form-data">
					
					
						<div class="form-group row col-md-offset-2 ">
						
							<label class="col-form-label col-md-3" for="name">Enter Product Name : </label>
							
							<div class="col-md-9">
								<sf:input type="text" path="name" id="name" placeholder="Product Name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em"  />						
							</div>
							
						</div>
						
						
					
					
					
						<div class="form-group row col-md-offset-2">
						
							<label class="col-form-label col-md-3" for="brand">Enter Brand Name : </label>
							
							<div class="col-md-9">
								<sf:input type="text" path="brand" id="brand" placeholder="Brand Name" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em"  />
							</div>
							
						</div>
						
						
						<div class="form-group row col-md-offset-2">
						
							<label class="col-form-label col-md-3" for="description">Product Description : </label>
							
							<div class="col-md-9">
								<sf:textarea path="description" id="description" placeholder="Write a description" class="form-control" />
								<sf:errors path="description" cssClass="help-block" element="em"  />
							</div>
							
						</div>
						
						
						<div class="form-group row col-md-offset-2">
						
							<label class="col-form-label col-md-3" for="unitPrice"> Enter Unit Price </label>
							
							<div class="col-md-9">
								<sf:input type="number" path="unitPrice" id="unitPrice" placeholder="Unit Price In &#8377;" class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em"  />
							</div>
							
						</div>
						
						<div class="form-group row col-md-offset-2">
						
							<label class="col-form-label col-md-3" for="quantity"> Quantity Available :  </label>
							
							<div class="col-md-9">
								<sf:input type="number" path="quantity" id="quantity" placeholder="Quantity Available" class="form-control" />
							</div>
							
						</div>
						<!-- File  element for image upload-->
						<div class="form-group row col-md-offset-2">
						
							<label class="col-form-label col-md-3" for="file"> Select and Image  </label>
							
							<div class="col-md-9">
								<sf:input type="file" path="file" id="file"  class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em"  />
							</div>
							
						</div>
						
						
						<div class="form-group row col-md-offset-2">
						
							<label class="col-form-label col-md-3" for="categoryId"> Select Category :  </label>
							
							<div class="col-md-9">
								<sf:select class="form-control" id="categoryId" path="categoryId" items="${categories}" itemLabel="name" itemValue="id">
								</sf:select>
								<c:if test="${ product.id == 0}">
									<div class="text-right">
									 	<br/>
										<button type="button" data-toggle="modal" data-target="#myCategoryModal" class="btn btn-warning btn-xs">Add Category</button>
										
										
									</div>
								</c:if>
							</div>
							
						</div>
						
				
						<div class="form-group row "> 
						 
							<p class="col-md-3"><p>
							
							<div class="col-md-5 col-md-offset-5">
								<input type="submit" name="submit" id="submit" placeholder="Submit" class="btn btn-primary " />
								<!--  hidden field for product  -->
								<sf:hidden path="id"/>
								<sf:hidden path="code"/>
								<sf:hidden path="supplierId"/>
								<sf:hidden path="active"/>
								<sf:hidden path="purchases"/>
								<sf:hidden path="views"/>
							</div>
						</div>
						
						
						
						
					
					</sf:form>
					
					
					
					
					
					
					
					</div>
					
					
					
					
					
				</div>
			</div>
		</div>
	</div>



	



	<div class="row" style="margin-top:30px">
	
		<div class="col-xs-12 col-lg-12">
			<h3>Available Products</h3>
			<hr/>
		
		</div>
		
		<div class="col-xs-12 col-lg-12">
		
			<div class="conteiner-fluid">
			
				<div class="table-responsive">
				
					<!--  Product Table for admin -->
				<table id="adminProductsTable" class="table table-condensed table-bordered">
							
				<thead>					
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>					
				</thead>
				
				
				
				<tfoot>
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>brand </th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>									
				</tfoot>
				
							
			</table>
				</div>
			</div>
			
				
			
			
		
		
		</div>
	
	
	</div>
	



	
	<!-- Modal for category add -->
	<div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
	
		<div class="modal-dialog" role="document">
		
			<div class="modal-content">
				
				<!-- Model Header -->
				<div class="modal-header">
					
					<h5 class="modal-title">Add new Category </h5>
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
				</div>
				
				<div class="modal-body">
					<!-- Category Form -->
					<sf:form id="categoryForm"  modelAttribute="category" action="${contextRoot}/manage/category" method="POST" class="form-horizontal">
					
						<div class="form-group row">
							<label for="category_name" class="control-label col-md-4">Category Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="category_name" class="form-control"/>
							</div>
						</div> 
						
						<div class="form-group row">
							<label for="category_description" class="control-label col-md-4">Category Name</label>
							<div class="col-md-8">
								<sf:textarea cols="" rows="5"  path="description" id="category_description" class="form-control"/>
							</div>
						</div> 
						
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" value="Add Category" class="btn btn-primary" />
							</div>
						</div>
					
					
					</sf:form>
					 
				</div>
				
			</div>
		
		</div>
	
	</div>  
	
	


</div>