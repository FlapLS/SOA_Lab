package com.example.spacemarineservice.domain;

import com.example.spacemarineservice.models.enums.AstartesCategory;
import com.example.spacemarineservice.models.enums.MeleeWeapon;
import com.example.spacemarineservice.models.enums.Weapon;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table(name = "spacemarine")
public class SpaceMarine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", allocationSize = 1, sequenceName = "spacemarine_seq")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "coordinate_x")
    private Integer coordinateX;

    @Column(name = "coordinate_y")
    private Long coordinateY;

    @Column(name = "creation_date")
    private ZonedDateTime creationDate;

    @Column(name = "health")
    private Long health;

    @Column(name = "astartes_category")
    @Enumerated(EnumType.STRING)
    private AstartesCategory category;

    @Column(name = "weapon_type")
    @Enumerated(EnumType.STRING)
    private Weapon weaponType;

    @Column(name = "melee_weapon")
    @Enumerated(EnumType.STRING)
    private MeleeWeapon meleeWeapon;

    @ManyToOne
    @JoinColumn(name = "starship_id")
    private StarShip starShip;
}
