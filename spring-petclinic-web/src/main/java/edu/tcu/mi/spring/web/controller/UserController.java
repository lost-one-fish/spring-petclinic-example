package edu.tcu.mi.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.tcu.mi.spring.web.entity.User;
import edu.tcu.mi.spring.web.service.UserService;

@Controller
@SessionAttributes(types = User.class)
@RequestMapping("/User")
public class UserController extends GenericController<User> {
	@Autowired 
	private UserService service;
    @Autowired 
    private MessageSource messages;
	
	public UserController(){
        super.viewPath = "/user";
        super.routePath = "/User";
        super.title = "User";
	}

	@RequestMapping(value = {"",  "/", "/index/", "/index"}, method = RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("title", title);
		return viewPath + "/index";
	}
	

    @RequestMapping(value = {"/create/**"}, method = RequestMethod.GET)
	public String create(Model model) { 
    	User user = new User();
		model.addAttribute("isNew", true);
        model.addAttribute(user);
		model.addAttribute("title", title);
		return viewPath + "/createOrUpdate";
    }
    
    @RequestMapping(value = {"/create/**"}, method = RequestMethod.POST)
	public String create(User user, Model model, BindingResult result, SessionStatus status) {
		model.addAttribute("title", title);
    	UserDetails _user = service.loadUserByUsername(user.getUsername());
    	if(_user.getUsername() != null){
    		result.addError(new ObjectError("duplication", "Database has duplication email : " + _user.getUsername()));
    	}
		if(result.hasErrors()){
			model.addAttribute(user);
			return viewPath + "/createOrUpdate";
    	}else{
    		service.save(user);
    		status.setComplete();
    		return "redirect:" + routePath + "/index/";
    	}
	}  
    


    @RequestMapping(value = {"/update/{username}/**"}, method = RequestMethod.GET)
	public String update(@PathVariable("username") String username, Model model) { 
    	User user = (User) service.loadUserByUsername(username);
		model.addAttribute("isNew", false);
        model.addAttribute(user);
		model.addAttribute("title", title);
		return viewPath + "/createOrUpdate";
    }
    
    @RequestMapping(value = {"/update/**"}, method = RequestMethod.POST)
	public String update(User user, Model model, BindingResult result, SessionStatus status) {
		model.addAttribute("title", title);
		if(result.hasErrors()){
			model.addAttribute(user);
			return viewPath + "/createOrUpdate";
    	}else{
    		service.save(user);
    		status.setComplete();
    		return "redirect:" + routePath + "/index/";
    	}
	}  

	@RequestMapping(value = {"/login/**"}, method = RequestMethod.GET)
	public String login(Model model){
		model.addAttribute("title", title);
		return viewPath + "/login";
	}
	

	@RequestMapping(value = {"/login-error/**"}, method = RequestMethod.GET)
	public String loginError(Model model){    
		model.addAttribute("title", title);
		model.addAttribute("loginError", true);
		return viewPath + "/login";
	}


}
