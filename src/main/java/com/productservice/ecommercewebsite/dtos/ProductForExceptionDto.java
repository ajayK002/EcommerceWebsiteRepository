package com.productservice.ecommercewebsite.dtos;

import com.productservice.ecommercewebsite.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductForExceptionDto {
    private Product product;
    private String message;
}
