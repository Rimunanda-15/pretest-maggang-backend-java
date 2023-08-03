package com.rimunanda.ecommerceapi.Entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class PesananLog implements Serializable {
    @Id
    private String id;
    @JoinColumn
    @ManyToOne
    private Transactions pesanan;
    @JoinColumn
    @ManyToOne
    private Users pengguna;
    private Integer logType;
    private String logMessage;
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktu;
}
