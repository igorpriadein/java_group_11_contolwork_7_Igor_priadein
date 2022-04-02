package com.attractor.controlwork7.controller;

import com.attractor.controlwork7.dto.OrderDTO;
import com.attractor.controlwork7.entity.Customer;
import com.attractor.controlwork7.service.OrderService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;


@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping
    public OrderDTO addOrder(@RequestBody OrderDTO orderDTO,@RequestParam String userId){
        return orderService.addOrder(orderDTO, userId);
    }

    @GetMapping
    public Slice<OrderDTO> findOrders(Authentication authenticaton, Pageable pageable){
        Customer customer = (Customer) authenticaton.getPrincipal();
        return orderService.findByEmail(customer.getUsername(), pageable);
    }
}
