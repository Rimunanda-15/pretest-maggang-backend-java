package com.testFullStack.rimunanda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    private Integer id;
    private Integer categoryId;
    private String name;
    private String harga;
    private  Integer stok;
    private String categoryName;
}
