package com.app.dto;

import java.util.ArrayList;
import java.util.List;



public class ProductDTO {
	private Integer productId;
	private String productName;
	private String description;
	private Double price;
	private String productState;
	private String imageurl;
	private List<CartDTO> cart = new ArrayList<CartDTO>();

	public ProductDTO() {
		System.out.println("in product constructor ");
	}

	public ProductDTO(String productName, String description, Double price, String productState,
			String imageurl) {
		super();
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.productState = productState;
		this.imageurl = imageurl;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getProductState() {
		return productState;
	}

	public void setProductState(String productState) {
		this.productState = productState;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public List<CartDTO> getCart() {
		return cart;
	}

	public void setCart(List<CartDTO> cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", description=" + description
				+", price=" + price + ", productState=" + productState + ", imageurl="
				+ imageurl + "]";
	}

}
