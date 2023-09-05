package com.example.gatewaystarship.application.starship.web;

import com.example.gatewaystarship.application.common.Endpoints;
import com.example.gatewaystarship.application.starship.models.SpaceMarineDto;
import com.example.gatewaystarship.integration.SpaceMarineService;
import com.example.gatewaystarship.log.Logger;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SpaceMarineExtraController {

    private final Logger logger;

    private final SpaceMarineService spaceMarineService;

    @GetMapping(Endpoints.ExtraOperationSpaceMarines.SPACE_MARINE_BY_WEAPON_TYPE)
    public ResponseEntity<SpaceMarineDto> getMinimalWeapon() {
        logger.info("getMinimalWeapon", "");
        return ResponseEntity.ok(spaceMarineService.getMinimalWeapon());
    }

    @GetMapping(Endpoints.ExtraOperationSpaceMarines.SPACE_MARINE_BY_WEAPON_TYPE_MORE)
    public ResponseEntity<List<SpaceMarineDto>> weaponMore(@RequestParam String weapon) {
        logger.info("weaponMore", weapon);
        return ResponseEntity.ok(spaceMarineService.weaponMore(weapon));
    }

    @GetMapping(Endpoints.ExtraOperationSpaceMarines.SPACE_MARINE_BY_WEAPON_TYPE_LESS)
    public ResponseEntity<List<SpaceMarineDto>> weaponLess(@RequestParam String weapon) {
        logger.info("weaponLess", weapon);
        return ResponseEntity.ok(spaceMarineService.weaponLess(weapon));
    }

}