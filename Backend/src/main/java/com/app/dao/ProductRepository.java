package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	//get product details by supplied state
	List<Product> findByProductState(String state);
}
