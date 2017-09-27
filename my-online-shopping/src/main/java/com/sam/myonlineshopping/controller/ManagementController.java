package com.sam.myonlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sam.myonlineshopping.util.FileUploadUtility;
import com.sam.myonlineshopping.validator.ProductValidator;
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
	 
	 
	 
	 
	 
	 
	 
	 @RequestMapping(value="/{id}/product",method=RequestMethod.GET)
	 public ModelAndView showEditProduct(@PathVariable int id ) {
		 
		 ModelAndView mv = new ModelAndView("page");
		 
		 mv.addObject("userClickManageProducts", true);
		 mv.addObject("title","Manage Products");  
		 
		 //fetch  the product from db 
		 Product nProduct = productDAO.get(id);
		 
		 mv.addObject("product",nProduct);
		 
		 
		  
		
		 
		 
		 return mv;
	 }
	 
	 
	 
	 //handling  product submisson
	 @RequestMapping(value="/products", method=RequestMethod.POST)
	 public String  handleProductSubmisson(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model, HttpServletRequest request) {
		 
		 
		 
		 //handle image validation for new product
		 if(mProduct.getId() == 0) {
			 new ProductValidator().validate(mProduct, results);
		 }else {
			 if(!mProduct.getFile().getOriginalFilename().equals("")) { //it will work when select a new image for update 
				 new ProductValidator().validate(mProduct, results);
			 }
		 }
		
		 
		 //check if there any errors while form bind to model
		 if(results.hasErrors()) {
			 
			 model.addAttribute("userClickManageProducts",true);
			 model.addAttribute("title","Manage Products");
			 model.addAttribute("message","Valitation failed for Product submission");
			 
			 return "page"; //if you redirect url that error message is not going to get dislayed.
			 
		 }
		 
		 logger.info(mProduct.toString());
		 
		 //when id = 0 is new product so we will add it
		 if(mProduct.getId() == 0) {
			 //create a new product record
			 productDAO.add(mProduct);
		 }else {
			 //Update the product if id is not 0
			 productDAO.update(mProduct);
		 }
		 
		 
		 
		 
		  if(!mProduct.getFile().getOriginalFilename().equals("")) { //if there is a file
			  FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());//why we are passing request is to get real path && why we are passing code because we are going to set it as image name
		  }
		 
		 return "redirect:/manage/products?operation=product";
	 }
	 
	 
	 
	 
	 @RequestMapping(value="/product/{id}/activation",method=RequestMethod.POST)
	 @ResponseBody
	 public String handleProductActivation(@PathVariable("id") int id) { 
		 
		 Product product = productDAO.get(id);
		 boolean isActive = product.isActive();
		 //activating and deactiveted product
		 product.setActive(!product.isActive());
		 
		 productDAO.update(product);
		 
		 return (isActive)? 
				 "you have succesfully deactivated the product with id : "+ product.getId():
				 "you have succesfully activated the product with id :" + product.getId();
	 }
	 
	 
	 
	 //returning category for all the request
	 @ModelAttribute("categories")
	 public List<Category> getCategories(){
		 return CategoryDAO.list();
	 }

}
