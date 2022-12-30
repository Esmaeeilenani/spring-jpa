package com.learning.springjpa.order;


import com.learning.springjpa.user.User;
import com.learning.springjpa.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;


    public Order saveOrder(Order order) {
        User user = userService.findById(order.getUserId());
        order
                .setUser(user)
                .setRefNumber(UUID.randomUUID().toString());
        return orderRepository.save(order);
    }

    public Order findById(Long id) {
        return orderRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("order not found"));
    }
}
