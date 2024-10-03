package com.vin.shopbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vin.shopbe.UserDTO;
import com.vin.shopbe.model.User;
import com.vin.shopbe.request.LoginRequest;
import com.vin.shopbe.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) {

		User user2 = userService.createUser(user);
		if (user2 != null) {
			return ResponseEntity.ok("Bạn đã đk thành công! Hãy tiến hành đăng nhập");
		}

		return ResponseEntity.badRequest().body("Not OK");
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
		System.out.println(loginRequest);

		Boolean checkEmail = userService.checkEmail(loginRequest.getEmail());
		
		if (checkEmail) {
			User user2 = userService.getUserByEmail(loginRequest.getEmail());
			if (user2.getPassword().equals(loginRequest.getPassword())) {
				UserDTO userDTO = new UserDTO(user2.getName(), user2.getEmail());
				return ResponseEntity.ok(userDTO);
			} else {
				return ResponseEntity.ok().body("Sai mật khẩu!");
			}
		} else {
			return ResponseEntity.ok().body("Email không tồn tại!");
		}

//		return ResponseEntity.ok("Not OK");
	}

}
