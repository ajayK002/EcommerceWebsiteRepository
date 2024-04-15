package com.productservice.products.inheritancepractice.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Entity(name = "ms_ta")
@Getter
@Setter
public class TA extends User{
    private Float avgRating;
    private Long noOfSessions;
}
