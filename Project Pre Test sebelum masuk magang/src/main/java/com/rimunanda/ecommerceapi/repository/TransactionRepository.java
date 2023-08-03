package com.rimunanda.ecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rimunanda.ecommerceapi.Entity.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, String> {
    
}
