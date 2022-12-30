package com.learning.springjpa.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.springjpa.order.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String fullName;

    private Integer age;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Order> orders = new ArrayList<>();



}
