package com.example.gatewaystarship.application.starship.models;

import com.example.gatewaystarship.application.starship.models.enums.AstartesCategory;
import com.example.gatewaystarship.application.starship.models.enums.MeleeWeapon;
import com.example.gatewaystarship.application.starship.models.enums.Weapon;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class SpaceMarineDto {

    private Long id;

    private String name;

    private Coordinates coordinates;

    private ZonedDateTime creationDate;

    private Long health;

    private AstartesCategory category;

    private Weapon weaponType;

    private MeleeWeapon meleeWeapon;

    private Long starShipId;

}
