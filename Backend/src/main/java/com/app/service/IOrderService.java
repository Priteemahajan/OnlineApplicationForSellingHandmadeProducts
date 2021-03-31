package com.app.service;

import java.util.List;

import com.app.pojos.Order;

public interface IOrderService {
	// add a method to return all available orders
	List<Order> getAllOrders();

	// add a method to return order details if exits otherwise throw custom exception
	Order getOrderDetails(int oid);

	// add a method to save new order details
	Order saveOrderDetails(Order o);

	// add a method to update order details
	Order updateOrderDetails(int oid, Order o);

	//add a method to delete a order
	Order deleteOrderDetails(int oid);

}
