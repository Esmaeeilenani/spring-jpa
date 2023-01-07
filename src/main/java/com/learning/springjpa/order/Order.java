package com.learning.springjpa.order;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.learning.springjpa.product.Product;
import com.learning.springjpa.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "app_order")
@Setter
@Getter
@ToString
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false,updatable = false)
    @ToString.Exclude
    @JsonIgnore
    private User user;

    private String refNumber;

    private Double totalPrice;

    @CreationTimestamp
    private LocalDateTime orderDate;


    @ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_product",
            joinColumns =  @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")

    )
    @ToString.Exclude
    @JsonIgnore
    private Set<Product>products = new HashSet<>();


    @JsonGetter(value = "ref-number")
    public String getRefNumber() {
        return refNumber;
    }

    public Order setProducts(Set<Product> products) {
        this.products = products;
        return this;
    }

    public Order setProducts(List<Product> products) {
        this.products = new HashSet<>(products);
        return this;

    }
}
