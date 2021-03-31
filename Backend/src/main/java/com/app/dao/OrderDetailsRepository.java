package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.OrderDetail;

public interface OrderDetailsRepository extends JpaRepository<OrderDetail, Integer> {
	//add a method to get order details by id
	Optional<OrderDetail> findById(Integer id);

}
