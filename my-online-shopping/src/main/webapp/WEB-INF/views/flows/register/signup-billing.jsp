<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>

<div class="container">



	<div class="row justify-content-md-center">



		<div class=" col-md-12 ">
			<div class="card card-primary">
				<div class="card-header">
					<h4>Sign Up - Billing</h4>
				</div>
				<div class="card-block">

					<div class="container " style="margin-top: 10px">

						<!-- FORM ELEMENTS -->
						<sf:form
							class="form-horizontal col-md-12 justify-content-md-center"
							method="POST"
							id="registerForm"
							modelAttribute="billing"
							>


							<div class="form-group row col-md-offset-2 ">

								<label class="col-form-label col-md-3" for="addressLineOne">Address Line One : </label>

								<div class="col-md-9">
									<sf:input type="text" path="addressLineOne" id="addressLineOne"
										placeholder="Address" class="form-control" />
									<sf:errors path="addressLineOne" cssClass="help-block" element="em" />
								</div>
							</div>




							<div class="form-group row col-md-offset-2 ">

								<label class="col-form-label col-md-3" for="addressLineTwo">Address Line Two : </label>

								<div class="col-md-9">
									<sf:input type="text" path="addressLineTwo" id="addressLineTwo"
										placeholder="Address" class="form-control" />
									<sf:errors path="addressLineTwo" cssClass="help-block" element="em" />
								</div>
							</div>
							


							<div class="form-group row col-md-offset-2">

								<label class="col-form-label col-md-3" for="city">City : </label>

								<div class="col-md-9">
									<sf:input type="text" path="city" id="city"
										placeholder="city" class="form-control" />
									<sf:errors path="city" cssClass="help-block" element="em" />
								</div>

							</div>
							
							
							<div class="form-group row col-md-offset-2">

								<label class="col-form-label col-md-3" for="state">State : </label>

								<div class="col-md-9">
									<sf:input type="text" path="state" id="state"
										placeholder="state" class="form-control" />
									<sf:errors path="state" cssClass="help-block" element="em" />
								</div>

							</div>



							<div class="form-group row col-md-offset-2 ">

								<label class="col-form-label col-md-3" for="country">Country : </label>

								<div class="col-md-9">
									<sf:input type="text" path="country" id="country"
										placeholder="country" class="form-control" />
									<sf:errors path="country" cssClass="help-block" element="em" />
								</div>
							</div>
	
							

							<div class="form-group row col-md-offset-2">

								<label class="col-form-label col-md-3" for="postalCode">Postal Code : </label>

								<div class="col-md-9">
									<sf:input type="number" path="postalCode" id="postalCode"
										placeholder="postal code" class="form-control" />
									<sf:errors path="postalCode" cssClass="help-block" element="em" />
								</div>

							</div>
							
							
							
							
							
							



							

							
							


							


							<div class="form-group row ">

								<div class="col-md-5 col-md-offset-5">
									<!--  submit button for moving to the personal  -->
									<button type="submit" name="_eventId_personal" id="submit" placeholder="Submit" class="btn btn-primary ">
									
										<i class="fa fa-chevron-left " aria-hidden="true"></i>Previous - personal 
									</button>
									
									<!--  submit button for moving the confirm  -->
									<button type="submit" name="_eventId_confirm" id="submit" placeholder="Submit" class="btn btn-primary ">
									
										Next - Confirm <i class="fa fa-chevron-right" aria-hidden="true"></i>
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
