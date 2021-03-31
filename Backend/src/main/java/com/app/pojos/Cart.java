package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;
	@Column(nullable = false)
	private double qauntity;
	@Column(nullable = false)
	private double totalAmount;
	@ManyToOne
	@JoinColumn(name = "p_id",nullable = false)
	@JsonIgnoreProperties("cart")
	private Product product;
	
	public Cart() {
		System.out.println("in constructor of "+getClass().getName());
	}

	public Cart(double qauntity, double totalAmount) {
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", qauntity=" + qauntity + ", totalAmount=" + totalAmount + "]";
	}

}

