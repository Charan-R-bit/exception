package com.artistry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.artistry.entity.Cart;
import com.artistry.error.CartNotFoundException;
import com.artistry.error.RecordAlreadyExistsException;
import com.artistry.service.CartService;


@Controller
@RequestMapping("/Art")

public class CartController 
{	
	@Autowired
	CartService cartService;
	
	@PostMapping("/addcart")
	public Cart addCart(@RequestBody Cart Cart) throws RecordAlreadyExistsException{
		return cartService .addCart(Cart);
	}
	
	@PutMapping("/updatecart")
	public Cart updateCart(@RequestBody Cart Cart) throws CartNotFoundException{
		return cartService .updateCart(Cart);
	}
	
	@DeleteMapping("/cancelcart/{CartId}")
	public Cart cancelCart(@PathVariable  int CartId) throws CartNotFoundException{
		return cartService .cancelCart(CartId);
		
	}
	
	@GetMapping("/getcart/all")
	public List<Cart> showAllCarts() throws CartNotFoundException{
		return cartService .showAllCarts();
	}
	
	@GetMapping("/getcartbyid/{cartdId}")
	public Cart getCartById(int cartdId) throws CartNotFoundException{
		return cartService.getCartById(cartdId) ;
	}

}
