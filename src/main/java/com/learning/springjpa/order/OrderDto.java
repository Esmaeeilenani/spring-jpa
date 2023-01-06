package com.learning.springjpa.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.learning.springjpa.product.ProductDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {


    private Long id;


    private Long userId;

//    private User user;

//    private String orderNumber;

    private String refNumber;

    private Double totalPrice;


    private LocalDateTime orderDate;

    private Set<ProductDto> products;


    public OrderDto setProducts(Set<ProductDto> products) {
        this.products = products;

        return this;
    }

    public OrderDto setProducts(List<ProductDto> products) {
        this.products = new HashSet<>(products);

        return this;
    }


}
