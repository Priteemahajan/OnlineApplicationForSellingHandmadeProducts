package com.app.custome.excs;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String mesg) {
		super(mesg);
	}
}
