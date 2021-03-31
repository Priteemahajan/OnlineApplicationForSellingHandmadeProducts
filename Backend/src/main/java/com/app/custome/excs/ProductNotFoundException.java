package com.app.custome.excs;

@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException(String mesg) {
		super(mesg);
	}
}
