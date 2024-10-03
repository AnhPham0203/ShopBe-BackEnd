package com.vin.shopbe.service;

import com.vin.shopbe.model.User;

public interface UserService {
	
	User createUser(User user);
	
	Boolean checkEmail(String email);
	
	User getUserByEmail(String email);

}
