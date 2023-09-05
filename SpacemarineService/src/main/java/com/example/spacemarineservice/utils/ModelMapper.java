package com.example.spacemarineservice.utils;

import com.example.spacemarineservice.domain.SpaceMarine;
import com.example.spacemarineservice.domain.StarShip;
import com.example.spacemarineservice.models.Coordinates;
import com.example.spacemarineservice.models.SpaceMarineDto;
import com.example.spacemarineservice.models.StarShipDto;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;


@Component
public class ModelMapper {

    public SpaceMarineDto map(SpaceMarine spaceMarine) {
        SpaceMarineDto dto = new SpaceMarineDto();
        dto.setId(spaceMarine.getId());
        dto.setName(spaceMarine.getName());
        dto.setHealth(spaceMarine.getHealth());
        dto.setCategory(spaceMarine.getCategory());
        dto.setWeaponType(spaceMarine.getWeaponType());
        dto.setMeleeWeapon(spaceMarine.getMeleeWeapon());
        dto.setCreationDate(spaceMarine.getCreationDate());
        dto.setCoordinates(Coordinates.of(spaceMarine.getCoordinateX(), spaceMarine.getCoordinateY()));
        if (!ObjectUtils.isEmpty(spaceMarine.getStarShip()))
            dto.setStarShipId(spaceMarine.getStarShip().getId());
        return dto;
    }

    public StarShipDto map(StarShip starShip) {
        StarShipDto dto = new StarShipDto();
        dto.setId(starShip.getId());
        dto.setName(starShip.getName());
        dto.setFleet(starShip.getFleet());
        dto.setCoordinates(Coordinates.of(starShip.getCoordinateX(), starShip.getCoordinateY()));
        return dto;
    }

}
