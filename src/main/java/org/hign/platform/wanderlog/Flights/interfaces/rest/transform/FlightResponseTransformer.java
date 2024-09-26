package org.hign.platform.wanderlog.Flights.interfaces.rest.transform;

import org.hign.platform.wanderlog.Flights.domain.model.aggregates.Flight;
import org.hign.platform.wanderlog.Flights.interfaces.rest.resources.FlightResponse;

public class FlightResponseTransformer {

    public static FlightResponse transform(Flight flight) {
        FlightResponse response = new FlightResponse();
        response.setFlightId(flight.getFlightId());
        response.setAirline(flight.getAirline());
        response.setDepartureCountry(flight.getDepartureCountry());
        response.setArrivalCountry(flight.getArrivalCountry());
        response.setPrice(flight.getPrice());

        // Incluir información del continente
        if (flight.getContinent() != null) {
            response.setContinentId(flight.getContinent().getContinentID());
            response.setContinentName(flight.getContinent().getContinentName());
        }

        return response;
    }
}
