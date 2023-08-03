package com.testFullStack.rimunanda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({IdNotFoundException.class, StockNotFoundException.class})
    public ResponseEntity<ErrorDetails> idNotFoundException(IdNotFoundException ex){
        ErrorDetails errorModel = new ErrorDetails(false, ex.getMessage());
        return  new ResponseEntity<ErrorDetails>(errorModel, HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<ErrorDetails>stockNotFoundException(StockNotFoundException ex){
        ErrorDetails errorModel = new ErrorDetails(false, ex.getMessage());
        return  new ResponseEntity<ErrorDetails>(errorModel, HttpStatus.NOT_FOUND);
    }
}
