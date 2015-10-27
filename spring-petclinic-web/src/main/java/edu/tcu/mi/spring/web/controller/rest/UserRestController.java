package edu.tcu.mi.spring.web.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Strings;

import edu.tcu.mi.spring.web.entity.User;
import edu.tcu.mi.spring.web.service.UserService;


@Controller
@RequestMapping("/api/User")
public class UserRestController extends GenericRestController<User> {

	@Autowired 
	private UserService service;
	
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> list(@RequestParam(value="role", required=false) String role){
		
		if(!Strings.isNullOrEmpty(role)){
			List<User> resources = service.findByRole(role);
			String body = gson.toJson(resources);
			return new ResponseEntity<>(body, HttpStatus.OK);
		}
		
		Iterable<User> resources = service.findAll();
		String body = gson.toJson(resources);
		return new ResponseEntity<>(body, HttpStatus.OK);
	}	
	
	@RequestMapping(value = {"/{id}/**"}, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> read(@PathVariable("id") String id){
		User resource = service.findOne(id);
		String body = gson.toJson(resource);
		return new ResponseEntity<>(body, HttpStatus.OK);
	}
	
}
