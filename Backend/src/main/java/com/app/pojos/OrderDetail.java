package com.app.pojos;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "order_details")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Column(length = 50)
	private String orderDesc;
	@Column(length = 30)
	private String orderAddress;
	private double orderPrice;
	private int orderQty;
	@OneToOne
	@JoinColumn(name = "o_id",nullable = false)
	@JsonIgnoreProperties("orderdetails")
	private Order order;
	
	public OrderDetail() {
		System.out.println("in order details constructor ");
	}

	public OrderDetail(String orderDesc, String orderAddress, double orderPrice, int orderQty) {
		super();
		this.orderDesc = orderDesc;
		this.orderAddress = orderAddress;
		this.orderPrice = orderPrice;
		this.orderQty = orderQty;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderDetail [Id=" + Id + ", orderDesc=" + orderDesc + ", orderAddress=" + orderAddress + ", orderPrice="
				+ orderPrice + ", orderQty=" + orderQty + "]";
	}

}
