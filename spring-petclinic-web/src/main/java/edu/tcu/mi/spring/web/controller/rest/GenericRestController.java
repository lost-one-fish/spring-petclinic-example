package edu.tcu.mi.spring.web.controller.rest;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.google.gson.Gson;


public abstract class GenericRestController<T> {

	protected static Logger logger = Logger.getLogger(GenericRestController.class);

	protected HttpHeaders headers = new HttpHeaders();
	protected Gson gson = new Gson();
	
	public GenericRestController(){
		headers.add("Content-Type", "application/json; charset=utf-8");
	}
	
	protected Map<String, String> getErrorsInASaneFormat(final BindingResult result) {
		return new HashMap<String, String>() {
			{
				for (FieldError error : result.getFieldErrors()) {
					put(error.getField(), error.getDefaultMessage());
				}
			}
		};
	}
}
