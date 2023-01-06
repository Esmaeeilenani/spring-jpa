package com.learning.springjpa.product;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.springjpa.order.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Set;

@Entity
@Setter
@Getter
@Accessors(chain = true)
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    private Integer inStock;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
    @ToString.Exclude
    @JsonIgnore
    private Set<Order> orders;

}
