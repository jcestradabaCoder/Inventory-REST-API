package com.jc.inventory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jc.inventory.entity.Product;
import com.jc.inventory.repository.ProductRepository;
import com.jc.inventory.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public void createProduct(Product product) {
		productRepository.save(product);
	}
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@Override
	public Product getproductById(Integer productId) {
		return productRepository.findById(productId).get();
	}
	
	@Override
	public void deleteProduct(Integer productId) {
		productRepository.deleteById(productId);
	}
}