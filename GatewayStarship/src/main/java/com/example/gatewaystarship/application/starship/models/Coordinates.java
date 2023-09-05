package com.example.gatewaystarship.application.starship.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Coordinates {

    private Integer x;

    private Long y;

}
