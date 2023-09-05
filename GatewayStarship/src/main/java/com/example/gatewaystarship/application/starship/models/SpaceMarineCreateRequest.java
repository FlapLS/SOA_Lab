package com.example.gatewaystarship.application.starship.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class SpaceMarineCreateRequest {

    private Long id;

    private String name;

    private Coordinates coordinates;

    private Long health;

    private String category;

    private String weaponType;

    private String meleeWeapon;

}
