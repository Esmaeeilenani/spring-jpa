package com.learning.springjpa.orderProduct;

import com.learning.springjpa.order.Order;
import com.learning.springjpa.product.Product;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

//@Entity
public class OrderProduct  {


    @EmbeddedId
    //OrderProductId

    private Long orderId;


    private Long productId;


    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

}
