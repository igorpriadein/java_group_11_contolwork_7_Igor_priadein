package com.attractor.controlwork7.repository;

import com.attractor.controlwork7.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {
}
