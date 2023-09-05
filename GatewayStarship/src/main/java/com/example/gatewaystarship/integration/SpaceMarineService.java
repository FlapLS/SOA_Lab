package com.example.gatewaystarship.integration;

import com.example.gatewaystarship.application.common.Endpoints;
import com.example.gatewaystarship.application.starship.models.SpaceMarineCreateRequest;
import com.example.gatewaystarship.application.starship.models.SpaceMarineDto;
import com.example.gatewaystarship.application.starship.models.SpaceMarineFilterRequest;
import com.example.gatewaystarship.application.starship.models.SpaceMarineResponse;
import com.example.gatewaystarship.application.starship.models.SpaceMarineUpdateRequest;
import com.example.gatewaystarship.application.starship.models.StarShipDto;
import com.example.gatewaystarship.application.starship.models.StarShipRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "space-marine-service", url = "${service.space-marine-service.url}")
public interface SpaceMarineService {

    @GetMapping(Endpoints.ExtraOperationSpaceMarines.SPACE_MARINE_BY_WEAPON_TYPE)
    SpaceMarineDto getMinimalWeapon();

    @GetMapping(Endpoints.ExtraOperationSpaceMarines.SPACE_MARINE_BY_WEAPON_TYPE_MORE)
    List<SpaceMarineDto> weaponMore(@RequestParam String weapon);

    @GetMapping(Endpoints.ExtraOperationSpaceMarines.SPACE_MARINE_BY_WEAPON_TYPE_LESS)
    List<SpaceMarineDto> weaponLess(@RequestParam String weapon);

    @PostMapping(Endpoints.BasicOperationSpaceMarines.SPACE_MARINE_SEARCH)
    SpaceMarineResponse filterSpaceMarines(@RequestBody SpaceMarineFilterRequest request);

    @GetMapping(Endpoints.BasicOperationSpaceMarines.SPACE_MARINE_GET)
    SpaceMarineDto getSpaceMarine(@PathVariable Long id);

    @PostMapping(Endpoints.BasicOperationSpaceMarines.SPACE_MARINE_CREATE)
    void createSpaceMarine(@RequestBody SpaceMarineCreateRequest request);

    @DeleteMapping(Endpoints.BasicOperationSpaceMarines.SPACE_MARINE_DELETE)
    void deleteSpaceMarine(@PathVariable Long id);

    @PutMapping(Endpoints.BasicOperationSpaceMarines.SPACE_MARINE_UPDATE)
    void updateSpaceMarine(@PathVariable Long id, @RequestBody SpaceMarineUpdateRequest request);

    @GetMapping(Endpoints.BasicOperationSpaceMarines.SPACE_MARINE_ALL)
    List<SpaceMarineDto> getAllSpaceMarines();

    @PostMapping(Endpoints.StarShip.STARSHIP_CREATE)
    void createStarship(@RequestBody StarShipRequest request);

    @GetMapping(Endpoints.StarShip.STARSHIP_GET_ALL)
    List<StarShipDto> getAllStarships();

    @PutMapping(Endpoints.StarShip.JOIN_STARSHIP)
    void loadStarship(@PathVariable Long starshipId, @PathVariable Long spaceMarineId);

    @PutMapping(Endpoints.StarShip.UNLOAD_ALL_STARSHIP)
    void unloadStarship(@PathVariable Long starshipId);

}
