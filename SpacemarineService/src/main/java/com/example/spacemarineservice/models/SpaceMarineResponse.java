package com.example.spacemarineservice.models;

import lombok.Data;

import java.util.List;

@Data
public class SpaceMarineResponse {

    private List<SpaceMarineDto> items;

    private Integer pageNumber;

}
