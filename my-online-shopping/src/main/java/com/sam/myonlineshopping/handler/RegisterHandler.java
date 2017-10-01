package com.sam.myonlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sam.myonlineshopping.model.RegisterModel;
import com.sam.myonlineshoppingbackend.dao.UserDAO;
import com.sam.myonlineshoppingbackend.dto.Address;
import com.sam.myonlineshoppingbackend.dto.Cart;
import com.sam.myonlineshoppingbackend.dto.User;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	
	public RegisterModel init() {
		
		return new RegisterModel();
	}
	 
	
	public void addUser(RegisterModel registerModel,User user) {
		
		registerModel.setUser(user);
	}
	
	 
	
	public void addBilling(RegisterModel registerModel,Address billing) {
		
		registerModel.setBilling(billing);
	}
	
	
	public String saveAll(RegisterModel registerModel) {
		
		  String transitionValue = "success";
		  
		  //fetch the user
		  User user = registerModel.getUser();
		  
		  if(user.getRole().equals("USER")) {
			  Cart cart = new Cart();
			  cart.setUser(user);
			  user.setCart(cart);
		  }
		  
		  //save the user
		  userDAO.addUser(user);
		  
		  
		  //fetch the address
		  
		  Address billing = registerModel.getBilling();
		  billing.setUser(user);
		  billing.setBilling(true);
		  
		  //save the address
		  userDAO.addAdres(billing);
		  
		  
		  return transitionValue;
		  
		  
	}

}
