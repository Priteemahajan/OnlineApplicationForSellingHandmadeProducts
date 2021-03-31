package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custome.excs.OrderDetailsNotFoundException;
import com.app.dao.OrderDetailsRepository;
import com.app.pojos.Order;
import com.app.pojos.OrderDetail;

@Service
@Transactional
public class OrderDetailsServiceImpl implements IOrderDetailsService {
	//dependencies : orderDetailsDao
	@Autowired
	private OrderDetailsRepository orderDetailsRepo;

	@Override
	public List<OrderDetail> getAllOrderDetails() {
		// TODO Auto-generated method stub
		return orderDetailsRepo.findAll();
	}

	@Override
	public OrderDetail getOrderDetails(int oid) {
		// TODO Auto-generated method stub
		return orderDetailsRepo.findById(oid).orElseThrow(() -> new OrderDetailsNotFoundException("Invalid Order Details Id "+oid));
	}
	
	

	@Override
	public OrderDetail saveOrderDetails(OrderDetail o) {
		// TODO Auto-generated method stub
		return orderDetailsRepo.save(o);
	}

	@Override
	public OrderDetail deleteOrderDetails(int oid) {
		// validate if product exists
		Optional<OrderDetail> optionalOrderDetail=orderDetailsRepo.findById(oid);
		OrderDetail orderDetail=optionalOrderDetail.orElseThrow(() -> new OrderDetailsNotFoundException("Invalid order Details Id "+oid));
		orderDetailsRepo.deleteById(oid);		
		return orderDetail;
	}

}
