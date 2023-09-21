package com.management.employee.exceptionhandler;

public class NameNotFoundException extends Exception {
	public NameNotFoundException(String name) {
		super(name);
	}

}
