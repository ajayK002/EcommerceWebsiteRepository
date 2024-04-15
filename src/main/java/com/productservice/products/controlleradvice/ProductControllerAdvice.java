package com.productservice.products.controlleradvice;

import com.productservice.products.exceptions.ProductOutOfRangeException;
import com.productservice.products.exceptions.ProductRangeUndefinedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(value = ProductOutOfRangeException.class)
    public ResponseEntity<String> exception(ProductOutOfRangeException exception) {
        return new ResponseEntity<>("Product Out of Range", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ProductRangeUndefinedException.class)
    public ResponseEntity<String> exception(ProductRangeUndefinedException exception){
        return new ResponseEntity<>("Product Range Undefined", HttpStatus.NOT_FOUND);
    }
}
