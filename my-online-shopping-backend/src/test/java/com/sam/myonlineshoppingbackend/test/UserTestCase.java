package com.sam.myonlineshoppingbackend.test;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sam.myonlineshoppingbackend.dao.UserDAO;
import com.sam.myonlineshoppingbackend.dto.Address;
import com.sam.myonlineshoppingbackend.dto.Cart;
import com.sam.myonlineshoppingbackend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user;
	private Cart cart;
	private Address address;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.sam.myonlineshoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO)context.getBean("userDAO");
		
	}
	
	
//	@Test
//	public void testAdd() {
//		
//		user = new User();
//		user.setFirstName("sam");
//		user.setLastName("bas");
//		user.setEmail("sam@gmail.com");
//		user.setContactNumber("5555555555");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		//add the user
//		
//		assertEquals("Failed to add user!", true, userDAO.addUser(user));
//		
//		address = new Address();
//		address .setAddressLineOne("101/A ataturk evenue, sam bas");
//		address.setAddressLineTwo("sam sowfware");
//		address.setCity("Istanbul");
//		address.setState("besiktas");
//		address.setCountry("Turkey");
//		address.setPostalCode("34100");
//		address.setBilling(true);
//		
//		//link the user with the address using user id
//		address.setUserId(user.getId());
//		
//		//add the address
//		assertEquals("Failed to add address!", true, userDAO.addAdres(address));
//		
//		if(user.getRole().equals("USER")) {
//			
//			//create a cart for this
//			cart = new Cart();
//			cart.setUser(user);
//
//			//add the cart
//			assertEquals("Failed to add Cart!", true, userDAO.addCart(cart));
//			
//			//add a shipping address for this user
//			address = new Address();
//			address .setAddressLineOne("101/A ataturk evenue, sam bas");
//			address.setAddressLineTwo("sam sowfware");
//			address.setCity("Istanbul");
//			address.setState("besiktas");
//			address.setCountry("Turkey");
//			address.setPostalCode("34100");
//			address.setShipping(true);
//			
//			//link it with user
//			address.setUserId(user.getId());
//			//add the shipping address
//			assertEquals("Failed to add shipping address!", true, userDAO.addAdres(address)); 
//			
//		}
//		
//		
//	}
	
	
	
	
//	@Test
//	public void testAdd() {
//		
//		user = new User();
//		user.setFirstName("sam");
//		user.setLastName("bas");
//		user.setEmail("sam@gmail.com");
//		user.setContactNumber("5555555555");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		
//
//		if(user.getRole().equals("USER")) {
//			
//			//create a cart for this
//			cart = new Cart();
//			cart.setUser(user); 
//			
//			//attach cart with the user
//			user.setCart(cart);
//			
//		}
//		
//		//add the user
//		
//		assertEquals("Failed to add user!", true, userDAO.addUser(user));
//
//	}
//	
	
	
	
	
//	
//	@Test
//	public void testUpdateCart() {
//		
//		//fetch the user by its email
//		user = userDAO.getByEmail("sam@gmail.com");
//		
//		//get the cart of the user
//		cart = user.getCart();
//		
//		cart.setGrandTotal(5555);
//		cart.setCartLines(2);
//		
//		assertEquals("Fail to update the cart", true, userDAO.updateCart(cart)); 
//		
//	}
	
	
	
	
	
	
//	@Test
//	public void testAddAddress(){
//		
//		//we need to add an user
//		user = new User();
//		user.setFirstName("sam");
//		user.setLastName("bas");
//		user.setEmail("sam@gmail.com");
//		user.setContactNumber("5555555555");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		//add the user
//		assertEquals("Failed to add user!", true, userDAO.addUser(user));
//		
//		
//		
//	
//		
//		//we are going to the address 
//		
//		address = new Address();
//		address .setAddressLineOne("101/A ataturk evenue, sam bas");
//		address.setAddressLineTwo("sam sowfware");
//		address.setCity("Istanbul");
//		address.setState("besiktas");
//		address.setCountry("Turkey");
//		address.setPostalCode("34100");
//		address.setBilling(true);
//		
//		// attached the user to the address
//		address.setUser(user);
//		
//		assertEquals("Fail to add address!",true, userDAO.addAdres(address));
//		
//		
//		//we are also going to add shipping address
//		address = new Address();
//		address .setAddressLineOne("101/A ataturk evenue, sam bas");
//		address.setAddressLineTwo("sam sowfware");
//		address.setCity("Istanbul");
//		address.setState("besiktas");
//		address.setCountry("Turkey");
//		address.setPostalCode("34100");
//		address.setShipping(true); 
//		
//		// attached the user to the address
//		address.setUser(user);
//		
//		assertEquals("Fail to add shipping address!",true, userDAO.addAdres(address));
//		
//	}
	
	
	
//	@Test
//	public void testAddAddress() {
//		
//		user = userDAO.getByEmail("sam@gmail.com");
//		
//		//we are also going to add shipping address
//		address = new Address();
//		address .setAddressLineOne("1001/A ataturk evenue, sam bas");
//		address.setAddressLineTwo("sam sowfware");
//		address.setCity("Eski Sehir");
//		address.setState("adalar");
//		address.setCountry("Turkey");
//		address.setPostalCode("34100");
//		address.setShipping(true); 
//		
//		// attached the user to the address
//		address.setUser(user);
//		
//		assertEquals("Fail to add shipping address!",true, userDAO.addAdres(address));
//		
//	}
//	
	
	
	@Test
	public void testGetAddresses() {
		
		user = userDAO.getByEmail("sam@gmail.com");
		
		
		assertEquals("Failed to fetch the List of address and size does not match!",2, userDAO.listShippingAddresses(user).size());
		
		assertEquals("Failed to fetch the billing List of address and size does not match!","Istanbul", userDAO.getBillingAddress(user).getCity());
		
	}
	
	
	

}
