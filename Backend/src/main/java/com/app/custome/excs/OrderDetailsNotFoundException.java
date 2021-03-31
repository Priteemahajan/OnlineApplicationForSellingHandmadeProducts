package com.app.custome.excs;

@SuppressWarnings("serial")
public class OrderDetailsNotFoundException extends RuntimeException {
	public OrderDetailsNotFoundException(String mesg) {
		super(mesg);
	}
}
