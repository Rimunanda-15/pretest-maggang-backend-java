package com.rimunanda.ecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rimunanda.ecommerceapi.Entity.PesananLog;

public interface  PesananLogRepository extends JpaRepository<PesananLog,String> {
    
}
