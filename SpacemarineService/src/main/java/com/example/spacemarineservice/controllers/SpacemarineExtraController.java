package com.example.spacemarineservice.controllers;

import com.example.spacemarineservice.common.Endpoints;
import com.example.spacemarineservice.models.SpaceMarineDto;
import com.example.spacemarineservice.service.SpacemarineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SpacemarineExtraController {

    private final SpacemarineService spacemarineService;

    @GetMapping(Endpoints.ExtraOperationSpaceMarines.SPACE_MARINE_BY_WEAPON_TYPE)
    public ResponseEntity<SpaceMarineDto> getMinimalWeapon() {
        return ResponseEntity.ok(spacemarineService.getSpacemarineWithMinimalWeapon());
    }

    @GetMapping(Endpoints.ExtraOperationSpaceMarines.SPACE_MARINE_BY_WEAPON_TYPE_MORE)
    public ResponseEntity<List<SpaceMarineDto>> weaponMore(@RequestParam String weapon) {
        return ResponseEntity.ok(spacemarineService.findSpacemarineWithWeapon(weapon, true));
    }

    @GetMapping(Endpoints.ExtraOperationSpaceMarines.SPACE_MARINE_BY_WEAPON_TYPE_LESS)
    public ResponseEntity<List<SpaceMarineDto>> weaponLess(@RequestParam String weapon) {
        return ResponseEntity.ok(spacemarineService.findSpacemarineWithWeapon(weapon, false));
    }

}