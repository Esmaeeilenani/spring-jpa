package com.learning.springjpa.user;


import com.learning.springjpa.order.OrderDto;


import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private Long id;

    private String username;

    private String fullName;

    private Integer age;


    private List<OrderDto> orders = new ArrayList<>();


}
