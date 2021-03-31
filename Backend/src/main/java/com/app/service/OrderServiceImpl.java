package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custome.excs.OrderNotFoundException;
import com.app.dao.OrderRepository;
import com.app.pojos.Order;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
	//dependencies : orderDao
	@Autowired
	private OrderRepository orderRepo;

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}

	@Override
	public Order getOrderDetails(int oid) {
		// TODO Auto-generated method stub
		return orderRepo.findByOrderId(oid).orElseThrow(() -> new OrderNotFoundException("Invalid Order Id "+oid));
	}

	@Override
	public Order saveOrderDetails(Order o) {
		// TODO Auto-generated method stub
		return orderRepo.save(o);
	}

	@Override
	public Order updateOrderDetails(int oid, Order o) {
		// validate if product exists
		Optional<Order> optionalOrder=orderRepo.findById(oid);
		Order order=optionalOrder.orElseThrow(() -> new OrderNotFoundException("Invalid Order Id "+oid));
		return orderRepo.save(o);
	}

	@Override
	public Order deleteOrderDetails(int oid) {
		// validate if product exists
		Optional<Order> optionalOrder=orderRepo.findById(oid);
		Order order=optionalOrder.orElseThrow(() -> new OrderNotFoundException("Invalid Order Id "+oid));
		orderRepo.deleteById(oid);
		return order;
	}

}
