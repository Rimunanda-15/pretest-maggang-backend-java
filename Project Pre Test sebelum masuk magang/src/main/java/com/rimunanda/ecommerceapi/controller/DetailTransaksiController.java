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

import com.rimunanda.ecommerceapi.Entity.DetailTransactions;
import com.rimunanda.ecommerceapi.service.DetailTransaksi;
import com.rimunanda.ecommerceapi.service.TransaksiService;

/**
 * DetailTransaksiController
 */

@RestController
@RequestMapping("/api")
public class DetailTransaksiController {

    @Autowired
    private DetailTransaksi transaksiService;

    @GetMapping("/detailTransaksi")
    public List<DetailTransactions> findAll(){
        return transaksiService.findAll();
    }

    @GetMapping("/detailTransaksi/{id}")
    public DetailTransactions findById(@PathVariable("id") String id){
        return transaksiService.findByid(id);
    }
    @PostMapping("/detailTransaksis")
    public DetailTransactions create(@RequestBody DetailTransactions detailTransactions){
        return transaksiService.create(detailTransactions);   
    }
    @PutMapping("/details")
    public DetailTransactions edit(@RequestBody DetailTransactions detailTransactions){
        return transaksiService.edit(detailTransactions);
    }
    @DeleteMapping("/details/{id}")
    public void deleteById(@PathVariable("id") String id){
        transaksiService.deleteById(id);
    }
}