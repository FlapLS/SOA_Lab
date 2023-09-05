package com.example.gatewaystarship.application.starship.web;

import com.example.gatewaystarship.application.common.Endpoints;
import com.example.gatewaystarship.application.starship.models.StarShipDto;
import com.example.gatewaystarship.application.starship.models.StarShipRequest;
import com.example.gatewaystarship.integration.SpaceMarineService;
import com.example.gatewaystarship.log.Logger;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StarshipController {

    private final Logger logger;

    private final SpaceMarineService spaceMarineService;

    @PostMapping(Endpoints.StarShip.STARSHIP_CREATE)
    public ResponseEntity<Object> createStarship(@RequestBody StarShipRequest request) {
        logger.info("createSpacemarine", request);
        spaceMarineService.createStarship(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping(Endpoints.StarShip.STARSHIP_GET_ALL)
    public ResponseEntity<List<StarShipDto>> getAllStarships() {
        logger.info("getAllStarships", "");
        return ResponseEntity.ok(spaceMarineService.getAllStarships());
    }

    @PutMapping(Endpoints.StarShip.JOIN_STARSHIP)
    public ResponseEntity<Object> loadStarship(@PathVariable Long starshipId, @PathVariable Long spaceMarineId) {
        logger.info("loadStarship", List.of(starshipId, spaceMarineId));
        spaceMarineService.loadStarship(spaceMarineId, starshipId);
        return ResponseEntity.ok().build();
    }

    @PutMapping(Endpoints.StarShip.UNLOAD_ALL_STARSHIP)
    public ResponseEntity<Object> unloadStarship(@PathVariable Long starshipId) {
        logger.info("unloadStarship", starshipId);
        spaceMarineService.unloadStarship(starshipId);
        return ResponseEntity.ok().build();
    }

}
