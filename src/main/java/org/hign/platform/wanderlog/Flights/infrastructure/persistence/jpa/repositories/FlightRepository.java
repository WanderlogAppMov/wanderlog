package org.hign.platform.wanderlog.Flights.infrastructure.persistence.jpa.repositories;

import org.hign.platform.wanderlog.Flights.domain.model.aggregates.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    // Búsqueda por país de salida
    List<Flight> findByDepartureCountry(String departureCountry);

    // Búsqueda por país de llegada
    List<Flight> findByArrivalCountry(String arrivalCountry);
}
