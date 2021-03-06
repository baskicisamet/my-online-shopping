<%@include file="../shared/flows-header.jsp"%>

<div class="container">

	<div class="row justify-content-md-center">


		<!-- column to display the user -->
		<div class=" col-md-6 ">
			<div class="card card-primary">
				<div class="card-header">
					<h4>Sign Up - Personal</h4>
				</div>
				<div class="card-body">

					<div class="container " style="margin-top: 10px">

						<!-- Code to display the personal details -->
						<div class="text-center">
						
							<h4>${registerModel.user.firstName} ${registerModel.user.lastName}</h4>
							
							<h5>Email: ${registerModel.user.email}</h5>
						
							<h5>Contact Number: ${registerModel.user.contactNumber}</h5>
							
							<h5>Role : ${registerModel.user.role}</h5>
							
							
						</div>


					</div>
				</div>
				<div class="card-footer text-muted">
				    <!-- anchor to move to the edit of personal -->
				    <a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edit</a>
				</div>
			</div>
		</div>
		
		
		
		
		<!-- column to display the address -->
		<div class=" col-md-6 ">
			<div class="card card-primary">
				<div class="card-header">
					<h4>Sign Up - Address</h4>
				</div>
				<div class="card-body">

					<div class="container " style="margin-top: 10px">

						<!-- Code to display the address details -->
						
						<div class="text-center">
						
							<h4>${registerModel.billing.addressLineOne}</h4>
							<h4>${registerModel.billing.addressLineTwo}</h4>
							<h4>${registerModel.billing.city} - ${registerModel.billing.postalCode}</h4>
							<h4>${registerModel.billing.state} - ${registerModel.billing.country}</h4>
							

						</div>
						


					</div>
				</div>
				<div class="card-footer text-muted">
				    <!-- anchor to move to the edit of address -->
				    <a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Edit</a>
				</div>
			</div>
		</div>
		
	</div>
	
	<!-- the provide the confirm button after displaying the details -->
	<div class="row justify-content-center" style="margin-top:15px">
		<div class="col-md-4">
			<div class="text-center">
				<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-primary">Confirm</a>
			</div>
		</div>
	</div>
	
</div>




<%@include file="../shared/flows-header.jsp"%>
