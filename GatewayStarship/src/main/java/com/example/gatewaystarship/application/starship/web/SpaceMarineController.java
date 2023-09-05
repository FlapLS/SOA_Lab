package com.example.gatewaystarship.application.starship.web;

import com.example.gatewaystarship.application.common.Endpoints;
import com.example.gatewaystarship.application.starship.models.SpaceMarineCreateRequest;
import com.example.gatewaystarship.application.starship.models.SpaceMarineDto;
import com.example.gatewaystarship.application.starship.models.SpaceMarineFilterRequest;
import com.example.gatewaystarship.application.starship.models.SpaceMarineResponse;
import com.example.gatewaystarship.application.starship.models.SpaceMarineUpdateRequest;
import com.example.gatewaystarship.integration.SpaceMarineService;
import com.example.gatewaystarship.log.Logger;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SpaceMarineController {

    private final Logger logger;

    private final SpaceMarineService spaceMarineService;

    @PostMapping(Endpoints.BasicOperationSpaceMarines.SPACE_MARINE_SEARCH)
    public ResponseEntity<SpaceMarineResponse> filterSpaceMarines(@RequestBody SpaceMarineFilterRequest request) {
        logger.info("filterSpacemarines", request);
        return ResponseEntity.ok(spaceMarineService.filterSpaceMarines(request));
    }

    @GetMapping(Endpoints.BasicOperationSpaceMarines.SPACE_MARINE_GET)
    public ResponseEntity<SpaceMarineDto> getSpacemarine(@PathVariable Long id) {
        logger.info("getSpacemarine", id);
        return ResponseEntity.ok(spaceMarineService.getSpaceMarine(id));
    }

    @PostMapping(Endpoints.BasicOperationSpaceMarines.SPACE_MARINE_CREATE)
    public ResponseEntity<Object> createSpaceMarine(@RequestBody SpaceMarineCreateRequest request) {
        logger.info("createSpaceMarine", request);
        spaceMarineService.createSpaceMarine(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(Endpoints.BasicOperationSpaceMarines.SPACE_MARINE_DELETE)
    public ResponseEntity<Object> deleteSpaceMarine(@PathVariable Long id) {
        logger.info("deleteSpaceMarine", id);
        spaceMarineService.deleteSpaceMarine(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(Endpoints.BasicOperationSpaceMarines.SPACE_MARINE_UPDATE)
    public ResponseEntity<Object> updateSpaceMarine(@PathVariable Long id, @RequestBody SpaceMarineUpdateRequest request) {
        logger.info("updateSpaceMarine", request);
        spaceMarineService.updateSpaceMarine(id, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping(Endpoints.BasicOperationSpaceMarines.SPACE_MARINE_ALL)
    public ResponseEntity<List<SpaceMarineDto>> getAllSpaceMarines() {
        logger.info("getAllSpacemarines", "");
        return ResponseEntity.ok(spaceMarineService.getAllSpaceMarines());
    }

}