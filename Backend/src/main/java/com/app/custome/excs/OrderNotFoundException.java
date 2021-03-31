package com.app.custome.excs;

@SuppressWarnings("serial")
public class OrderNotFoundException extends RuntimeException {
	public OrderNotFoundException(String mesg) {
		super(mesg);
	}
}
