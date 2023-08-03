package com.testFullStack.rimunanda.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class CategoriesDto {
    @Data
    public static class Save{
        @NotEmpty(message = "tidak boleh kosong")
        @NotNull(message = "enggak boleh null")
        private String name;
    }

    @Data
    public static class Update{
        @NotEmpty(message = "tidak boleh kosong")
        @NotNull(message = "enggak boleh null")
        private String name;
    }
}
