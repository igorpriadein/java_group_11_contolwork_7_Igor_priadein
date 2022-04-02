package com.attractor.controlwork7.dto;

import com.attractor.controlwork7.entity.Customer;
import com.attractor.controlwork7.entity.Dish;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class OrderDTO {

    private Long Id;
    private Customer customer;
    private Dish orderedDish;
    private LocalDateTime dateOfOrder;
}
