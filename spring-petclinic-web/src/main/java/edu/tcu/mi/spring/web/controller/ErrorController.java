package edu.tcu.mi.spring.web.controller;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Throwables;

@Controller
class ErrorController {

	public static Logger logger = Logger.getLogger(ErrorController.class);
	/**
	 * Display an error page, as defined in web.xml <code>custom-error</code> element.
	 */
	
	@RequestMapping(value = "/error/**", method = RequestMethod.GET)	
	public String generalError(HttpServletRequest request, HttpServletResponse response, Model model) {
		// retrieve some useful information from the request
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		// String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		String exceptionMessage = getExceptionMessage(throwable, statusCode);
		
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		if (requestUri == null) {
			requestUri = "Unknown";
		}
		
		String message = MessageFormat.format("{0} returned for {1} with message {2}", 
			statusCode, requestUri, exceptionMessage
		); 
		logger.debug(message);
		model.addAttribute("errorMessage", message);
        return "error/generic_error";
	}

	private String getExceptionMessage(Throwable throwable, Integer statusCode) {
		if (throwable != null) {
			return Throwables.getRootCause(throwable).getMessage();
		}
		logger.info("statusCode : " + statusCode);
		if(statusCode != null){
			HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
			return httpStatus.getReasonPhrase();
		} else {
			return "";
		}
	}
}
