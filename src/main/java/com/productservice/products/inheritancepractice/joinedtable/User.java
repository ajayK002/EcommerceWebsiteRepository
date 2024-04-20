package com.productservice.products.inheritancepractice.joinedtable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "jt_user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private String emailId;
    private String password;
}
