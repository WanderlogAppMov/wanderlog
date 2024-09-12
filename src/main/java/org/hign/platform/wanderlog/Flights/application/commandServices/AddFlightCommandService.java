package org.hign.platform.wanderlog.Flights.application.commandServices;


import org.hign.platform.wanderlog.Flights.domain.model.aggregates.Flight;
import org.hign.platform.wanderlog.Flights.infrastructure.persistence.jpa.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AddFlightCommandService {

    @Autowired
    private FlightRepository flightRepository;

    public Flight addFlight(String airline, String departureCountry, String arrivalCountry, BigDecimal price) {
        Flight flight = new Flight();
        flight.setAirline(airline);
        flight.setDepartureCountry(departureCountry);
        flight.setArrivalCountry(arrivalCountry);
        flight.setPrice(price);
        return flightRepository.save(flight);
    }

    // Método para actualizar un vuelo
    public Flight updateFlight(Integer flightId, String airline, String departureCountry, String arrivalCountry, BigDecimal price) {
        return flightRepository.findById(flightId).map(flight -> {
            flight.setAirline(airline);
            flight.setDepartureCountry(departureCountry);
            flight.setArrivalCountry(arrivalCountry);
            flight.setPrice(price);
            return flightRepository.save(flight);
        }).orElseThrow(() -> new IllegalArgumentException("Flight not found"));
    }

    // Método para eliminar un vuelo
    public void deleteFlight(Integer flightId) {
        if (flightRepository.existsById(flightId)) {
            flightRepository.deleteById(flightId);
        } else {
            throw new IllegalArgumentException("Flight not found");
        }
    }
}
