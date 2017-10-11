package com.sam.myonlineshoppingbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sam.myonlineshoppingbackend.dao.CartLineDAO;
import com.sam.myonlineshoppingbackend.dao.ProductDAO;
import com.sam.myonlineshoppingbackend.dao.UserDAO;
import com.sam.myonlineshoppingbackend.dto.Cart;
import com.sam.myonlineshoppingbackend.dto.CartLine;
import com.sam.myonlineshoppingbackend.dto.Product;
import com.sam.myonlineshoppingbackend.dto.User;

public class CartLineTestCase {
	

	private static AnnotationConfigApplicationContext context;

	private static CartLineDAO cartLineDAO;
	private static ProductDAO productDAO;
	private static UserDAO userDAO;
	
	private Product product = null;
	private User user = null;
	private Cart cart = null;
	private CartLine cartLine = null;
	
	

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.sam.myonlineshoppingbackend");
		context.refresh();
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");
		productDAO = (ProductDAO) context.getBean("productDAO");
		userDAO = (UserDAO) context.getBean("userDAO");

	}
	
	@Test
	public void testAddNewCartLine() {
		
		//1.get the user
		user = userDAO.getByEmail("user@gmail.com");
		
		//2. fetch the cart
		cart = user.getCart();
		
		// 3. get the product
		product = productDAO.get(1);
		
		// 4. create a new cartline 
		cartLine = new CartLine();
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		cartLine.setTotal(cartLine.getTotal() + product.getUnitPrice());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());;
		cartLine.setProduct(product);
		
		assertEquals("Failed to Add the cartLine",true,cartLineDAO.add(cartLine));
		
		//update the cart 
		cart.setGrandTotal(cartLine.getProductCount() * cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);
		
		assertEquals("Failed to update the cart ",true,cartLineDAO.updateCart(cart));
	}

}
