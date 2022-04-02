package com.attractor.controlwork7.entity;

import com.attractor.controlwork7.dto.DishDTO;
import com.attractor.controlwork7.dto.PlaceDTO;
import com.attractor.controlwork7.util.GenerateData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.Random;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "dish")
public class Dish {
    private static final Random r = new Random();


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    public static Dish random() {
        return builder()
                .name(GenerateData.randomDish().getName())
                .type(GenerateData.randomDish().getType())
                .price(Math.ceil(r.nextDouble()*10))
                .build();
    }
}
