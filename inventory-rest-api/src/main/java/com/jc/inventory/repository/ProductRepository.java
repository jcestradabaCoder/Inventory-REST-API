package com.jc.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jc.inventory.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}