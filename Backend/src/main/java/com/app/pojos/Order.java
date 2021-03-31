package com.app.pojos;

import java.time.LocalDate;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	@Column(length = 20)
	private String orderName;
	private LocalDate orderDate;
	@OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("order")
	@Fetch(FetchMode.JOIN)
	private OrderDetail orderdetails;
	
	public Order() {
		System.out.println("in order constructor ");
	}

	public Order(String orderName, LocalDate orderDate) {
		super();
		this.orderName = orderName;
		this.orderDate = orderDate;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public OrderDetail getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(OrderDetail orderdetails) {
		this.orderdetails = orderdetails;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", orderDate=" + orderDate + "]";
	}
	
	//helper methods to add n remove order details
	public void addOrderDetail(OrderDetail details)
	{
		orderdetails=details;
		details.setOrder(this);
	}
	
	public void removeOrderDetail(OrderDetail details)
	{
		orderdetails=null;
		details.setOrder(null);
	}
}
