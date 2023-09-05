package com.example.gatewaystarship.application.starship.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
