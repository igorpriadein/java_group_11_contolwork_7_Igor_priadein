package com.attractor.controlwork7.dto;

import com.attractor.controlwork7.entity.Customer;
import com.attractor.controlwork7.entity.Dish;
import com.attractor.controlwork7.entity.Order;
import com.attractor.controlwork7.entity.Place;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class OrderDTO {

    private Long id;
    private Long customerId;
    private Long dishId;
    private Long placeId;
    private LocalDateTime dateOfOrder;

    public static OrderDTO from(Order order){
        return builder()
                .id(order.getId())
                .customerId(order.getCustomer().getId())
                .dishId(order.getDish().getId())
                .placeId(order.getPlace().getId())
                .dateOfOrder(order.getDateOfOrder())
                .build();
    }
}
