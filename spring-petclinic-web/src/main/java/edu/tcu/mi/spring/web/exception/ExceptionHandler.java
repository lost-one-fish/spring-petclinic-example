package edu.tcu.mi.spring.web.exception;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Throwables;

/**
 * General error handler for the application.
 */
@ControllerAdvice
class ExceptionHandler {

	public static Logger logger = Logger.getLogger(ExceptionHandler.class);
	/**
	 * Handle exceptions thrown by handlers.
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)	
	public ModelAndView exception(Exception exception, WebRequest request) {
		ModelAndView modelAndView = new ModelAndView("error/generic_error");
//		logger.info(exception.getMessage());
//		logger.info(exception.getLocalizedMessage());
		logger.info(exception.toString());
//		logger.info(request.getContextPath());
//		Iterator<String> iterator = request.getHeaderNames();
//		while(iterator.hasNext()){
//			String headerName = iterator.next();
//			logger.info("headerName : " + headerName);
//			for(String s : request.getHeaderValues(headerName))
//				logger.info("Values : " + s);
//		}
		
		modelAndView.addObject("exception", Throwables.getRootCause(exception) + "!!!!!");
		return modelAndView;
	}
}