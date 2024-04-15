package com.productservice.products.inheritancepractice.singletable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity(name = "st_user")
@DiscriminatorColumn(
        name = "discriminatorType",
        discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue("0")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String emailId;
    private String password;
}
