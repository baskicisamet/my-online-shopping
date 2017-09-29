package com.sam.myonlineshoppingbackend.dao;

import com.sam.myonlineshoppingbackend.dto.Address;
import com.sam.myonlineshoppingbackend.dto.Cart;
import com.sam.myonlineshoppingbackend.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	boolean addAdres(Address address);
	boolean addCart(Cart cart);

}
