package com.rimunanda.ecommerceapi.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.rimunanda.ecommerceapi.model.StatusPesanan;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Transactions implements Serializable {
    @Id
    private String id;
    private String nomor;
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @JoinColumn
    @ManyToOne
    private Users pengguna;
    private String alamatPengiriman;
    private BigDecimal jumlah;
    private BigDecimal ongkir;
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    private StatusPesanan statusPesanan;
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuPesan;
}
