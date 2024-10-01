package com.vin.shopbe.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vin.shopbe.model.Cart;
import com.vin.shopbe.model.Product;
import com.vin.shopbe.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	@Autowired
	private CartService cartService;

	@PostMapping("/save")
	public ResponseEntity<String> saveCart(@RequestBody Product product) {
		System.out.println("aloooooo" + product.getImage());
	Cart cart=	cartService.saveCart(product.getId(), 1);
	if(cart != null) {
		return ResponseEntity.ok("Sản phẩm đã được thêm vào giỏ hàng!");

	}else {
		return ResponseEntity.badRequest().body("Không thể lưu sản phẩm vào giỏ hàng. Vui lòng thử lại.");
	}
		
	}
	
	@GetMapping("/getCart")
	public List<Cart> getCartByUser() {
		List<Cart> carts= cartService.getCartByUser(1);
		
		return carts;
		
	}
	
	@PostMapping("/updateQuantity")
	public void updateQuantity(@RequestBody Map<String, String> payload) {
		String value= payload.get("action");
		Integer cid= Integer.parseInt(payload.get("cid"));
		
		cartService.updateQuantity(value,cid);
		
		
	}
	
	@PostMapping("/deleteCartItem")
	public void deleteCartItem(@RequestParam Integer cid ) {
		
		
		cartService.deleteCartItem(cid);
		
		
	}

}
