package com.sam.myonlineshopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sam.myonlineshoppingbackend.dao.CategoryDAO;
import com.sam.myonlineshoppingbackend.dao.ProductDAO;
import com.sam.myonlineshoppingbackend.dto.Category;
import com.sam.myonlineshoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	
	@Autowired
	private CategoryDAO CategoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	
	 @RequestMapping(value="/products", method=RequestMethod.GET)
	  public ModelAndView showManageProducts(@RequestParam(name="operation",required=false) String operation ) {
		 
		 ModelAndView mv = new ModelAndView("page");
		 
		 mv.addObject("userClickManageProducts", true);
		 mv.addObject("title","Manage Products");  
		 Product nProduct = new Product();
		 
		 nProduct.setSupplierId(1);
		 nProduct.setActive(true);
		 
		 mv.addObject("product",nProduct);
		 
		 
		  
		 if(operation != null) {
			 
			 if(operation.equals("product")){
				  mv.addObject("message","Product submitted Succesfully");
			 }
			 
		 }
		 
		 
		 return mv;
	 }
	 
	 
	 
	 //handling  product submisson
	 @RequestMapping(value="/products", method=RequestMethod.POST)
	 public String  handleProductSubmisson(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model) {
		 
		 //check if there any errors while form bind to model
		 if(results.hasErrors()) {
			 
			 model.addAttribute("userClickManageProducts",true);
			 model.addAttribute("title","Manage Products");
			 model.addAttribute("message","Valitation failed for Product submission");
			 
			 return "page"; //if you redirect url that error message is not going to get dislayed.
			 
		 }
		 
		 logger.info(mProduct.toString());
		 
		  //create a new product record
		 productDAO.add(mProduct);
		 
		 return "redirect:/manage/products?operation=product";
	 }
	 
	 
	 //returning category for all the request
	 @ModelAttribute("categories")
	 public List<Category> getCategories(){
		 return CategoryDAO.list();
	 }

}
