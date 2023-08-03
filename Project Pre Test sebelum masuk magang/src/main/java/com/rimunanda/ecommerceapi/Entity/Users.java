package com.rimunanda.ecommerceapi.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Users {
    
    @Id
    private String id;
    private String password;
    private String nama;
    private String alamat;
    private String email;
    private String hp;
    private String roles;
    private Boolean isAktif;

}
