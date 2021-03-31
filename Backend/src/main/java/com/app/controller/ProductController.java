package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ProductDTO;
import com.app.dto.ResponseDTO;
import com.app.pojos.Product;
import com.app.service.IProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
	//dependencies: productService
	@Autowired
	private IProductService productService;
	
	public ProductController() {
		System.out.println("in product controller ");
	}
	
	//add REST request handling method to access all available products
	@GetMapping
	public ResponseEntity<?> getAllProducts()
	{
		System.out.println("in get all products ");
		return ResponseEntity.ok(new ResponseDTO<>(productService.getAllProducts()));
	}

	//add REST request handling method to show product details by a specific state
	@GetMapping("/{productId}")
	public ResponseEntity<?> getProductById(@PathVariable int productId)
	{
		System.out.println("in get product details by id "+productId);
		return ResponseEntity.ok(new ResponseDTO<>(productService.getProductDetails(productId)));
	}
	
	//add REST request handling method to show product details by a specific state
	@GetMapping("/state/{productState}")
	public ResponseEntity<?> getProductByState(@PathVariable String productState)
	{
		System.out.println("in get user details by state "+productState);
		List<Product> productDetails = productService.getProductDetails(productState);
		System.out.println("Preduct details"+productDetails);
		return ResponseEntity.ok(new ResponseDTO<>(productDetails));
	}
			
	//add REST request handling to add Product details(=> creating a new resource) : POST
	//json representation of Product details ---> Java object (de serailization / un marshalling)
	@PostMapping
	public ResponseEntity<?> addNewProduct(@RequestBody Product productDetails)
	{
		System.out.println("in add new product "+productDetails);
		try {
			return new ResponseEntity<>(productService.saveProductDetails(productDetails),HttpStatus.CREATED);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
			
	//add REST request handling to update product details(=> update) : PUT
	//typically front end sends a resource id ( product id) : as a URI variable
	@PutMapping("/{productId}")
	public ResponseEntity<?> updateProductDetails(@PathVariable int productId,@RequestBody ProductDTO details)
	{
		System.out.println("in update product "+productId+" "+details);
		try {
			return new ResponseEntity<>(productService.updateProductDetails(productId, details),HttpStatus.CREATED);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	//add REST request handling method for product deletion
	@DeleteMapping("/{productId}")
	public ResponseEntity<?> deleteProductDetails(@PathVariable int productId)
	{
		System.out.println("in delete product "+productId);
		try {
			return new ResponseEntity<>(productService.deleteProductDetails(productId),HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}			
	}

}
