package org.hign.platform.wanderlog.Hotels.infrastructure.persistence.jpa.repositories;

import org.hign.platform.wanderlog.Hotels.domain.model.aggregates.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    List<Hotel> findByContinent_ContinentID(Integer continentID);

    // Búsqueda por ciudad
    List<Hotel> findByCity(String city);

    // Búsqueda por país
    List<Hotel> findByCountry(String country);
}

