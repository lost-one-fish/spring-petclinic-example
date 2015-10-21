package edu.tcu.mi.spring.web.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/")
public class WelcomeController extends GenericController {
	
	public WelcomeController(){
        super.title = "Welcome";
	}
	
	
	@RequestMapping(value = {"",  "/", "/index/**"}, method = RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("title", title);
		model.addAttribute("serverTime", new Date());
		return "welcome/index";
	}
    
}
