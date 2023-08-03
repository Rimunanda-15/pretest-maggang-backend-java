package com.testFullStack.rimunanda.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {
    private  boolean status;
    private String message;
}
