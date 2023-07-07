package com.rimunanda.ecommerceapi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimunanda.ecommerceapi.Entity.Categories;
import com.rimunanda.ecommerceapi.exception.ResourceNotFoundException;
import com.rimunanda.ecommerceapi.repository.CategoryRepository;

/**
 * CategoryService
 */
@Service
public class KategoriService {

    @Autowired
    private CategoryRepository kategoriRepository;

    public Categories findById(String id) {
        return kategoriRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Kategori dengan id " + id + " tidak ditemukan"));
    }

    public List<Categories> findAll() {
        return kategoriRepository.findAll();
    }

    public Categories create(Categories Categories) {
        Categories.setId(UUID.randomUUID().toString());
        return kategoriRepository.save(Categories);
    }

    public Categories edit(Categories kategori) {
        return kategoriRepository.save(kategori);
    }

    public void deleteById(String id) {
        kategoriRepository.deleteById(id);
    }
}