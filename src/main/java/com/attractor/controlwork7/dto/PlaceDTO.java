package com.attractor.controlwork7.dto;


import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class PlaceDTO {

    private Long id;
    private String name;
    private String description;
}
