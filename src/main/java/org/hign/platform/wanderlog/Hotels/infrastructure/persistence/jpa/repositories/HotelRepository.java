package org.hign.platform.wanderlog.Hotels.infrastructure.persistence.jpa.repositories;

import org.hign.platform.wanderlog.Hotels.domain.model.aggregates.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    // Búsqueda por ID de continente
    List<Hotel> findByContinentContinentID(Integer continentId);

    // Búsqueda por nombre de continente
    List<Hotel> findByContinentContinentName(String continentName);
}