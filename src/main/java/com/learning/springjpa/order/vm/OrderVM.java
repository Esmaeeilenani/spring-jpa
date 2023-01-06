package com.learning.springjpa.order.vm;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class OrderVM {
    private Long userId;
    private List<Long> productsIds = new ArrayList<>();

}
