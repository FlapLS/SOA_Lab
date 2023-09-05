package com.example.spacemarineservice.models;

import com.example.spacemarineservice.models.enums.AstartesCategory;
import com.example.spacemarineservice.models.enums.MeleeWeapon;
import com.example.spacemarineservice.models.enums.Weapon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

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
