package com.productservice.products.inheritancepractice.tableperclass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity(name = "tpc_user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    private String emailId;
    private String password;
}
