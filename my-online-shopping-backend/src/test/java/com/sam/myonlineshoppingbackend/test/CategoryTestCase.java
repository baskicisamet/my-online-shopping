package com.sam.myonlineshoppingbackend.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sam.myonlineshoppingbackend.dao.CategoryDAO;
import com.sam.myonlineshoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.sam.myonlineshoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}

//	 @Test
//	 public void testAddCategory() {
//	 category = new Category();
//	
//	 category.setName("Laptop");
//	 category.setDescription("this is some decription for Laptop ");
//	 category.setImageURL("CAT_3.png");
//	
//	 assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
//	
//	
//	 }

	// @Test
	// public void testGetCategory() {
	//
	// category = categoryDAO.get(1);
	// assertEquals("Successfully feched a single
	// category","Television",category.getName());
	// }

//	@Test
//	public void testUpdateCategory() {
//		
//		
//		category = categoryDAO.get(1);
//		category.setName("TV");
//		
//		assertEquals("Successfully updated a  single category", true, categoryDAO.update(category));
//	}
//	
	
//	@Test
//	public void testDeleteCategory() {
//		
//		
//		category = categoryDAO.get(1);
//		
//		assertEquals("Successfully deleted  a  single category", true, categoryDAO.delete(category));
//	}
	
	
//	@Test
//	public void testListCategory() {
//		
//		
//		List<Category> categories = categoryDAO.list();
//		
//		assertEquals("Successfully fetched   all active categories list", 2, categoryDAO.list().size());
//		
//	}
	
	
	@Test
	public void testCRUDCategory() {
		
		 //add operation
		 category = new Category();
		
		 category.setName("Laptop");
		 category.setDescription("this is some decription for Laptop ");
		 category.setImageURL("CAT_3.png");
		
		 assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		 
		 
		 
		 category = new Category();
			
		 category.setName("Television");
		 category.setDescription("this is some decription for Television ");
		 category.setImageURL("CAT_3.png");
		
		 assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
	
		 
		 //fetching and updating category
			category = categoryDAO.get(2);
			category.setName("TV");
			
			assertEquals("Successfully updated a  single category", true, categoryDAO.update(category));
			
			
			
		//delete the catagory
		assertEquals("Successfully deleted  a  single category", true, categoryDAO.delete(category));
		
		//fetching the list
		assertEquals("Successfully fetched   all active categories list", 1, categoryDAO.list().size());
			
		
	}
	
	

}
