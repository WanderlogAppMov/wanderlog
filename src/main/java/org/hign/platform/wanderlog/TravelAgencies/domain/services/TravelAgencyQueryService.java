package org.hign.platform.wanderlog.TravelAgencies.domain.services;

import org.hign.platform.wanderlog.TravelAgencies.domain.model.aggregates.TravelAgencies;

import java.util.List;
import java.util.Optional;

public interface TravelAgencyQueryService {

    Optional<TravelAgencies> findById(Integer id);

    Optional<TravelAgencies> findByUserId(Integer userId);

    Optional<List<TravelAgencies>> findAll();
}
