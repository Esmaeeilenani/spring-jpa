package com.learning.springjpa.product;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Setter
@Getter
@Accessors(chain = true)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @Column(name = "desc",nullable = false,unique = true, length = 50,columnDefinition = "")
    private String description;

    private Double price;

    private Integer inStock;

}
