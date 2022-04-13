package com.jc.inventory.service;

import java.util.List;

import com.jc.inventory.model.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	void createProduct(Product product);
	Product getproductById(Integer productId);
	void deleteProduct(Integer productId);
}