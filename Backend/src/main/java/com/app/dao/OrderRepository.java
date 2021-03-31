package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	//add a method to get order details by id
	Optional<Order> findByOrderId(Integer id);
}
