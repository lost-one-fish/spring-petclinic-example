package edu.tcu.mi.spring.web.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;



@Controller
@RequestMapping("/EndPoints")
public class EndPointsController extends GenericController{
	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;
	
	public EndPointsController(){
		super.title = "EndPoints";
		super.viewPath = "endpoints";
	}
	
	@RequestMapping(value = {"",  "/", "/index/**"}, method = RequestMethod.GET)
	public String index(Model model){
		
		Set<RequestMappingInfo> apis = requestMappingHandlerMapping.getHandlerMethods().keySet();
		Predicate<RequestMappingInfo> predicate = new Predicate<RequestMappingInfo>() {
			@Override
			public boolean apply(RequestMappingInfo input) {
//				System.out.println(input.getPatternsCondition());
//				System.out.println(input.getMethodsCondition());
//				System.out.println(input.getParamsCondition());
//				System.out.println("========");
				return false;
			}
		};
		Iterables.removeIf(apis, predicate );
		model.addAttribute("title", title);
		model.addAttribute("apis", apis);
		return viewPath + "/index";
	}
	
}
