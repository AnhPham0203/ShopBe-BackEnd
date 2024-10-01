package com.vin.shopbe.service;

import java.util.List;

import com.vin.shopbe.model.Cart;

public interface CartService {

	Cart saveCart(Integer pid, Integer uid);

	void updateQuantity(String value, Integer cid);

	List<Cart> getCartByUser(Integer uId);

	void deleteCartItem(Integer cid);

}
