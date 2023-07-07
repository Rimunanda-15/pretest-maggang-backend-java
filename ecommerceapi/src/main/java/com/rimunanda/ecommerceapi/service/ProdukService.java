package com.rimunanda.ecommerceapi.service;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimunanda.ecommerceapi.Entity.Products;
import com.rimunanda.ecommerceapi.exception.ResourceNotFoundException;

import com.rimunanda.ecommerceapi.repository.ProductsRepository;

@Service
public class ProdukService {
    

    @Autowired
    private ProductsRepository produkRepository;

    public List<Products> findAll(){
        return produkRepository.findAll();
    }
    public Products findById(String id){
        return produkRepository.findById(id).orElseThrow( () -> new  ResourceNotFoundException("Produk dengan id" + id + "tidak ada"));
    }

    public Products create(Products produk){
        produk.setId(UUID.randomUUID().toString());
        return produkRepository.save(produk);
    }

    public Products edit(Products produk){
        return produkRepository.save(produk);
    }

    public void delete(String id){
        produkRepository.deleteById(id);
    }
}
