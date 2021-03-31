package com.app.service;

import java.util.List;

import com.app.pojos.Order;
import com.app.pojos.OrderDetail;

public interface IOrderDetailsService {
	// add a method to return all available orders
	List<OrderDetail> getAllOrderDetails();

	// add a method to return order details if exits otherwise throw custom exception
	OrderDetail getOrderDetails(int oid);
	
	//add a method to save a order
	OrderDetail saveOrderDetails(OrderDetail o);
		
	//add a method to delete a order
	OrderDetail deleteOrderDetails(int oid);

}
