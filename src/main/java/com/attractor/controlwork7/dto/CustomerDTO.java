package com.attractor.controlwork7.dto;

import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CustomerDTO {

    private Long id;
    private String name;
    private String email;

}
