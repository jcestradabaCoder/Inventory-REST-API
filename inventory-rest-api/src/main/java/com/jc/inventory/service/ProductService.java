package com.jc.inventory.service;

import java.util.List;

import com.jc.inventory.entity.Product;

public interface ProductService {
	
	void createProduct(Product product);
	List<Product> getAllProducts();
	Product getproductById(Integer productId);
	void deleteProduct(Integer productId);
}