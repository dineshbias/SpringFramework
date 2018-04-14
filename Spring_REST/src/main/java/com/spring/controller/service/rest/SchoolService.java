package com.spring.controller.service.rest;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dao.Util;
import com.spring.exception.ErrorResponse;
import com.spring.exception.Errorargumenttype;
import com.spring.exception.SchoolException;
import com.spring.model.xml.Kaksha;

@RestController
@RequestMapping("/school")
public class SchoolService {

	public SchoolService() {
		System.out.println(this.getClass() + " instantiated...");
	}

	@RequestMapping(value = "jsonHeader", method = RequestMethod.GET, produces = "application/json")
	public Kaksha getKakshaJsonHeader(@RequestHeader Map<String, String> headers) {
		System.out.println("getKakshaJsonHeader...");
		headers.forEach((key, value) -> System.out.println(key + ":" + value));

		return Util.getKaksha();
	}

	@RequestMapping(value = "json", method = RequestMethod.GET, produces = "application/json")
	public Kaksha getKakshaJson() {
		System.out.println("getKakshaJson...");
		return Util.getKaksha();
	}

	@RequestMapping(value = "xml", method = RequestMethod.GET, produces = "application/xml")
	public Kaksha getKakshaXml() {
		System.out.println("getKakshaXML...");
		return Util.getKaksha();
	}

	@RequestMapping(path = "/owners/{ownerId}/pets/{petId}", method = RequestMethod.GET, produces = "application/xml")
	public Kaksha getKakshaXml2(@PathVariable String ownerId, @PathVariable String petId) {
		System.out.println("getKakshaXML... " + ownerId + " " + petId);
		return Util.getKaksha();
	}
	
		
	@RequestMapping(value = "errorXML", method = RequestMethod.GET, produces = "application/xml")
	public Kaksha testErrorXML(@RequestParam(value = "name", required = false) String name) throws SchoolException {
		System.out.println("testErrorXML...");
		System.out.println("testErrorXML..." + name.toString());
		throw new SchoolException("Invalid employee name requested");
	}

	@RequestMapping(value = "errorJSON", method = RequestMethod.GET, produces = "application/json")
	public Kaksha testErrorJSON(@RequestParam(value = "name", required = false) String name) throws SchoolException {
		System.out.println("testErrorJSON...");
		System.out.println("testErrorJSON..." + name.toString());
		throw new SchoolException("Invalid school name requested");
	}

	@ExceptionHandler(SchoolException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		System.out.println("exceptionHandler......");
		ErrorResponse error = new ErrorResponse();
		error.setErrorcode("TRANSACTION_NOT_COMPLETED");
		Errorargumenttype type = new Errorargumenttype();
		type.setName(ex.getMessage());
		type.setValue(ex.getLocalizedMessage());
		error.getArguments().add(type);
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
