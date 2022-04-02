package com.attractor.controlwork7.repository;

import com.attractor.controlwork7.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, String> {

    @Query ("select o from Order o where o.customer.id = :customerId")
    Slice<Order> findByCustomerId(String customerId, Pageable pageable);

}
