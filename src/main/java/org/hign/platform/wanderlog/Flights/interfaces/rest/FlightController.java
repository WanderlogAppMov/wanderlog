package org.hign.platform.wanderlog.Flights.interfaces.rest;

import org.hign.platform.wanderlog.Flights.application.commandServices.AddFlightCommandService;
import org.hign.platform.wanderlog.Flights.application.queryServices.GetFlightsQueryService;
import org.hign.platform.wanderlog.Flights.domain.model.aggregates.Flight;
import org.hign.platform.wanderlog.Flights.domain.model.commands.AddFlightCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private AddFlightCommandService addFlightCommandService;

    @Autowired
    private GetFlightsQueryService getFlightsQueryService;

    @GetMapping
    public List<Flight> getAllFlights() {
        return getFlightsQueryService.getAllFlights();
    }

    @GetMapping("/departure/{departureCountry}")
    public List<Flight> getFlightsByDepartureCountry(@PathVariable String departureCountry) {
        return getFlightsQueryService.getFlightsByDepartureCountry(departureCountry);
    }

    @GetMapping("/arrival/{arrivalCountry}")
    public List<Flight> getFlightsByArrivalCountry(@PathVariable String arrivalCountry) {
        return getFlightsQueryService.getFlightsByArrivalCountry(arrivalCountry);
    }

    // Nuevo GET para vuelos por continentId
    @GetMapping("/continent/{continentId}")
    public List<Flight> getFlightsByContinentId(@PathVariable Integer continentId) {
        return getFlightsQueryService.getFlightsByContinentId(continentId);
    }

    @PostMapping
    public Flight addFlight(@RequestBody AddFlightCommand command) {
        return addFlightCommandService.addFlight(command.getAirline(), command.getDepartureCountry(),
                command.getArrivalCountry(), command.getPrice(), command.getContinentId(), command.getImageUrl());
    }

    @PutMapping("/{flightId}")
    public Flight updateFlight(@PathVariable Integer flightId, @RequestBody AddFlightCommand command) {
        return addFlightCommandService.updateFlight(flightId, command.getAirline(), command.getDepartureCountry(),
                command.getArrivalCountry(), command.getPrice(), command.getContinentId(), command.getImageUrl());
    }

    @DeleteMapping("/{flightId}")
    public String deleteFlight(@PathVariable Integer flightId) {
        addFlightCommandService.deleteFlight(flightId);
        return "Flight deleted successfully";
    }
}
