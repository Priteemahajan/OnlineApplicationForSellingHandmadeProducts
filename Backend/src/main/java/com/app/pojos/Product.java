package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	@NotBlank(message = "Product Name Can't Be Blank ")
	@Column(length = 20, nullable = false)
	private String productName;
	private String description;
	private Double price;
	@Column(length = 30)
	private String productState;
	@Column(length = 60)
	private String imageurl;
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("product")
	@Fetch(FetchMode.JOIN) 
	private List<Cart> cart = new ArrayList<Cart>();
	 

	public Product() {
		System.out.println("in product constructor ");
	}

	public Product(String productName, String description, Double price, String productState,
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

	
	public List<Cart> getCart() { 
		return cart; 
	}
	 
	public void setCart(List<Cart> cart) {
		this.cart = cart; 
	}
	

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", description=" + description
				+", price=" + price + ", productState=" + productState + ", imageurl="
				+ imageurl + "]";
	}

	// helper methods to add n remove cart
	
	public void addCart(Cart c) { 
		cart.add(c); 
		c.setProduct(this); 
	}
	
	public void removeCart(Cart c) { 
		cart.remove(c); 
		c.setProduct(null); 
	}
	

}
