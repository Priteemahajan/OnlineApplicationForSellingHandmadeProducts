package com.app.dto;

public class CartDTO {
	private Integer cartId;
	private double qauntity;
	private double totalAmount;
	private ProductDTO product;
	
	public CartDTO() {
		System.out.println("in constructor of "+getClass().getName());
	}

	public CartDTO(double qauntity, double totalAmount) {
		super();
		this.qauntity = qauntity;
		this.totalAmount = totalAmount;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public double getQauntity() {
		return qauntity;
	}

	public void setQauntity(double qauntity) {
		this.qauntity = qauntity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", qauntity=" + qauntity + ", totalAmount=" + totalAmount + "]";
	}

}
