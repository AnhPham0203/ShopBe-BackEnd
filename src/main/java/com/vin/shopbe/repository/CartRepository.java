package com.vin.shopbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vin.shopbe.model.Cart;
import java.util.List;


public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	Cart findByProductIdAndUserId(Integer pid, Integer uid);
	
	List<Cart> findByUserId(Integer uid);

}
