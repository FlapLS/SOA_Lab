package com.example.spacemarineservice.service.impl;

import com.example.spacemarineservice.domain.SpaceMarine;
import com.example.spacemarineservice.domain.SpaceMarineRepository;
import com.example.spacemarineservice.domain.SpacemarineSpecification;
import com.example.spacemarineservice.domain.StarShip;
import com.example.spacemarineservice.domain.StarshipRepository;
import com.example.spacemarineservice.error.ErrorDescriptions;
import com.example.spacemarineservice.models.SpaceMarineCreateRequest;
import com.example.spacemarineservice.models.SpaceMarineDto;
import com.example.spacemarineservice.models.SpaceMarineFilterRequest;
import com.example.spacemarineservice.models.SpaceMarineResponse;
import com.example.spacemarineservice.models.SpaceMarineUpdateRequest;
import com.example.spacemarineservice.models.enums.AstartesCategory;
import com.example.spacemarineservice.models.enums.MeleeWeapon;
import com.example.spacemarineservice.models.enums.Weapon;
import com.example.spacemarineservice.service.SpacemarineService;
import com.example.spacemarineservice.utils.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpacemarineServiceImpl implements SpacemarineService {

    private final SpaceMarineRepository spaceMarineRepository;
    private final StarshipRepository starshipRepository;
    private final ModelMapper mapper;

    @Override
    public void createSpacemarine(SpaceMarineCreateRequest request) {
        SpaceMarine spaceMarine = new SpaceMarine();
        spaceMarine.setName(request.getName());
        spaceMarine.setCoordinateX(request.getCoordinates().getX());
        spaceMarine.setCoordinateY(request.getCoordinates().getY());
        spaceMarine.setCategory(AstartesCategory.valueOf(request.getCategory()));
        spaceMarine.setMeleeWeapon(MeleeWeapon.valueOf(request.getMeleeWeapon()));
        spaceMarine.setWeaponType(Weapon.valueOf(request.getWeaponType()));
        spaceMarine.setHealth(request.getHealth());
        spaceMarine.setCreationDate(ZonedDateTime.now());
        spaceMarineRepository.save(spaceMarine);
    }

    @Override
    public void updateSpacemarine(SpaceMarineUpdateRequest request, Long id) {
        SpaceMarine spaceMarine = spaceMarineRepository.findById(id).orElseThrow(ErrorDescriptions.NOT_FOUND::exception);
        spaceMarine.setName(request.getName());
        spaceMarine.setCoordinateX(request.getCoordinates().getX());
        spaceMarine.setCoordinateY(request.getCoordinates().getY());
        spaceMarine.setCategory(AstartesCategory.valueOf(request.getCategory()));
        spaceMarine.setMeleeWeapon(MeleeWeapon.valueOf(request.getMeleeWeapon()));
        spaceMarine.setWeaponType(Weapon.valueOf(request.getWeaponType()));
        spaceMarine.setHealth(request.getHealth());

        if (!ObjectUtils.isEmpty(request.getStarShipId())) {
            StarShip starShip = starshipRepository.findById(request.getStarShipId()).orElseThrow(ErrorDescriptions.NOT_FOUND::exception);
            spaceMarine.setStarShip(starShip);
        }

        spaceMarineRepository.save(spaceMarine);
    }

    @Override
    public SpaceMarineDto getSpacemarine(Long id) {
        return mapper.map(spaceMarineRepository.findById(id).orElseThrow(ErrorDescriptions.NOT_FOUND::exception));
    }

    @Override
    public void deleteSpacemarine(Long id) {
        SpaceMarine spaceMarine = spaceMarineRepository.findById(id).orElseThrow(ErrorDescriptions.NOT_FOUND::exception);
        spaceMarineRepository.delete(spaceMarine);
    }

    @Override
    public SpaceMarineResponse filterSpacemarine(SpaceMarineFilterRequest request) {
        Sort.Order order = !ObjectUtils.isEmpty(request.getSortBy()) ?
                request.getOrder().equals("DESC")
                        ? Sort.Order.desc(request.getSortBy())
                        : Sort.Order.asc(request.getSortBy())
                : request.getOrder().equals("DESC") ? Sort.Order.desc("id") : Sort.Order.asc("id");
        PageRequest pageable = PageRequest.of(request.getPage() - 1, request.getLimit(),
                Sort.by(order));
        SpacemarineSpecification specification = SpacemarineSpecification.of(request);
        Page<SpaceMarine> entities = spaceMarineRepository
                .findAll(specification, pageable);

        SpaceMarineResponse response = new SpaceMarineResponse();
        response.setItems(entities.getContent().stream().map(mapper::map).toList());
        response.setPageNumber(entities.getTotalPages());
        return response;
    }

    @Override
    public List<SpaceMarineDto> findAllSpacemarine() {
        return spaceMarineRepository.findAll()
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public SpaceMarineDto getSpacemarineWithMinimalWeapon() {
        List<SpaceMarineDto> dtos = spaceMarineRepository.findSpaceMarinesByMeleeWeapon(MeleeWeapon.CHAIN_AXE)
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());
        if (dtos.isEmpty()) {
            ErrorDescriptions.NOT_FOUND.applicationError();
        }
        return dtos.get(0);
    }

    @Override
    public List<SpaceMarineDto> findSpacemarineWithWeapon(String weaponType, Boolean isGreater) {
        MeleeWeapon weapon = MeleeWeapon.valueOf(weaponType);
        int level = weapon.getLevel();
        List<SpaceMarineDto> answer = new ArrayList<>();

        if (isGreater) {
            if (level < 4) answer.addAll(spaceMarineRepository.findSpaceMarinesByMeleeWeapon(MeleeWeapon.POWER_FIST)
                    .stream()
                    .map(mapper::map)
                    .collect(Collectors.toList()));
            if (level < 3) answer.addAll(spaceMarineRepository.findSpaceMarinesByMeleeWeapon(MeleeWeapon.LIGHTING_CLAW)
                    .stream()
                    .map(mapper::map)
                    .collect(Collectors.toList()));
            if (level < 2) answer.addAll(spaceMarineRepository.findSpaceMarinesByMeleeWeapon(MeleeWeapon.MANREAPER)
                    .stream()
                    .map(mapper::map)
                    .collect(Collectors.toList()));
        } else {
            if (level > 1) answer.addAll(spaceMarineRepository.findSpaceMarinesByMeleeWeapon(MeleeWeapon.CHAIN_AXE)
                    .stream()
                    .map(mapper::map)
                    .collect(Collectors.toList()));
            if (level > 2) answer.addAll(spaceMarineRepository.findSpaceMarinesByMeleeWeapon(MeleeWeapon.MANREAPER)
                    .stream()
                    .map(mapper::map)
                    .collect(Collectors.toList()));
            if (level > 3) answer.addAll(spaceMarineRepository.findSpaceMarinesByMeleeWeapon(MeleeWeapon.LIGHTING_CLAW)
                    .stream()
                    .map(mapper::map)
                    .collect(Collectors.toList()));
        }
        return answer;
    }
}
