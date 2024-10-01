package com.vin.shopbe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.vin.shopbe.model.Cart;
import com.vin.shopbe.model.Product;
import com.vin.shopbe.model.User;
import com.vin.shopbe.repository.CartRepository;
import com.vin.shopbe.repository.ProductRepository;
import com.vin.shopbe.repository.UserRepository;
import com.vin.shopbe.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public Cart saveCart(Integer pid, Integer uid) {
		Product product = productRepository.findById(pid).orElse(null);

		User user = userRepository.findById(uid).orElse(null);

		Cart cartStatus = cartRepository.findByProductIdAndUserId(pid, uid);

		Cart cart = null;

		if (cartStatus == null) {
			cart = new Cart();
			cart.setProduct(product);
			cart.setUser(user);
			cart.setQuantity(1);
		} else {
			cart = cartStatus;
			cart.setQuantity(cart.getQuantity() + 1);
		}
		return cartRepository.save(cart);

	}

	@Override
	public void updateQuantity(String value, Integer cid) {

		Cart cart = cartRepository.findById(cid).orElse(null);

		if (cart != null) {
			if (value.equals("increase")) {
				cart.setQuantity(cart.getQuantity() + 1);
			
			} else {
				if (cart.getQuantity() > 1) {
					cart.setQuantity(cart.getQuantity() - 1);
				}
			}
		}

		cartRepository.save(cart);

	}

	@Override
	public List<Cart> getCartByUser(Integer uId) {
		// TODO Auto-generated method stub
		return cartRepository.findByUserId(uId);
	}

	@Override
	public void deleteCartItem(Integer cid) {
		cartRepository.deleteById(cid);
		
	}

}
