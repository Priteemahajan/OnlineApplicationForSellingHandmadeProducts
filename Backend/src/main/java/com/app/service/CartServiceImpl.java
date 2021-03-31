package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custome.excs.CartNotFoundException;
import com.app.dao.CartRepository;
import com.app.pojos.Cart;

@Service
@Transactional
public class CartServiceImpl implements ICartService {
	//dependencies: cartDao
	@Autowired
	private CartRepository cartRepo;

	
	 @Override public List<Cart> getAllCartItems() {
		 // TODO Auto-generated methods
		 return cartRepo.findAll(); 
	}
	  
	 @Override public Cart addCartDetails(Cart c) {
	 c.setTotalAmount(c.getProduct().getPrice()*c.getQauntity()); 
	 return cartRepo.save(c); }
	  
	  
	 @Override public Optional<Cart> getCartByCartId(int cid) { 
		 // TODO Auto-generated method stub 
		 return cartRepo.findById(cid); 
	}
	  
	 @Override public Cart updateCartDetails(int cid, Cart c) { 
		 // validate if cart exists 
		 Optional<Cart> optionalCart=cartRepo.findById(cid); 
		 Cart cart=optionalCart.orElseThrow(() -> new CartNotFoundException("Invalid Product Id "+cid)); 
		 Cart c1=optionalCart.get(); c1.setQauntity(c.getQauntity());
		 c1.setTotalAmount(c.getQauntity()*c.getProduct().getPrice()); 
		 return cartRepo.save(c1); 
	}
	  
	 @Override public Cart deleteCartById(int cid) { // validate if cart exists
	 Optional<Cart> optionalCart=cartRepo.findById(cid); Cart
	 cart=optionalCart.orElseThrow(() -> new
	 CartNotFoundException("Invalid Product Id "+cid)); cartRepo.deleteById(cid);
	 return cart; }
	  
	 @Override public void deleteAllCartItems() { 
		 // TODO Auto-generated method stub 
		 cartRepo.deleteAll(); 
	}
	 
}
