package com.attractor.controlwork7.service;


import com.attractor.controlwork7.dto.PlaceDTO;
import com.attractor.controlwork7.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceRepository placeRepository;

    public Slice<PlaceDTO> findPlaces(Pageable pageable){
        var slice = placeRepository.findAll(pageable);
        return slice.map(PlaceDTO::from);
    }
}
