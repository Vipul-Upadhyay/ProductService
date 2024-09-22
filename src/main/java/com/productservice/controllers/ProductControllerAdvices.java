package com.productservice.controllers;

import com.productservice.exceptions.ProductNotFoundException;
import com.productservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvices {
@ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ExceptionDto> handleProductNotFoundException(
            ProductNotFoundException productNotFoundException
    ){

        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(productNotFoundException.getMessage());
        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
