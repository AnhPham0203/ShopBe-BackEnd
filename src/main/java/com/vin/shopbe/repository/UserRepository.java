package com.vin.shopbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vin.shopbe.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
