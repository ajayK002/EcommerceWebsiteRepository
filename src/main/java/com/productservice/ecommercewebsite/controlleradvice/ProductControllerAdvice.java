package com.productservice.ecommercewebsite.controlleradvice;

import com.productservice.ecommercewebsite.dtos.ProductForExceptionDto;
import com.productservice.ecommercewebsite.exceptions.ProductNotFoundException;
import com.productservice.ecommercewebsite.exceptions.ProductOutofRangeException;
import com.productservice.ecommercewebsite.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(ProductOutofRangeException.class)
    public ResponseEntity<String> exception(ProductOutofRangeException exception){
        return new ResponseEntity<>("Product is out of range", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductForExceptionDto> exception(ProductNotFoundException exception){
        ProductForExceptionDto product = new ProductForExceptionDto(new Product(),
                "Product searched not found");
        return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
    }
}
