package com.sam.myonlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting","wellcome to spring web mvc");
		
		return mv;
	}
	
	
	@RequestMapping(value= {"/test"})
	public ModelAndView test(@RequestParam(value="greeting",required=false) String greetingMessage) {
		
		if(greetingMessage == null) {
			greetingMessage = "yoo yoo guys";
		}
		
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("greetingMessage",greetingMessage);
		
		return modelAndView;
	}
	

}
