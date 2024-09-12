package org.hign.platform.wanderlog.Continents.infrastructure.persistence.jpa.repositories;

import org.hign.platform.wanderlog.Continents.domain.model.aggregates.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Integer> {
}
