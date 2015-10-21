package edu.tcu.mi.spring.web.controller;

import edu.tcu.mi.spring.web.controller.rest.GenericRestController;


public abstract class GenericController<T> extends GenericRestController<T> {
	protected String routePath = "";
	protected String viewPath = "/";
	
	protected String title = "";



}
