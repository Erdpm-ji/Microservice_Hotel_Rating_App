package com.user.service.exceptions;

public class ResourcesNotFoundExceptions extends RuntimeException{
	
	public ResourcesNotFoundExceptions() {
		super("User Not Found in the Server ");
	}
	
	public ResourcesNotFoundExceptions(String msg) {
		super(msg);
	}
}
