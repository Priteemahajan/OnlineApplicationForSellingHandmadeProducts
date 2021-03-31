package com.app.custome.excs;

@SuppressWarnings("serial")
public class CartNotFoundException extends RuntimeException {
	public CartNotFoundException(String mesg) {
		super(mesg);
	}
}
