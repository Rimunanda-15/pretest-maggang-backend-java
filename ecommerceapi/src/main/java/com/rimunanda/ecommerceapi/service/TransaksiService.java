package com.rimunanda.ecommerceapi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimunanda.ecommerceapi.Entity.Transactions;
import com.rimunanda.ecommerceapi.exception.ResourceNotFoundException;
import com.rimunanda.ecommerceapi.repository.TransactionRepository;

@Service
public class TransaksiService {

    @Autowired
    private TransactionRepository transaksiRepository;

    public List<Transactions> findAll(){
        return transaksiRepository.findAll();
    }

    public Transactions findById(String id){
        return transaksiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Transaksi dengan id" + id + "tidak ditemukan"));
    }

    public Transactions create(Transactions transaksi){
        transaksi.setId(UUID.randomUUID().toString());
        return transaksiRepository.save(transaksi);
    }

    public Transactions edit(Transactions transaksi){
        return transaksiRepository.save(transaksi);
    }
    
    public void deleteById(String id){
        transaksiRepository.deleteById(id);
    }
}
