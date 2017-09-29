package com.sam.myonlineshoppingbackend.dao;

import java.util.List;

import com.sam.myonlineshoppingbackend.dto.Address;
import com.sam.myonlineshoppingbackend.dto.Cart;
import com.sam.myonlineshoppingbackend.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	User getByEmail(String email);
	boolean addAdres(Address address);
	
	//alternative
	//	Address getBillingAddress(int userId);
	//	List<Address> listShippingAddresses(int userId);
	
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
	
	boolean updateCart(Cart cart);

}
