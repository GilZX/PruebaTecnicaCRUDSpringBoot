package com.pruebatecnica.crud.CRUDCLIENTES.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ExceptionClass {

	
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
	    public ResponseEntity<MessageResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
	      
	        MessageResponse response = new MessageResponse(
	            HttpStatus.BAD_REQUEST, 
	            "Verifique los datos proporcionados", 
	            ex.getFieldError().getDefaultMessage(),
	            null
	        );
	        
	        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	    

	 }
	
}
