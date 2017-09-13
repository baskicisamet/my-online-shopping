package com.sam.myonlineshoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sam.myonlineshoppingbackend.dao.ProductDAO;
import com.sam.myonlineshoppingbackend.dto.Product;

public class ProductTestCase {

		private static AnnotationConfigApplicationContext context;
		private static ProductDAO productDAO;
		private Product product;
		
		@BeforeClass
		public static void init() {
			context = new AnnotationConfigApplicationContext();
			context.scan("com.sam.myonlineshoppingbackend");
			context.refresh();
			productDAO = (ProductDAO) context.getBean("productDAO");
			
			
		}
//		
//		@Test
//		public void testCRUDProduct() {
//			
//			//Create Operation
//			product = new Product();
//			
//			product.setName("oppo selfie S53");
//			product.setBrand("Oppo");
//			product.setDescription("This is some description for oppo mobile phones.");
//			product.setUnitPrice(25000);
//			product.setActive(true);
//			product.setCategoryId(3);
//			product.setSupplierId(3);
//			
//			assertEquals("Someting went wrong while inserting a new product.",true,productDAO.add(product));
//			
//			
//			//reading and updating product
//			product = productDAO.get(2);
//			product.setName("Samsung Galaxy S7");
//			assertEquals("Somting went wrong while updating the existing record",true,productDAO.update(product));
//			
//			//delete
//			assertEquals("Somting went wrong while updating the existing record",true,productDAO.delete(product));
//			
//			//list
//			assertEquals("Somting went wrong while fetching the existing records",6,productDAO.list().size());
//			
//			
//			
//		}
		
		
//	@Test
//	public void testListActiveProducts() {
//		assertEquals("Somting went wrong while fetching the existing active records",5,productDAO.listActiveProducts().size());  
//	}
	
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Somting went wrong while fetching the existing active records by category",3,productDAO.listActiveProductsByCategory(3).size());  
	}
	
	@Test
	public void testGetLatestActiveProducts() {
		assertEquals("Somting went wrong while fetching latest active products",3,productDAO.getLatestActiveProducts(3).size());  
	}
		
		
		 
		
		
		
}
