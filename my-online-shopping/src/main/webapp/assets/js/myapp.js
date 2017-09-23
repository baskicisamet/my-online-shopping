$(function(){ 
	
	//--------------------------------------
	// solving to active menu problem
	//--------------------------------------
	switch(menu){
	
		case 'About Us':
			$('#about').addClass('active');
		break;
		case 'Contact Us':
			$('#contact').addClass('active');
		break;
		case 'All Product':
			$('#listProducts').addClass('active');
		break;
		case 'Manage Products':
			$('#manageProducts').addClass('active');
		break;
		default:
			if(menu == 'home'){break;}
			$('#listProducts').addClass('active');
			$('#a_'+menu).addClass("active");
		break;
	
	}
	//---------------------------------------------------------------
	
	
	
	//--------------------------------------
	//Code for jquery table
	//--------------------------------------
	var $table = $('#productListTable');
	//execute the below code only where we have this table
	if($table.length){
		//console.log("inside the table");
		
		var jsonUrl = '';
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/products';
			
		}else{
			jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId + '/products';
		}
		
		
		$table.DataTable({
			lengthMenu : [ [ 3, 5, 10, -1 ],[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
				
			pageLength : 5,
			ajax:{
				url: jsonUrl,
				dataSrc: ''  
			},
			columns: [
				
				
				{
					data: 'code',
					mRender: function(data, type, row){
						
						 
						return '<img src = "'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
					}
				},
				{
					data: 'name'  //these names have to  be same as coming from json
				},
				{
					data: 'brand'
				},
				{
					data: 'unitPrice',
					mRender:function(data,type,row){
						return '&#8377; ' + data
					}
				},
				{
					data: 'quantity',
					mRender:function(data, type, row){
						
						if(data < 1){
							 return '<span style="color:red">Out of Stock!</span>';
						}
						
						return data; 
						
					}
				},
				{
					data: 'id',
					bSortable:false,
					mRender:function(data,type,row){
						
						var str = '';
						str += '<a href="' + window.contextRoot+ '/show/' + data + '/product" class="btn btn-primary"><i class="fa fa-opencart" aria-hidden="true"></i></a> &#160';
						
						if(row.quantity < 1){
							str += '<a href="javascript:void(0)" class="btn btn-success disabled"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>'; 
						}else{
							str += '<a href="' + window.contextRoot+ '/cart/add/' + data + '/product" class="btn btn-success"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>';  
							 
						}
						
						
						return str;
						
						
					}
				}
				
			]
			
		});
	}
	
	//-------------------------------------------------------------------------------------
	
	
	
	
	
	
	//dismissing the alert after 3 second 
	var $alert = $('.alert');

	if($alert.length){//if is available
		
		setTimeout(function(){
			$alert.fadeOut('slow');
		},3000)
		
	}
	
	//--------------------------------------
	
	
	
	
	
	//------------------
	//bootbox
	//------------------
	$('.switch input[type="checkbox"]').on('change',function(){
		
		
		var checkbox = $(this);
		var checked = checkbox.prop('checked');
		var dMsg = (checked)? 'You want to activate the product?':
							  'You want to deactivate the product?';
		var value = checkbox.prop('value'); //getting product id
		
		bootbox.confirm({
			size: 'medium',
			title: 'Product Actives & Deactivation',
			message: dMsg,
			callback: function(confirmed){
				
				if(confirmed){// if user ok for changing
					
					console.log(value);
					bootbox.alert({
						size: 'medium',
						title: 'information',
						message: 'you are going to perform operation on product' + value
					}); 
					
					
				}else{
					checkbox.prop('checked', !checked); // if user cancel operation,back previous station
				}
			}
		});
		
	});
	
	//--------------------------------------
	
	
	
	
	
	
	
	
	
	
	//--------------------------------------
	// data table for admin
	//--------------------------------------
	
	
	var $adminProductsTable = $('#adminProductsTable');
	//execute the below code only where we have this table
	if($adminProductsTable.length){
		//console.log("inside the table");
		
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
		
		
		
		$adminProductsTable.DataTable({
			lengthMenu : [ [ 10, 30, 50, -1 ],[ '10 Records', '30 Records', '50 Records', 'ALL' ] ], 
				
			pageLength : 30,
			ajax:{
				url: jsonUrl,
				dataSrc: ''  //empty because json object doesnt have any name
			},
			columns: [
				{
					data:'id'
				},
				{
					data: 'code',
					mRender: function(data, type, row){
						
						 
						return '<img src = "'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminDataTableImg"/>'; 
				}
				},
				{
					data: 'name'  //these names have to  be same as coming from json
				},
				{
					data: 'brand'
				},
				{
					data: 'quantity',
					mRender:function(data, type, row){
						
						if(data < 1){
							 return '<span style="color:red">Out of Stock!</span>';
						}
						
						return data; 
						
					}
				},
				{
					data: 'unitPrice',
					mRender:function(data,type,row){
						return '&#8377; ' + data
					}
				},
				{
					data: 'active',
					bSortable: false, 
					mRender: function(data,type,row){
						
						var str = '';
						
						str += '<label class="switch" >';
						
						if(data){
							str += '<input type="checkbox" checked="checked" value="'+row.id+'" />';
						}else{
							str += '<input type="checkbox"  value="'+row.id+'" />';
						}
	
						str += '<div class="slider"></div>';
						str += '</label>';
						
						return str;
					}
						
				},
				{
					data: 'id',
					bSortable: false,
					mRender: function(data, type, row){
						
						var str = '';
						
						str += '<a href="${contextRoot}/manage/'+data+'/product" class="btn btn-warning">';
						str += '<i class="fa fa-pencil" aria-hidden="true"></i></a>';
						
						return str;	 
						
					}
				}
				
			],
			initComplete: function(){ //we need  chackbox element id after all content render because checkbox id is creating by Datatable thats why we add this code init complate.
				
				var api = this.api(); //DataTable api
				api.$('.switch input[type="checkbox"]').on('change',function(){
					
					
					var checkbox = $(this);
					var checked = checkbox.prop('checked');
					var dMsg = (checked)? 'You want to activate the product?':
										  'You want to deactivate the product?';
					var value = checkbox.prop('value'); //getting product id
					
					bootbox.confirm({
						size: 'medium',
						title: 'Product Actives & Deactivation',
						message: dMsg,
						callback: function(confirmed){
							
							if(confirmed){// if user ok for changing
								
								console.log(value);
								bootbox.alert({
									size: 'medium',
									title: 'information',
									message: 'you are going to perform operation on product' + value
								}); 
								
								
							}else{
								checkbox.prop('checked', !checked); // if user cancel operation,back previous station
							}
						}
					});
					
				});
				
			}
			
		});
	} 
	
	//--------------------------------------
	
	
	
});