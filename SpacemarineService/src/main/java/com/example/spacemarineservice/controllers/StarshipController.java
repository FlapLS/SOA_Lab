package com.example.spacemarineservice.controllers;

import com.example.spacemarineservice.common.Endpoints;
import com.example.spacemarineservice.models.StarShipDto;
import com.example.spacemarineservice.models.StarShipRequest;
import com.example.spacemarineservice.service.StarshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StarshipController {

    private final StarshipService starshipService;

    @PostMapping(Endpoints.StarShip.STARSHIP_CREATE)
    public ResponseEntity<Object> createSpacemarine(@RequestBody StarShipRequest request) {
        starshipService.createStarship(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping(Endpoints.StarShip.STARSHIP_GET_ALL)
    public ResponseEntity<List<StarShipDto>> getAllStarships() {
        return ResponseEntity.ok(starshipService.getAllStarships());
    }

    @PutMapping(Endpoints.StarShip.JOIN_STARSHIP)
    public ResponseEntity<Object> loadStarship(@PathVariable Long starshipId, @PathVariable Long spaceMarineId) {
        starshipService.addMarineToStarship(spaceMarineId, starshipId);
        return ResponseEntity.ok().build();
    }

    @PutMapping(Endpoints.StarShip.UNLOAD_ALL_STARSHIP)
    public ResponseEntity<Object> unloadStarship(@PathVariable Long starshipId) {
        starshipService.cleanStarship(starshipId);
        return ResponseEntity.ok().build();
    }

}