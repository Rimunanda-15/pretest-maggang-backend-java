package com.rimunanda.ecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rimunanda.ecommerceapi.Entity.Users;

public interface UserRepository extends JpaRepository<Users, String> {
    
}
