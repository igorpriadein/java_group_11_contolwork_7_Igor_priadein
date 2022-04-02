package com.attractor.controlwork7.repository;

import com.attractor.controlwork7.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, String> {
}
