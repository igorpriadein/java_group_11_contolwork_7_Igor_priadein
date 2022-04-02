package com.attractor.controlwork7.entity;

import com.attractor.controlwork7.util.GenerateData;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "place")
public class Place {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    public static Place random() {
        return builder()
                .name(GenerateData.randomPlace().getName())
                .description(GenerateData.randomPlace().getDescription())
                .build();
    }
}
