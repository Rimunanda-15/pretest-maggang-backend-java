package com.testFullStack.rimunanda.service;

import com.testFullStack.rimunanda.dao.UserProductDao;
import com.testFullStack.rimunanda.dto.UserProductDto;
import com.testFullStack.rimunanda.entity.Products;
import com.testFullStack.rimunanda.entity.UserProduct;
import com.testFullStack.rimunanda.exception.IdNotFoundException;
import com.testFullStack.rimunanda.exception.StockNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProductService {
    private final UserProductDao dao;
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final UserService user;
    private final ProductService product;
    public void save(UserProductDto.Save data ){
        user.findById(data.getUserId());
        product.findById(data.getProductId());
        Products products = product.findById(data.getProductId());
        int quantityToSave = data.getQuantity();
        if (products.getStok() >= quantityToSave){
            int updatedStock = products.getStok() - quantityToSave;
            String query="UPDATE public.product SET stok=:stok WHERE id=:id ;";
            MapSqlParameterSource map = new MapSqlParameterSource();
            map.addValue("stok", updatedStock);
            map.addValue("id",products.getId());
            this.jdbcTemplate.update(query,map);
            this.dao.save(data);
        }else {
            throw new StockNotFoundException("stok produk kosong");
        }

    }
    public void update(Integer id, UserProductDto.Update data){
        findById(id);
        user.findById(data.getUserId());
        product.findById(data.getProductId());
        Products products = product.findById(data.getProductId());
        int quantityToSave = data.getQuantity();
        if (products.getStok() >= quantityToSave){
            int updatedStock = products.getStok() - quantityToSave;
            String query="UPDATE public.product SET stok=:stok WHERE id=:id ;";
            MapSqlParameterSource map = new MapSqlParameterSource();
            map.addValue("stok", updatedStock);
            map.addValue("id",products.getId());
            this.jdbcTemplate.update(query,map);
            this.dao.update(id,data);
        }else {
            throw new StockNotFoundException("produk stok kosong");
        }

    }
    public List<UserProduct> findAll(){
        return this.dao.findAll();
    }
    public UserProduct findById(Integer id){
        return this.dao.findById(id)
                .orElseThrow( () -> new IdNotFoundException("data dengan id"+ id + "tidak ditemukan"));
    }
    public void delete(Integer id){
        findById(id);
        this.dao.delete(id);
    }
}
