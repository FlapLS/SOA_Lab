package com.example.spacemarineservice.common;

public interface Endpoints {

    interface BasicOperationSpaceMarines {
        String SPACE_MARINE_CREATE = "/spacemarines/create";
        String SPACE_MARINE_UPDATE = "/spacemarines/update/{id}";
        String SPACE_MARINE_GET = "/spacemarines/get/{id}";
        String SPACE_MARINE_DELETE = "/spacemarines/delete/{id}";
        String SPACE_MARINE_SEARCH = "/spacemarines/search";
        String SPACE_MARINE_ALL = "/spacemarines/all";
    }

    interface ExtraOperationSpaceMarines {
        String SPACE_MARINE_BY_WEAPON_TYPE = "/spacemarines/weapon-types/minimum";
        String SPACE_MARINE_BY_WEAPON_TYPE_MORE = "/spacemarines/weapon-types/more";
        String SPACE_MARINE_BY_WEAPON_TYPE_LESS = "/spacemarines/weapon-types/less";

    }

    interface StarShip {
        String STARSHIP_CREATE = "/starships/create";
        String STARSHIP_GET_ALL = "/starships/all";
        String JOIN_STARSHIP = "/starships/{starshipId}/enter/{spaceMarineId}";
        String UNLOAD_ALL_STARSHIP = "/starships/{starshipId}/unload-all";

    }

}
