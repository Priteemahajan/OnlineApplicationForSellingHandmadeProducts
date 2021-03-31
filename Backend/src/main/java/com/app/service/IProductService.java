package com.app.service;

import java.util.List;

import com.app.dto.ProductDTO;
import com.app.pojos.Product;

public interface IProductService {
	// add a method to return all available products
	List<ProductDTO> getAllProducts();
	
	// add a method to return product details if exits otherwise throw custom exception
	ProductDTO getProductDetails(int pid);
	
	// add a method to return product details if exits otherwise throw custom exception
	List<Product> getProductDetails(String state);
	
	// add a method to save new product details
	ProductDTO saveProductDetails(Product p);

	// add a method to update product details
	ProductDTO updateProductDetails(int pid, ProductDTO p);

	//add a method to delete a product
	String deleteProductDetails(int pid);

	//add a method to get product count
	Long getProductsCount();
}
