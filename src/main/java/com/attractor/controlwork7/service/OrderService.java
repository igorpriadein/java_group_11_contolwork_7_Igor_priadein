package com.attractor.controlwork7.service;

import com.attractor.controlwork7.dto.OrderDTO;
import com.attractor.controlwork7.entity.Dish;
import com.attractor.controlwork7.entity.Order;
import com.attractor.controlwork7.entity.Place;
import com.attractor.controlwork7.repository.CustomerRepository;
import com.attractor.controlwork7.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderDTO addOrder(OrderDTO orderDTO, String customerId){
        var customer = customerRepository.findById(customerId).orElseThrow();
        var order = Order.builder()
                .id(orderDTO.getId())
                .dateOfOrder(LocalDateTime.now())
                .dish(Dish.builder().id(orderDTO.getDishId()).build())
                .place(Place.builder().id(orderDTO.getPlaceId()).build())
                .customer(customer)
                .build();
        orderRepository.save(order);
        return OrderDTO.from(order);
    }

    public Slice<OrderDTO> findOrders(String customerId, Pageable pageable){
        var slice = orderRepository.findByCustomerId(customerId, pageable);
        return slice.map(OrderDTO::from);
    }
}
