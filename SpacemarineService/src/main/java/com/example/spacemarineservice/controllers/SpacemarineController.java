package com.example.spacemarineservice.controllers;

import com.example.spacemarineservice.common.Endpoints;
import com.example.spacemarineservice.models.SpaceMarineCreateRequest;
import com.example.spacemarineservice.models.SpaceMarineDto;
import com.example.spacemarineservice.models.SpaceMarineFilterRequest;
import com.example.spacemarineservice.models.SpaceMarineResponse;
import com.example.spacemarineservice.models.SpaceMarineUpdateRequest;
import com.example.spacemarineservice.service.SpacemarineService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
public class SpacemarineController {

    private final SpacemarineService spacemarineService;

    @PostMapping(Endpoints.BasicOperationSpaceMarines.SPACE_MARINE_SEARCH)
    public ResponseEntity<SpaceMarineResponse> filterSpacemarines(@RequestBody SpaceMarineFilterRequest request) {
        return ResponseEntity.ok(spacemarineService.filterSpacemarine(request));
    }

    @GetMapping(Endpoints.BasicOperationSpaceMarines.SPACE_MARINE_GET)
    public ResponseEntity<SpaceMarineDto> getSpacemarine(@PathVariable Long id) {
        return ResponseEntity.ok(spacemarineService.getSpacemarine(id));
    }

    @PostMapping(Endpoints.BasicOperationSpaceMarines.SPACE_MARINE_CREATE)
    public ResponseEntity<Object> createSpaceMarine(@RequestBody SpaceMarineCreateRequest request) {
        spacemarineService.createSpacemarine(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(Endpoints.BasicOperationSpaceMarines.SPACE_MARINE_DELETE)
    public ResponseEntity<Object> deleteSpaceMarine(@PathVariable Long id) {
        spacemarineService.deleteSpacemarine(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(Endpoints.BasicOperationSpaceMarines.SPACE_MARINE_UPDATE)
    public ResponseEntity<Object> updateSpaceMarine(@PathVariable Long id, @RequestBody SpaceMarineUpdateRequest request) {
        spacemarineService.updateSpacemarine(request, id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(Endpoints.BasicOperationSpaceMarines.SPACE_MARINE_ALL)
    public ResponseEntity<List<SpaceMarineDto>> getAllSpacemarines() {
        return ResponseEntity.ok(spacemarineService.findAllSpacemarine());
    }

}