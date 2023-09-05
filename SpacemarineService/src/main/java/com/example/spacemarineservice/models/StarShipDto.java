package com.example.spacemarineservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class StarShipDto {

    private Long id;

    private String name;

    private String fleet;

    private Coordinates coordinates;

    private Long health;

    private Long marinesCount;

    List<Long> spaceMarines;

}
