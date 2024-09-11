package org.hign.platform.wanderlog.PlannedTrips.infrastructure.persistence.jpa.repositories;

import org.hign.platform.wanderlog.PlannedTrips.domain.model.aggregates.PlannedTrips;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlannedTripsRepository extends JpaRepository<PlannedTrips, Integer> {
}
