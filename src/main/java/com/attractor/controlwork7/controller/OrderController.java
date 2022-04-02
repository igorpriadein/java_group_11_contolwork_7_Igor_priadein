package com.attractor.controlwork7.controller;

import com.attractor.controlwork7.dto.OrderDTO;
import com.attractor.controlwork7.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping
    public ResponseEntity addOrder(@RequestBody OrderDTO orderDTO,@RequestParam String userId){
        return ResponseEntity.ok(orderService.addOrder(orderDTO, userId));
    }
}
