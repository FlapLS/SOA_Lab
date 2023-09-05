package com.example.gatewaystarship.application.starship.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class PageDto {

    private Integer page;

    private Integer limit;

}
