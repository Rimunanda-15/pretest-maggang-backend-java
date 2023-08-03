package com.rimunanda.ecommerceapi.Entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Products implements Serializable {
    @Id
    private String id;
    private String nama;
    private String deskripsi;
    @JoinColumn
    @ManyToOne
    private Categories kategori;
    private BigDecimal harga;
    private Double stok;
}
