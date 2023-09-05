package com.example.spacemarineservice.domain;

import com.example.spacemarineservice.models.enums.MeleeWeapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpaceMarineRepository extends JpaRepository<SpaceMarine, Long>, JpaSpecificationExecutor<SpaceMarine> {

    List<SpaceMarine> findSpaceMarinesByMeleeWeapon(MeleeWeapon meleeWeapon);


}
