package com.learning.springjpa.product;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.learning.springjpa.order.Order;
import com.learning.springjpa.order.OrderDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {


    private Long id;

    private String name;

    private String description;

    private Double price;

    private Integer inStock;

    private Set<OrderDto> orders;

}
