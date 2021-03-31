package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Cart;

public interface ICartService {
	
	 // add a method to return all available carts 
	List<Cart> getAllCartItems();
	 
	 //add a method to return cart by id 
	Optional<Cart> getCartByCartId(int cid);
	 
	 // add a method to save new cart details 
	Cart addCartDetails(Cart c);
	 
	 // add a method to update cart details
	Cart updateCartDetails(int cid, Cart c);
	 
	 //add a method to delete a cart 
	Cart deleteCartById(int cid);
	 
	 //add a method to delete all cart items
	void deleteAllCartItems();
	

}
