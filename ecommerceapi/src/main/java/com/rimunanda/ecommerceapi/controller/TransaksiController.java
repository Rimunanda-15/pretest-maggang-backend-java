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

import com.rimunanda.ecommerceapi.Entity.Transactions;
import com.rimunanda.ecommerceapi.service.TransaksiService;

@RestController
@RequestMapping("/api")
public class TransaksiController {

    @Autowired
    private TransaksiService transaksiService;
    
    @GetMapping("/transaksi")
    public List<Transactions> findAll(){
        return transaksiService.findAll();
    }

    @GetMapping("/transaksi/{id}")
    public Transactions findById(@PathVariable("id") String id){
        return transaksiService.findById(id);
    }

    @PostMapping("/transaksis")
    public Transactions create(@RequestBody Transactions transaksi){
        return transaksiService.create(transaksi);
    }
    @PutMapping("/transaksis")
    public Transactions edit(@RequestBody Transactions transaksi){
        return transaksiService.edit(transaksi);
    }
    @DeleteMapping("/produks/{id}")
    public void deleteById(@PathVariable("id") String id){
        transaksiService.deleteById(id);
    }
}
