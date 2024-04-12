package com.productservice.ecommercewebsite.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;

@Entity
@Getter
@Setter
public class Product extends BaseModel {
    private String description;
    private Float price;
    private String image;
    @ManyToOne
    private Category category;
}
