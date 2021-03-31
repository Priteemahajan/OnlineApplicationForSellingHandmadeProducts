package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Order;
import com.app.service.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	//dependencies : orderService
	@Autowired
	private IOrderService orderService;
	
	public OrderController() {
		System.out.println("in order controller ");
	}
	
	//add REST request handling method to access all available orders
	@GetMapping
	public List<Order> getAllOrders()
	{
		System.out.println("in get all orders ");
		return orderService.getAllOrders();
	}

	//add REST request handling method to show order details by a specific id
	@GetMapping("/{orderId}")
	public Order getProductByOrderId(@PathVariable int orderId)
	{
		System.out.println("in get order details by order id "+orderId);
		return orderService.getOrderDetails(orderId);
	}
				
	//add REST request handling to add Order details(=> creating a new resource) : POST
	//json representation of Order details ---> Java object (de serailization / un marshalling)
	@PostMapping
	public ResponseEntity<?> addNewOrder(@RequestBody Order orderDetails)
	{
		System.out.println("in add new order "+orderDetails);
		try {
			return new ResponseEntity<>(orderService.saveOrderDetails(orderDetails),HttpStatus.CREATED);			
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
				
	//add REST request handling to update order details(=> update) : PUT
	//typically front end sends a resource id (order id) : as a URI variable
	@PutMapping("/{orderId}")
	public ResponseEntity<?> updateOrderDetails(@PathVariable int orderId,@RequestBody Order details)
	{
		System.out.println("in update order "+orderId+" "+details);
		try {
			return new ResponseEntity<>(orderService.updateOrderDetails(orderId, details),HttpStatus.CREATED);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	//add REST request handling method for order deletion
	@DeleteMapping("/{orderId}")
	public ResponseEntity<?> deleteOrderDetails(@PathVariable int orderId)
	{
		System.out.println("in delete order "+orderId);
		try {
			return new ResponseEntity<>(orderService.deleteOrderDetails(orderId),HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}			
	}

}
