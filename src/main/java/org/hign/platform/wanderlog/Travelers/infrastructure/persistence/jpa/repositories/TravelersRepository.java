package org.hign.platform.wanderlog.Travelers.infrastructure.persistence.jpa.repositories;

import org.hign.platform.wanderlog.Travelers.domain.model.aggregates.Travelers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelersRepository extends JpaRepository<Travelers, Integer> {
    boolean existsByEmail(String email);
}