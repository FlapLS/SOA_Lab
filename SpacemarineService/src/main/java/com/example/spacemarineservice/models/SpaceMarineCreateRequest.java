package com.example.spacemarineservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

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
