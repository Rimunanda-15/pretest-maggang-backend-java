package com.rimunanda.ecommerceapi.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * DetailTransactions
 */
@Entity
@Data
public class DetailTransactions {
    @Id
    private String id;
    @JoinColumn
    @ManyToOne
    private Transactions transaksi;
    @JoinColumn
    @ManyToOne
    private Products produk;
    private String deskripsi;
    private Double kuantitas;
    private BigDecimal harga;
    private BigDecimal jumlah;
    
}