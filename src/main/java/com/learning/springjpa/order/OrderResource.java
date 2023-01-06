package com.learning.springjpa.order;


import com.learning.springjpa.order.vm.OrderVM;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderResource {


    private final OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long id){

        return ResponseEntity.ok(orderService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAll());
    }


    @PostMapping
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderVM orderVM){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.saveOrder(orderVM));
    }

}
