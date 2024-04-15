package com.productservice.products.inheritancepractice.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("3")
public class TA extends User {
    private Float avgRating;
    private Long noOfSessions;
}
