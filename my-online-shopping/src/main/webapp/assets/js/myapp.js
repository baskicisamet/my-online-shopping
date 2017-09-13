$(function(){
	// solving to active menu problem
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
		default:
			if(menu == 'home'){break;}
			$('#listProducts').addClass('active');
			$('#a_'+menu).addClass("active");
		break;
	
	}
})