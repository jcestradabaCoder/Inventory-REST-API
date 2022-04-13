package com.jc.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jc.inventory.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}