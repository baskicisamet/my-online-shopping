package com.sam.myonlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public RegisterModel init() {
		
		return new RegisterModel();
	}
	 
	
	public void addUser(RegisterModel registerModel,User user) {
		
		registerModel.setUser(user);
	}
	
	 
	
	public void addBilling(RegisterModel registerModel,Address billing) {
		
		registerModel.setBilling(billing);
	}
	
	
	
	
	public String validateUser(User user, MessageContext error) {
		
		
		String transitioValue = "success";
		
		
		//checiking for confirm password
		
		if(!(user.getPassword().equals(user.getConfirmPassword()))){
			
			
			error.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("Password does not match the confirm password")
					.build());
			
			transitioValue = "failure";
			 
		}
		
		
		//check the uniquness of the email id
		if(userDAO.getByEmail(user.getEmail()) != null){
			
			error.addMessage(new MessageBuilder()
					.error()
					.source("email")
					.defaultText("Email address is already used!")
					.build());
			
			transitioValue = "failure";
			
		}
		 
		
		
		
		
		return transitioValue;
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
		  
		  
		  // encode the password
		  user.setPassword(passwordEncoder.encode(user.getPassword()));
		  
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
