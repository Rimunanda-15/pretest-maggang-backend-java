package com.rimunanda.ecommerceapi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimunanda.ecommerceapi.Entity.DetailTransactions;

import com.rimunanda.ecommerceapi.exception.ResourceNotFoundException;
import com.rimunanda.ecommerceapi.repository.DetailTransactionRepository;

@Service
public class DetailTransaksi {
    @Autowired
    private DetailTransactionRepository detailTransaksiRepository;

    public List<DetailTransactions> findAll(){
        return detailTransaksiRepository.findAll();
    }

    public DetailTransactions findByid(String id){
        return detailTransaksiRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Detail Transaksi dengan id" + id + "tidak ada"));
    }

    public DetailTransactions create(DetailTransactions detailTransaksi){
        detailTransaksi.setId(UUID.randomUUID().toString());
        return detailTransaksiRepository.save(detailTransaksi);
    }

    public DetailTransactions edit(DetailTransactions detailTransaksi){
        return detailTransaksiRepository.save(detailTransaksi);
    }

    public void deleteById(String id){
        detailTransaksiRepository.deleteById(id);
    }
}
