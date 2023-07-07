package com.rimunanda.ecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rimunanda.ecommerceapi.Entity.Categories;

/**
 * CategoryRepository
 */
public interface CategoryRepository extends JpaRepository<Categories, String> {
    
    
}