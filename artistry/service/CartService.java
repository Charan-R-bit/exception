package com.artistry.service;

import java.util.List;

import com.artistry.entity.Cart;
import com.artistry.error.CartNotFoundException;
import com.artistry.error.RecordAlreadyExistsException;


public interface CartService 
{
	public Cart addCart(Cart Cart) throws RecordAlreadyExistsException;
	public Cart updateCart(Cart Cart) throws CartNotFoundException;
	public Cart cancelCart(int CartId) throws CartNotFoundException;
	public List<Cart> showAllCarts() throws CartNotFoundException;
	public Cart getCartById(int cartdId) throws CartNotFoundException;

}
