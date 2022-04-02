package com.attractor.controlwork7.repository;

import com.attractor.controlwork7.entity.Dish;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, String> {

    @Query ("select * from Dish d where d.place.id = :placeId")
    Slice<Dish> findByPlaceId(String placeId, Pageable pageable);
}
