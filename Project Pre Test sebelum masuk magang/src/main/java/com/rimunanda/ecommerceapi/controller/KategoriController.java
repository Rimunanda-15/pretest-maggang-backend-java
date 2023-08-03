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

import com.rimunanda.ecommerceapi.Entity.Categories;
import com.rimunanda.ecommerceapi.service.KategoriService;

/**
 * KategoriController
 */

@RestController
@RequestMapping("/api")
public class KategoriController {
    
    @Autowired
    private KategoriService kategoriService;

    //get all kategori
    @GetMapping("/kategori")
    public List<Categories> findAll() {
        return kategoriService.findAll();
    }

    //get by kategori
    @GetMapping("/kategori/{id}")
    public Categories findById(@PathVariable("id") String id ){
        return kategoriService.findById(id);
    }

    @PostMapping("/kategoris")
    public Categories create(@RequestBody Categories kategori){
        return kategoriService.create(kategori);
    }

    @PutMapping("/kategoris")
    public Categories edit(@RequestBody Categories kategori){
        return kategoriService.edit(kategori);
    }

    @DeleteMapping("/kategoris/{id}")
    public void deleteById(@PathVariable("id") String id){
        kategoriService.deleteById(id);
    }
}