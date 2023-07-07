package com.rimunanda.ecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rimunanda.ecommerceapi.Entity.DetailTransactions;

public interface DetailTransactionRepository extends JpaRepository<DetailTransactions, String> {
    
}
