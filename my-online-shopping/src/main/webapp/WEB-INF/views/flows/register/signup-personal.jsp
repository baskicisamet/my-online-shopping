<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>

<div class="container">



	<div class="row justify-content-md-center">



		<div class=" col-md-12 ">
			<div class="card card-primary">
				<div class="card-header">
					<h4>Sign Up - personal</h4>
				</div>
				<div class="card-block">

					<div class="container " style="margin-top: 10px">

						<!-- FORM ELEMENTS -->
						<sf:form
							class="form-horizontal col-md-12 justify-content-md-center"
							method="POST"
							id="registerForm"
							modelAttribute="user"
							>


							<div class="form-group row col-md-offset-2 ">

								<label class="col-form-label col-md-3" for="firstName">First Name : </label>

								<div class="col-md-9">
									<sf:input type="text" path="firstName" id="firstName"
										placeholder="First Name" class="form-control" />
									<sf:errors path="firstName" cssClass="help-block" element="em" />
								</div>
							</div>





							<div class="form-group row col-md-offset-2">

								<label class="col-form-label col-md-3" for="lastName">Last Name : </label>

								<div class="col-md-9">
									<sf:input type="text" path="lastName" id="lastName"
										placeholder="Last Name" class="form-control" />
									<sf:errors path="lastName" cssClass="help-block" element="em" />
								</div>

							</div>
							
							
							<div class="form-group row col-md-offset-2">

								<label class="col-form-label col-md-3" for="email">Email : </label>

								<div class="col-md-9">
									<sf:input type="text" path="email" id="email"
										placeholder="email" class="form-control" />
									<sf:errors path="email" cssClass="help-block" element="em" />
								</div>

							</div>



							<div class="form-group row col-md-offset-2">

								<label class="col-form-label col-md-3" for="email">Contact Number : </label>

								<div class="col-md-9">
									<sf:input type="number" path="contactNumber" id="contactNumber"
										placeholder="contactNumber" class="form-control" />
									<sf:errors path="contactNumber" cssClass="help-block" element="em" />
								</div>

							</div>
							
							
							
							<div class="form-group row col-md-offset-2">

								<label class="col-form-label col-md-3" for="role">Select Role : </label>

								<div class="col-md-9">
									<label class="radio-inline">
										<sf:radiobutton path="role" value="USER" checked="checked"/> User
									</label>
									<label class="radio-inline">
										<sf:radiobutton path="role" value="SUPPLIER" /> Supplier
									</label>
								</div>

							</div>
							
							
							
							<div class="form-group row col-md-offset-2">

								<label class="col-form-label col-md-3" for="password">Password : </label>

								<div class="col-md-9">
									<sf:input type="password" path="password" id="password" 
										placeholder="password" class="form-control" />
									<sf:errors path="password" cssClass="help-block" element="em" />
								</div>

							</div>
							
							
							<div class="form-group row col-md-offset-2">

								<label class="col-form-label col-md-3" for="confirmPassword"> Confirm Password : </label>

								<div class="col-md-9">
									<sf:input type="confirmPassword" path="confirmPassword" id="confirmPassword" 
										placeholder="confirmPassword" class="form-control" />
									<sf:errors path="confirmPassword" cssClass="help-block" element="em" />
								</div>

							</div>
							



							

							
							


							


							<div class="form-group row ">

								<div class="col-md-5 col-md-offset-5">
									<button type="submit" name="_eventId_billing" id="submit" placeholder="Submit" class="btn btn-primary ">
									
										Next - Billing <i class="fa fa-chevron-right" aria-hidden="true"></i>
									</button>
								</div>
							</div>





						</sf:form>


					</div>
				</div>
			</div>
		</div>
	</div>






</div>




<%@include file="../shared/flows-header.jsp"%>
