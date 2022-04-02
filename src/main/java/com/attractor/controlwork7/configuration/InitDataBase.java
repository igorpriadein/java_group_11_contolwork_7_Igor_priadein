package com.attractor.controlwork7.configuration;

import com.attractor.controlwork7.entity.Customer;
import com.attractor.controlwork7.entity.Dish;
import com.attractor.controlwork7.entity.Place;
import com.attractor.controlwork7.repository.CustomerRepository;
import com.attractor.controlwork7.repository.DishRepository;
import com.attractor.controlwork7.repository.OrderRepository;
import com.attractor.controlwork7.repository.PlaceRepository;
import com.attractor.controlwork7.util.GenerateData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Configuration
public class InitDataBase {
    private static final Random r = new Random();
    private final CustomerRepository customerRepository;
    private final PasswordEncoder encoder;

    public InitDataBase(CustomerRepository customerRepository, PasswordEncoder encoder) {
        this.customerRepository = customerRepository;
        this.encoder = encoder;
    }

    @Bean
    CommandLineRunner init(CustomerRepository customerRepository, DishRepository dishRepository, OrderRepository orderRepository, PlaceRepository placeRepository){
        return (args) -> {
            customerRepository.deleteAll();
            dishRepository.deleteAll();
            placeRepository.deleteAll();

            List<Customer> customers = Stream.generate(Customer::random)
                    .limit(10)
                    .collect(toList());


            List<Place> places = Stream.generate(Place::random)
                    .limit(10)
                    .collect(toList());

            List<Dish> dishes = Stream.generate(Dish::random)
                    .limit(10)
                    .collect(toList());

            customers.forEach(c -> c.setPassword(encoder.encode("test")));

            placeRepository.saveAll(places);
            customerRepository.saveAll(customers);
            dishRepository.saveAll(dishes);

        };
    }
}
