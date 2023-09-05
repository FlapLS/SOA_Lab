package com.example.spacemarineservice.models.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MeleeWeapon {

    CHAIN_AXE(1),
    MANREAPER(2),
    LIGHTING_CLAW(3),
    POWER_FIST(4);

    private final int level;

}
