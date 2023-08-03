package com.rimunanda.ecommerceapi.Entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Categories implements Serializable {

    @Id
    private String id;
    private String nama;


}
