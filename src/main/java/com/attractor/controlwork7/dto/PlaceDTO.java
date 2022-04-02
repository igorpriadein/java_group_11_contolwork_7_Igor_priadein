package com.attractor.controlwork7.dto;


import com.attractor.controlwork7.entity.Dish;
import com.attractor.controlwork7.entity.Place;
import lombok.*;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class PlaceDTO {

    private Long id;
    private String name;
    private String description;

    public static PlaceDTO from(Place place){
        return builder()
                .id(place.getId())
                .name(place.getName())
                .description(place.getDescription())
                .build();
    }
}
