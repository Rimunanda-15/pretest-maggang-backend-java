package com.testFullStack.rimunanda.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigInteger;

public class ProductsDto {
    @Data
    public static class Save{
        @NotEmpty(message = "tidak boleh kosong")
        @NotNull(message = "enggak boleh null")
        private String name;

        @NotNull(message = "tidak boleh kosong ")
        @Min(value = 1,message = "tidak ada id ny")
        private Integer categoryId;
        @NotNull(message = "tidak boleh kosong")
        @NotEmpty(message = "Tidak boleh null")
        private String harga;
        @Min(value = 0)
        private BigInteger stok;
    }

    @Data
    public static class Update{
        @NotEmpty(message = "tidak boleh kosong")
        @NotNull(message = "enggak boleh null")
        private String name;

        @NotNull(message = "tidak boleh kosong ")
        @Min(value = 1)
        private Integer categoryId;
        @NotNull(message = "tidak boleh kosong")
        @NotEmpty(message = "Tidak boleh null")
        private String harga;
        @Min(value = 0,message = "minimal data diisi dimulai dengan 0 ")
        private BigInteger stok;
    }
}
