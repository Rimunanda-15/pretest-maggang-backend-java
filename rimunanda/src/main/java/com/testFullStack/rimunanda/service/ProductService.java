package com.testFullStack.rimunanda.service;

import com.testFullStack.rimunanda.dao.ProductDao;
import com.testFullStack.rimunanda.dto.ProductsDto;
import com.testFullStack.rimunanda.entity.Products;
import com.testFullStack.rimunanda.exception.IdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDao dao;
    private final CategoryService category;

    public void save(ProductsDto.Save data){
        category.findById(data.getCategoryId());
        this.dao.save(data);
    }
    public void update(Integer id, ProductsDto.Update data){
        findById(id);
        category.findById(data.getCategoryId());
        this.dao.update(id, data);
    }
    public List<Products> findAll(){return this.dao.findAll();}
    public Products findById(Integer id){
        return this.dao.findById(id)
                .orElseThrow( () -> new IdNotFoundException(" produk dengan id "+ id + " tidak ditemukan "));
    }
    public void delete(Integer id){findById(id); this.dao.delete(id);}
}
