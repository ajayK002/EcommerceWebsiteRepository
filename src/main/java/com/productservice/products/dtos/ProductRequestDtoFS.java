package com.productservice.products.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDtoFS {
    private String title;
    private String description;
    private float price;
    private String category;
    private String image;
}
