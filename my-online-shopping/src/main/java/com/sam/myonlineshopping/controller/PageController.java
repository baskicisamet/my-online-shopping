package com.sam.myonlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sam.myonlineshopping.exception.ProductNotFoundException;
import com.sam.myonlineshoppingbackend.dao.CategoryDAO;
import com.sam.myonlineshoppingbackend.dao.ProductDAO;
import com.sam.myonlineshoppingbackend.dto.Category;
import com.sam.myonlineshoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO CategoryDAO;
	
	@Autowired
	private ProductDAO ProductDAO;
	
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","home");
		
		logger.info("Inside PageConrroller index method - INFO");
		logger.debug("Inside PageConrroller index method - DEBUG");
		
		//get category backend project
		mv.addObject("categories",CategoryDAO.list());
		mv.addObject("userClickHome",true);
		
		
		return mv;
	}
	
	
	
	
	
	@RequestMapping(value = {"/about"})
	public ModelAndView about() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		
		
		return mv;
	}
	
	
	
	@RequestMapping(value = {"/contact"})
	public ModelAndView contact() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		
		
		return mv;
	}
	
	
//	Methods to load all the products and based ın category
	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView showAllProducts() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		mv.addObject("categories",CategoryDAO.list());
		
		mv.addObject("userClickAllProducts",true);
		
		
		return mv;
	}
	
	
	
	@RequestMapping(value = {"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {

		ModelAndView mv = new ModelAndView("page");
		
		//get Products for single category
		Category category = null;
		category = CategoryDAO.get(id);
		
		
		
		mv.addObject("title",category.getName());
		
		mv.addObject("categories",CategoryDAO.list());
		
		//passing single category
		mv.addObject("category",category);
		
		mv.addObject("userClickCategoryProducts",true);
		
		
		return mv;
	}
	
	
	
	//viewing a single product
	
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException {
		
		ModelAndView mv = new ModelAndView("page");
		
		
		Product product = ProductDAO.get(id); 
		
		if(product == null) {
			throw  new ProductNotFoundException();
		}
		// update the view count
		product.setViews(product.getViews() + 1);
		ProductDAO.update(product); 
		//----------------------------------------
		
		mv.addObject("title",product.getName());
		mv.addObject("product",product);
		
		mv.addObject("userClickShowProduct",true);
		return mv;
	}
	
	
	
	/* Having smilar mapping to our flow id */
	@RequestMapping(value = {"/register"})
	public ModelAndView register() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		
		
		
		return mv;
	}
	
	
	
	
	/*Login*/
	@RequestMapping(value = {"/login"})
	public ModelAndView login() {
		
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("title","Login");
		
		return mv;
	}
	
	
	
	

	@RequestMapping(value= {"/test"})
	public ModelAndView test(@RequestParam(value="greeting",required=false) String greetingMessage) {
		
		if(greetingMessage == null) {
			greetingMessage = "yoo yoo guys";
		}
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","home");
		mv.addObject("userClickHome",true);
		
	
		
		return mv;
	}

}
