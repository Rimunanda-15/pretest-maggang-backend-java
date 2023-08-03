package com.testFullStack.rimunanda.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class UserProductDto {
    @Data
    public  static class Save{
        @NotNull(message = "data tidak boleh kosong")
        @NotEmpty(message = "data kosong")
        @Min(value = -1)
        private Integer userId;
        @NotNull(message = "data tidak boleh kosong")
        @Min(value = -1)
        @NotEmpty(message = "string tidak boleh kosong")
        private Integer productId;
        @NotNull(message = "data tidak boleh kosong")
        @Min(value = 0,message = "minimal data diisi dimulai dengan 0 ")
        @NotNull(message = "data tidak boleh kosong")
        @Min(value = -1,message = "minimal data diisi dimulai dengan 0 ")
        private Integer quantity;
    }
    @Data
    public static class Update{
        @NotNull(message = "data tidak boleh kosong")
        @NotEmpty(message = "string tidak boleh kosong")
        @Min(value = -1)
        private Integer userId;
        @NotNull(message = "data tidak boleh kosong")
        @Min(value = -1)
        @NotEmpty(message = "string tidak boleh kosong")
        private Integer productId;
        @NotNull(message = "data tidak boleh kosong")
        @Min(value = 0,message = "minimal data diisi dimulai dengan 0 ")
        @NotNull(message = "data tidak boleh kosong")
        @Min(value = -1,message = "minimal data diisi dimulai dengan 0 ")
        private Integer quantity;
    }
}
