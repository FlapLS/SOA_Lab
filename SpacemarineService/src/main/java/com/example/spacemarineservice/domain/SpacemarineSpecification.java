package com.example.spacemarineservice.domain;

import com.example.spacemarineservice.models.SpaceMarineFilterRequest;
import com.example.spacemarineservice.models.enums.AstartesCategory;
import com.example.spacemarineservice.models.enums.MeleeWeapon;
import com.example.spacemarineservice.models.enums.Weapon;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(staticName = "of")
public class SpacemarineSpecification implements Specification<SpaceMarine> {

    private final SpaceMarineFilterRequest filter;

    @Override
    public Predicate toPredicate(Root<SpaceMarine> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (!ObjectUtils.isEmpty(filter.getName())) {
            addOptionalFilterLike(filter.getName(), root.get(SpaceMarine_.name), predicates, criteriaBuilder);
        }
        if (!ObjectUtils.isEmpty(filter.getCoordinates())) {
            if (filter.getCoordinates().getX() != null) {
                predicates.add(root.get(SpaceMarine_.coordinateX).in(filter.getCoordinates().getX()));
            }
            if (filter.getCoordinates().getY() != null) {
                predicates.add(root.get(SpaceMarine_.coordinateY).in(filter.getCoordinates().getY()));
            }
        }
        if (!ObjectUtils.isEmpty(filter.getCreationDate())) {
            predicates.add(criteriaBuilder.equal(root.get(SpaceMarine_.creationDate), criteriaBuilder.parameter(ZonedDateTime.class, filter.getCreationDate().toString())));
        }
        if (!ObjectUtils.isEmpty(filter.getHealth())) {
            predicates.add(root.get(SpaceMarine_.health).in(filter.getHealth()));
        }
        if (!ObjectUtils.isEmpty(filter.getCategory())) {
            predicates.add(root.get(SpaceMarine_.category).in(AstartesCategory.valueOf(filter.getCategory())));
        }
        if (!ObjectUtils.isEmpty(filter.getWeaponType())) {
            predicates.add(root.get(SpaceMarine_.weaponType).in(Weapon.valueOf(filter.getWeaponType())));
        }
        if (!ObjectUtils.isEmpty(filter.getMeleeWeapon())) {
            predicates.add(root.get(SpaceMarine_.meleeWeapon).in(MeleeWeapon.valueOf(filter.getMeleeWeapon())));
        }

        Predicate[] predicateArray = predicates.toArray(new Predicate[0]);
        return criteriaBuilder.and(predicateArray);
    }

    private void addOptionalFilterLike(String value, Path<String> rootValue, List<Predicate> predicates,
                                       CriteriaBuilder builder) {
        Optional.ofNullable(value).ifPresent(it -> {
            String alias = ("%" + value + "%").toUpperCase();
            predicates.add(builder.like(builder.upper(rootValue), alias));
        });
    }

}
