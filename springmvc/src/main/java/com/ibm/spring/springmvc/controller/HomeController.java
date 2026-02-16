package com.ibm.spring.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	/**
	* Handles requests made to the root of the site
	*
	* @return an {@link ModelAndView} object with the response to the client
	*/
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView mostrarHome() {
        return new ModelAndView("home", "message", "Hello IBMer !");
    }
    
//  @RequestMapping(value = "/about", method = RequestMethod.GET)
    @RequestMapping("/about")
    public String showSearch() {
        System.out.println("LOG: Navigation -> Loading About Page");
        return "about"; 
    }
    
//    @RequestMapping(path = "/", method = RequestMethod.GET)
//    public ModelAndView mostrarHome1() {
//        return new ModelAndView("about", "message", "Hello How are you !");
//    }
}
