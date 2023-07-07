package com.rimunanda.ecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rimunanda.ecommerceapi.Entity.Products;

public interface ProductsRepository extends JpaRepository<Products, String> {
    
}
