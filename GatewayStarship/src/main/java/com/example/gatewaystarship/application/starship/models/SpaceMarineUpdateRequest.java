package com.example.gatewaystarship.application.starship.models;

import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class SpaceMarineUpdateRequest {

    private Long id;

    private String name;

    private Coordinates coordinates;

    private ZonedDateTime creationDate;

    private Long health;

    private String category;

    private String weaponType;

    private String meleeWeapon;

    private Long starShipId;

}
