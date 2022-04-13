package com.jc.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jc.inventory.model.Product;
import com.jc.inventory.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@PostMapping("/products")
	public ResponseEntity<String> createProduct(@RequestBody Product product) {
		productService.createProduct(product);
		return new ResponseEntity<>("Product created successfully!", HttpStatus.CREATED);
	}
	
	@GetMapping("/products/{productId}")
	public ResponseEntity<Product> getproductById(@PathVariable(name = "productId") Integer productId) {
		
		try {
			return new ResponseEntity<>(productService.getproductById(productId), HttpStatus.OK);
		}
		catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/products/{productId}")
	public ResponseEntity<?> updateProduct(@PathVariable(name = "productId") Integer productId, @RequestBody Product productRequest) {
		try {
			Product product = productService.getproductById(productId);
			product.setName(productRequest.getName());
			product.setPrice(productRequest.getPrice());
			productService.createProduct(product);
			return new ResponseEntity<>("Product updated successfully!", HttpStatus.OK);
		}
		catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable(name = "productId") Integer productId) {
		
		try {
			Product product = productService.getproductById(productId);
			productService.deleteProduct(productId);
			return new ResponseEntity<>("Product deleted successfully!", HttpStatus.OK);
		}
		catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}