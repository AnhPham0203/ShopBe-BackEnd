package com.vin.shopbe.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vin.shopbe.model.Cart;
import com.vin.shopbe.model.Product;
import com.vin.shopbe.model.User;
import com.vin.shopbe.service.CartService;
import com.vin.shopbe.service.UserService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	@Autowired
	private CartService cartService;

	@Autowired
	private UserService userService;
	@PostMapping("/save")
	public ResponseEntity<String> saveCart(@RequestBody Map<String, Object> requestData) {
		System.out.println("requestData ++" +requestData);
		String email= (String) requestData.get("email");
		User user = userService.getUserByEmail(email);
		Integer pid= (Integer) requestData.get("pid");

		Cart cart = cartService.saveCart(pid,user.getId());
		if (cart != null) {
			return ResponseEntity.ok("Sản phẩm đã được thêm vào giỏ hàng!");

		} else {
			return ResponseEntity.badRequest().body("Không thể lưu sản phẩm vào giỏ hàng. Vui lòng thử lại.");
		}

	}

	@PostMapping("/getCart")
	public List<Cart> getCartByUser(@RequestBody Map<String, String> payload) {
		System.out.println("IDDDDDDDDDDDĐ = " + payload.get("email"));
		User user = userService.getUserByEmail(payload.get("email"));
		List<Cart> carts = cartService.getCartByUser(user.getId());

		return carts;

	}

	@PostMapping("/updateQuantity")
	public void updateQuantity(@RequestBody Map<String, String> payload) {
		String value = payload.get("action");
		Integer cid = Integer.parseInt(payload.get("cid"));

		cartService.updateQuantity(value, cid);

	}

	@PostMapping("/deleteCartItem")
	public void deleteCartItem(@RequestParam Integer cid) {

		cartService.deleteCartItem(cid);

	}

}
