package com.attractor.controlwork7.entity;

import com.attractor.controlwork7.util.GenerateData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public static Customer random(){
        return builder()
                .name(GenerateData.randomPersonName())
                .email(GenerateData.randomEmail())
                .build();
    }
}
