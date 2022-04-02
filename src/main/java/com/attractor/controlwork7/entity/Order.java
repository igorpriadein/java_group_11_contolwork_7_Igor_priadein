package com.attractor.controlwork7.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "order")
public class Order {

    private Long Id;
    private Customer customer;
    private Dish orderedDish;
    private LocalDateTime dateOfOrder;
}
