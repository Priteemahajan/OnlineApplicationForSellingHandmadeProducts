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

import com.app.custome.excs.CartNotFoundException;
import com.app.pojos.Cart;
import com.app.service.ICartService;
import com.app.service.IProductService;

@RestController
@RequestMapping("/cart")
public class CartController {
	//dependencies : cartService
	@Autowired
	private ICartService cartService;
    
	@Autowired
	private IProductService prodService;
	
	public CartController() {
		System.out.println("in cart controller ");
	}
	
	//add REST request handling method to access all available carts
	@GetMapping
	public ResponseEntity<?> getAllCartItems()
	{
		System.out.println("in get all carts ");
		List<Cart> carts=cartService.getAllCartItems();
		if(carts.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(carts,HttpStatus.OK);	
	}
	
	@GetMapping("/{cartId}")
	public Cart getCartItem(@PathVariable int cartId)
	{
		System.out.println("in get cart by id ");
		return cartService.getCartByCartId(cartId).orElseThrow(() -> new CartNotFoundException("Invalid Cart id "+cartId));
	}

	//add REST request handling to add cart details(=> creating a new resource) : POST
	//json representation of cart details ---> Java object (de serailization / un marshalling)
	@PostMapping
	public ResponseEntity<?> addCartDetails(@RequestBody Cart cartDetails){
		System.out.println("in add new cart "+cartDetails);
		try {
			return new ResponseEntity<>(cartService.addCartDetails(cartDetails),HttpStatus.CREATED);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
				
	//add REST request handling to update cart details(=> update) : PUT
	//typically front end sends a resource id (cart id) : as a URI variable
	@PutMapping("/{cartId}")
	public ResponseEntity<?> updateCartDetails(@PathVariable int cartId,@RequestBody Cart details)
	{
		System.out.println("in update product "+cartId+" "+details);
		try {
			return new ResponseEntity<>(cartService.updateCartDetails(cartId, details),HttpStatus.CREATED);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
			
	//add REST request handling method for cart deletion
	@DeleteMapping("/{cartId}")
	public ResponseEntity<?> removeCartItems(@PathVariable int cartId)
	{
		System.out.println("in delete cart "+cartId);
		try {
			return new ResponseEntity<>(cartService.deleteCartById(cartId),HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}			
	}
		
	//add REST request handling method for delete all cart items
	@DeleteMapping
	public ResponseEntity<?> deleteAllCartItems()
	{
		System.out.println("in delete all cart items ");
		try {
			cartService.deleteAllCartItems();
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
}
