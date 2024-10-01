package com.vin.shopbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vin.shopbe.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
