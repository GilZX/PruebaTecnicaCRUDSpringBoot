package com.pruebatecnica.crud.CRUDCLIENTES.model;

import java.util.List;

import org.springframework.http.HttpStatus;

public class MessageResponse {

	
	private HttpStatus status;
	private String mensaje;
	private String errores;
	private Object response;
	
	
	public MessageResponse() {
		
	}


	public MessageResponse(HttpStatus status, String mensaje, String errores,Object response) {
		super();
		this.status = status;
		this.mensaje = mensaje;
		this.errores = errores;
		this.response=response;
	}


	public HttpStatus getStatus() {
		return status;
	}


	public void setStatus(HttpStatus status) {
		this.status = status;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public String getErrores() {
		return errores;
	}


	public void setErrores(String errores) {
		this.errores = errores;
	}


	public Object getResponse() {
		return response;
	}


	public void setResponse(Object response) {
		this.response = response;
	}
	
	
	
	
}
