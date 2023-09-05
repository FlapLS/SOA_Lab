package com.example.spacemarineservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class StarShipRequest {

    private String name;

    private String fleet;

    private Coordinates coordinates;

}
