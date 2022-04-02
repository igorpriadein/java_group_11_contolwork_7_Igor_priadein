package com.attractor.controlwork7.repository;

import com.attractor.controlwork7.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, String> {
    Optional<Customer> getByEmail(String email);
}
