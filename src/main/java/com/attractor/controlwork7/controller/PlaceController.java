package com.attractor.controlwork7.controller;

import com.attractor.controlwork7.dto.PlaceDTO;
import com.attractor.controlwork7.service.PlaceService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/places")
public class PlaceController {

    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public Slice<PlaceDTO> findPlaces(Pageable pageble){
        return placeService.findPlaces(pageble);
    }
}
