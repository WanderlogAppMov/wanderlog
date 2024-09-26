package org.hign.platform.wanderlog.Flights.application.queryServices;

import org.hign.platform.wanderlog.Flights.domain.model.aggregates.Flight;
import org.hign.platform.wanderlog.Flights.infrastructure.persistence.jpa.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetFlightsQueryService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public List<Flight> getFlightsByDepartureCountry(String departureCountry) {
        return flightRepository.findByDepartureCountry(departureCountry);
    }

    public List<Flight> getFlightsByArrivalCountry(String arrivalCountry) {
        return flightRepository.findByArrivalCountry(arrivalCountry);
    }

    // Nuevo método para obtener vuelos por continentId
    public List<Flight> getFlightsByContinentId(Integer continentId) {
        return flightRepository.findByContinent_ContinentID(continentId);
    }
}