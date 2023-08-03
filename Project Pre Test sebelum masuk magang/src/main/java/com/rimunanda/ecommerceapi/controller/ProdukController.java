package com.rimunanda.ecommerceapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.rimunanda.ecommerceapi.Entity.Products;
import com.rimunanda.ecommerceapi.service.ProdukService;

/**
 * ProdukController
 */

@RestController
@RequestMapping("/api")
public class ProdukController {
    
    @Autowired
    private ProdukService produkService;

    //get all produk
    @GetMapping("/produk")
    public List<Products> findAll() {
        return produkService.findAll();
    }

    //get by produk
    @GetMapping("/produk/{id}")
    public Products findById(@PathVariable("id") String id ){
        return produkService.findById(id);
    }

    @PostMapping("/produks")
    public Products create(@RequestBody Products produk){
        return produkService.create(produk);
    }

    @PutMapping("/produks")
    public Products edit(@RequestBody Products produk){
        return produkService.edit(produk);
    }

    @DeleteMapping("/produks/{id}")
    public void deleteById(@PathVariable("id") String id){
        produkService.delete(id);;
    }
}