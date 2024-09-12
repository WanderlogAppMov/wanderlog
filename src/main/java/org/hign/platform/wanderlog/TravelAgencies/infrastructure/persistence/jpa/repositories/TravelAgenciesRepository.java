package org.hign.platform.wanderlog.TravelAgencies.infrastructure.persistence.jpa.repositories;

import org.hign.platform.wanderlog.TravelAgencies.domain.model.aggregates.TravelAgencies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelAgenciesRepository extends JpaRepository<TravelAgencies, Integer> {
}
