package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.custome.excs.CartNotFoundException;
import com.app.pojos.Cart;
import com.app.pojos.OrderDetail;
import com.app.service.IOrderDetailsService;
import com.app.service.IOrderService;

@RestController
@RequestMapping("/order_details")
public class OrderDetailsController {
	//dependencies: orderDetailsService
	@Autowired
	private IOrderDetailsService orderDetailService;
	
	//dependencies : orderService
	@Autowired
	private IOrderService orderService;
	
	public OrderDetailsController() {
		System.out.println("in order details controller ");
	}
	
	//add REST request handling method to access all available orders
	@GetMapping
	public ResponseEntity<?> getAllOrders()
	{
		System.out.println("in get all orders ");
		List<OrderDetail> orderDetails=orderDetailService.getAllOrderDetails();
		if(orderDetails.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(orderDetails,HttpStatus.OK);	
	}
	
	@GetMapping("/{Id}")
	public OrderDetail getOrderDetails(@PathVariable int Id)
	{
		System.out.println("in get order details by id ");
		return orderDetailService.getOrderDetails(Id);
	}
	
	//add REST request handling to add cart details(=> creating a new resource) : POST
	//json representation of cart details ---> Java object (de serailization / un marshalling)
	@PostMapping
	public ResponseEntity<?> addOrderDetails(@RequestBody OrderDetail Details){
		System.out.println("in add new order details "+Details);
		try {
			return new ResponseEntity<>(orderDetailService.saveOrderDetails(Details),HttpStatus.CREATED);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
			
		
	//add REST request handling method for order deletion
	@DeleteMapping("/{Id}")
	public ResponseEntity<?> deleteorderDetails(@PathVariable int Id)
	{
		System.out.println("in delete order details "+Id);
		try {
			return new ResponseEntity<>(orderDetailService.deleteOrderDetails(Id),HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}			
	}
	
}
