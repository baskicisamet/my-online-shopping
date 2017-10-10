package com.sam.myonlineshoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sam.myonlineshoppingbackend.dao.UserDAO;
import com.sam.myonlineshoppingbackend.dto.Address;
import com.sam.myonlineshoppingbackend.dto.Cart;
import com.sam.myonlineshoppingbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory SessionFactory;
	
	@Override
	public boolean addUser(User user) {
		
		try {
			SessionFactory.getCurrentSession().persist(user);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean addAdres(Address address) {
		
		try {
			SessionFactory.getCurrentSession().persist(address);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	

	@Override
	public User getByEmail(String email) {
		
		String query = "FROM User WHERE email = :email";
		
		try {
			
			return (User) SessionFactory.getCurrentSession()
					.createQuery(query,User.class)
					.setParameter("email", email)
					.getSingleResult();
			
		}catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public Address getBillingAddress(User user) {
		
		String query = "FROM Address WHERE user =:user AND billing = :billing";
		
		try {
			
			return (Address) SessionFactory.getCurrentSession()
					.createQuery(query,Address.class)
					.setParameter("user",user)
					.setParameter("billing",true)
					.getSingleResult();
			 
			
		}catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public List<Address> listShippingAddresses(User user) {
				
		String query = "FROM Address WHERE user =:user AND shipping = :shipping";
				
				try {
					
					return  (List<Address>) SessionFactory.getCurrentSession()
							.createQuery(query,Address.class)
							.setParameter("user",user)
							.setParameter("shipping",true)
							.getResultList();
					 
					
				}catch (Exception ex) {
					ex.printStackTrace();
					return null;
				}
			}

}
