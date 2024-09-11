package org.hign.platform.wanderlog.TravelPackages.infrastructure.persistence.jpa.repositories;

import org.hign.platform.wanderlog.TravelPackages.domain.model.aggregates.TravelPackages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelPackagesRepository extends JpaRepository<TravelPackages, Integer> {
}
