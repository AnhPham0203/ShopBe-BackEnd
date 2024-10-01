package com.vin.shopbe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vin.shopbe.model.Product;
import com.vin.shopbe.repository.ProductRepository;
import com.vin.shopbe.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).get();
	}

}
