package org.hign.platform.wanderlog.Attractions.infrastructure.persistence.jpa.repositories;

import org.hign.platform.wanderlog.Attractions.domain.model.aggregates.Attractions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttractionsRepository extends JpaRepository<Attractions, Integer> {
    // Obtener atracciones por ContinentID
    List<Attractions> findByContinent_ContinentID(Integer continentId);

    // Búsqueda por ciudad
    List<Attractions> findByCity(String city);

    // Búsqueda por país
    List<Attractions> findByCountry(String country);
}
