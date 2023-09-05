package com.example.spacemarineservice.service.impl;

import com.example.spacemarineservice.domain.SpaceMarine;
import com.example.spacemarineservice.domain.SpaceMarineRepository;
import com.example.spacemarineservice.domain.StarShip;
import com.example.spacemarineservice.domain.StarshipRepository;
import com.example.spacemarineservice.error.ErrorDescriptions;
import com.example.spacemarineservice.models.StarShipDto;
import com.example.spacemarineservice.models.StarShipRequest;
import com.example.spacemarineservice.service.StarshipService;
import com.example.spacemarineservice.utils.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StarshipServiceImpl implements StarshipService {

    private final SpaceMarineRepository spaceMarineRepository;
    private final StarshipRepository starshipRepository;
    private final ModelMapper mapper;

    @Override
    public void createStarship(StarShipRequest request) {
        StarShip starShip = new StarShip();
        starShip.setName(request.getName());
        starShip.setFleet(request.getFleet());
        starShip.setCoordinateX(request.getCoordinates().getX());
        starShip.setCoordinateY(request.getCoordinates().getY());
        starshipRepository.save(starShip);
    }

    @Override
    public List<StarShipDto> getAllStarships() {
        return starshipRepository.findAll()
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public void addMarineToStarship(Long spaceMarineId, Long starShipId) {
        SpaceMarine spaceMarine = spaceMarineRepository.findById(spaceMarineId).orElseThrow(ErrorDescriptions.NOT_FOUND::exception);

        StarShip starShip = starshipRepository.findById(starShipId).orElseThrow(ErrorDescriptions.NOT_FOUND::exception);
        spaceMarine.setStarShip(starShip);

        spaceMarineRepository.save(spaceMarine);
    }

    @Override
    @Transactional
    public void cleanStarship(Long starShipId) {
        StarShip starShip = starshipRepository.findById(starShipId).orElseThrow(ErrorDescriptions.NOT_FOUND::exception);

        for (SpaceMarine spaceMarine : starShip.getSpaceMarines()) {
            spaceMarine.setStarShip(null);
            spaceMarineRepository.save(spaceMarine);
        }
    }

}
