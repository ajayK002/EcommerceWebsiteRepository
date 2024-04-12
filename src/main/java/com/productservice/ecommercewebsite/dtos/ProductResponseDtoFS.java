package com.productservice.ecommercewebsite.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDtoFS {
    private Long id;
    private String title;
    private Float price;
    private String category;
    private String description;
    private String image;
}
