package org.hign.platform.wanderlog.Attractions.infrastructure.persistence.jpa.repositories;

import org.hign.platform.wanderlog.Attractions.domain.model.aggregates.Attractions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttractionsRepository extends JpaRepository<Attractions, Integer> {
}
