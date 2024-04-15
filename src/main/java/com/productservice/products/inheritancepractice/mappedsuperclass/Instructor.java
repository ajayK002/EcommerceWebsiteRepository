package com.productservice.products.inheritancepractice.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Entity(name = "ms_instructor")
@Getter
@Setter
public class Instructor extends User{
    private String specialization;
}
