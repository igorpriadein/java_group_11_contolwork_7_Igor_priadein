package com.attractor.controlwork7.repository;

import com.attractor.controlwork7.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, String> {

    @Query ("select o from Order o where o.customer.email = :customerEmail")
    Slice<Order> findByEmail(String customerEmail, Pageable pageable);

}
