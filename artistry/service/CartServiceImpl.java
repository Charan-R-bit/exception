package com.artistry.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artistry.dao.CartRepository;
import com.artistry.entity.Cart;
import com.artistry.error.CartNotFoundException;
import com.artistry.error.RecordAlreadyExistsException;

@Service("CartService")
@Transactional
public class CartServiceImpl implements CartService
{
	@Autowired
	CartRepository cartRepository;
	
	@Override
	public Cart addCart(Cart cart) throws RecordAlreadyExistsException{
		cartRepository.saveAndFlush(cart);
		return cart;
	}

	@Override
	public Cart updateCart(Cart cart) throws CartNotFoundException {
		Cart bean = null;
		try {
			bean = cartRepository.findById(cart.getCartId()).get();
		}
		catch(Exception e) {
			throw new CartNotFoundException("Cart details not found!");
		}
		cartRepository.saveAndFlush(cart);
		return cart;
	}

	@Override
	public Cart cancelCart(int CartId) throws CartNotFoundException {
		Cart bean = null;
		try {
			bean = cartRepository.findById(CartId).get();
		}
		catch(Exception e) {
			throw new CartNotFoundException("Cart details with given cart Id is not found!");
		}
		cartRepository.deleteById(CartId);
		return bean;
	}

	@Override
	public List<Cart> showAllCarts() {
		List<Cart> carts = new ArrayList<Cart>();
		try {
			carts = cartRepository.findAll();
			if(carts.size()==0) {
				throw new CartNotFoundException("Cart is empty");
			}
			else {
				return carts;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Cart getCartById(int cartId) throws CartNotFoundException{
		Cart bean = null;
		try {
			bean = cartRepository.findById(cartId).get();
		}
		catch(Exception e) {
			throw new CartNotFoundException("Cart details with given cart Id is not found!");
		}
		return bean;
	}

	
}
