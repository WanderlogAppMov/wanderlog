package org.hign.platform.wanderlog.Travelers.domain.services;

import org.hign.platform.wanderlog.Travelers.domain.model.aggregates.Travelers;

import java.util.Optional;

public interface TravelerQueryService {
    Optional<Travelers> findById(Integer id);

    Optional<Travelers> findByUserId(Integer userId);
}
