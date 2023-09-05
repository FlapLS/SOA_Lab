package com.example.gatewaystarship.application.starship.models;

import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class SpaceMarineFilterRequest extends PageDto {

    private String name;

    private Coordinates coordinates;

    private ZonedDateTime creationDate;

    private Long health;

    private String category;

    private String weaponType;

    private String meleeWeapon;

    private String sortBy;

    private String order;

}
