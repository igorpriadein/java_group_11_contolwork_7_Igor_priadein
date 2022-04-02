package com.attractor.controlwork7.service;

import com.attractor.controlwork7.dto.DishDTO;
import com.attractor.controlwork7.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;

    public Slice<DishDTO> findDishes(String placeId, Pageable pageable) {
        var slice = dishRepository.findByPlaceId(placeId, pageable);
        return slice.map(DishDTO::from);
    }
}
