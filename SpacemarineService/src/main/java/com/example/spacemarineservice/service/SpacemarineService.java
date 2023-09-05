package com.example.spacemarineservice.service;


import com.example.spacemarineservice.models.SpaceMarineCreateRequest;
import com.example.spacemarineservice.models.SpaceMarineDto;
import com.example.spacemarineservice.models.SpaceMarineFilterRequest;
import com.example.spacemarineservice.models.SpaceMarineResponse;
import com.example.spacemarineservice.models.SpaceMarineUpdateRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SpacemarineService {

    void createSpacemarine(SpaceMarineCreateRequest request);

    void updateSpacemarine(SpaceMarineUpdateRequest request, Long id);

    SpaceMarineDto getSpacemarine(Long id);

    void deleteSpacemarine(Long id);

    SpaceMarineResponse filterSpacemarine(SpaceMarineFilterRequest labFilterRequest);

    List<SpaceMarineDto> findAllSpacemarine();

    SpaceMarineDto getSpacemarineWithMinimalWeapon();

    List<SpaceMarineDto> findSpacemarineWithWeapon(String weaponType, Boolean isGreater);

}
