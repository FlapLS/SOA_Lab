package com.example.spacemarineservice.service;


import com.example.spacemarineservice.models.StarShipDto;
import com.example.spacemarineservice.models.StarShipRequest;

import java.util.List;

public interface StarshipService {

    void createStarship(StarShipRequest request);

    List<StarShipDto> getAllStarships();

    void addMarineToStarship(Long spaceMarineId, Long starShipId);

    void cleanStarship(Long starShipId);

}
