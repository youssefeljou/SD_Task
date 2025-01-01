package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "countries")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Country {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String isoCode;


}
