package com.attractor.controlwork7.dto;

import com.attractor.controlwork7.entity.Place;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class DishDTO {

    private Long id;
    private String name;
    private String type;
    private Double price;
    private Place place;
}
