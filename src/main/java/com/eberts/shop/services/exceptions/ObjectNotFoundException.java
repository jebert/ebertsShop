package com.eberts.shop.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException (String msg) {
		super(msg);
	}

	public ObjectNotFoundException (String msg, Throwable Cause) {
		
	}

}