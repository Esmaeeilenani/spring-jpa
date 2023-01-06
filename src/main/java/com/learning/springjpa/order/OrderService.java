package com.learning.springjpa.order;


import com.learning.springjpa.order.vm.OrderVM;
import com.learning.springjpa.product.Product;
import com.learning.springjpa.product.ProductMapper;
import com.learning.springjpa.product.ProductService;
import com.learning.springjpa.user.User;
import com.learning.springjpa.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final UserService userService;


    public OrderDto saveOrder(OrderVM orderVM) {


        List<Product> orderProducts = productService.getAllById(orderVM.getProductsIds());

        Double totalPrice = orderProducts
                .stream()
                .mapToDouble(Product::getPrice)
                .sum();


        if (orderProducts.isEmpty() || orderProducts.size() != orderVM.getProductsIds().size()) {
            throw new RuntimeException("no Products found");
        }

        Order order = new Order()
                .setUserId(orderVM.getUserId())
                .setTotalPrice(totalPrice)
                .setProducts(orderProducts)
                .setRefNumber(UUID.randomUUID().toString());

        OrderDto orderDto = OrderMapper.MAP.toDto(orderRepository.save(order));
        orderDto.setProducts(ProductMapper.MAP.toDto(orderProducts));


        return orderDto;
    }

    public Order findById(Long id) {
        return orderRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("order not found"));
    }


    public OrderDto getById(Long id) {
        Order order = this.findById(id);
        OrderDto orderDto = OrderMapper.MAP.toDto(order);
        orderDto.setProducts(ProductMapper.MAP.toDto(order.getProducts().stream().toList()));
        return orderDto;
    }


    public List<OrderDto> getAll() {
    return OrderMapper.MAP.toDto(orderRepository.findAll());
    }
}
