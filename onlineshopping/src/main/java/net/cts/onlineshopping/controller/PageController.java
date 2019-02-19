package net.cts.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.cts.shoppingbackend.dao.CategoryDAO;
import net.cts.shoppingbackend.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index() {
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Home");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	/*@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="greeting", required=false)String greeting){
		
		if(greeting==null) {
			greeting="hey there!";
		}
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
		
	}*/
	
	//TEST
	/*@RequestMapping(value="/test/{greeting}")
	public ModelAndView test(@PathVariable(value="greeting")String greeting){
		
		if(greeting==null) {
			greeting="hey there!";
		}
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
		
	}*/
	//END
	
	@RequestMapping(value={"/about"})
	public ModelAndView about() {
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value={"/contact"})
	public ModelAndView contact() {
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	/*
	 * Methods to load all the products & based on category
	 * */

	@RequestMapping(value={"/show/all/products"})
	public ModelAndView showAllProducts() {
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "All Products");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	

	@RequestMapping(value={"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable(value="id") int id) {
		
		ModelAndView mv=new ModelAndView("page");
		
		//CategoryDAO to fetch a single category
		Category category;
		category= categoryDAO.get(id);
		mv.addObject("title", category.getName());

		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		//passing single category
		mv.addObject("category",category);
		
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
}