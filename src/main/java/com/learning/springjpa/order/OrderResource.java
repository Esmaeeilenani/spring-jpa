package com.learning.springjpa.order;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderResource {


    private final OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id){

        return ResponseEntity.ok(orderService.findById(id));
    }


    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody  Order order){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.saveOrder(order));
    }

}
