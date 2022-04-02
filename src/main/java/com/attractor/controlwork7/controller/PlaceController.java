package com.attractor.controlwork7.controller;

import com.attractor.controlwork7.dto.DishDTO;
import com.attractor.controlwork7.dto.PlaceDTO;
import com.attractor.controlwork7.service.DishService;
import com.attractor.controlwork7.service.PlaceService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/places")
public class PlaceController {

    private final PlaceService placeService;
    private final DishService dishService;

    public PlaceController(PlaceService placeService, DishService dishService) {
        this.placeService = placeService;
        this.dishService = dishService;
    }

    @GetMapping
    public Slice<PlaceDTO> findPlaces(Pageable pageble){
        return placeService.findPlaces(pageble);
    }

    @GetMapping("{placeId}/dishes")
    public Slice<DishDTO> findDishes(@PathVariable String placeId, Pageable pageable){
        return dishService.findDishes(placeId, pageable);
    }
}
