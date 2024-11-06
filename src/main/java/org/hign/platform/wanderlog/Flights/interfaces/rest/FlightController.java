package org.hign.platform.wanderlog.Flights.interfaces.rest;

import org.hign.platform.wanderlog.Flights.application.commandServices.AddFlightCommandService;
import org.hign.platform.wanderlog.Flights.application.queryServices.GetFlightsQueryService;
import org.hign.platform.wanderlog.Flights.domain.model.aggregates.Flight;
import org.hign.platform.wanderlog.Flights.domain.model.commands.AddFlightCommand;
import org.hign.platform.wanderlog.Flights.interfaces.rest.resources.FlightResponse;
import org.hign.platform.wanderlog.Flights.interfaces.rest.transform.FlightResponseTransformer;
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
    public List<FlightResponse> getAllFlights() {
        return getFlightsQueryService.getAllFlights()
                .stream()
                .map(FlightResponseTransformer::transform)
                .collect(Collectors.toList());
    }

    @GetMapping("/departure/{departureCountry}")
    public List<FlightResponse> getFlightsByDepartureCountry(@PathVariable String departureCountry) {
        return getFlightsQueryService.getFlightsByDepartureCountry(departureCountry)
                .stream()
                .map(FlightResponseTransformer::transform)
                .collect(Collectors.toList());
    }

    @GetMapping("/arrival/{arrivalCountry}")
    public List<FlightResponse> getFlightsByArrivalCountry(@PathVariable String arrivalCountry) {
        return getFlightsQueryService.getFlightsByArrivalCountry(arrivalCountry)
                .stream()
                .map(FlightResponseTransformer::transform)
                .collect(Collectors.toList());
    }

    // Nuevo GET para vuelos por continentId
    @GetMapping("/continent/{continentId}")
    public List<FlightResponse> getFlightsByContinentId(@PathVariable Integer continentId) {
        List<Flight> flights = getFlightsQueryService.getFlightsByContinentId(continentId);
        return flights.stream().map(FlightResponseTransformer::transform).collect(Collectors.toList());
    }

    @PostMapping
    public FlightResponse addFlight(@RequestBody AddFlightCommand command) {
        // Agregar el campo imageUrl en la llamada a addFlight
        Flight flight = addFlightCommandService.addFlight(command.getAirline(), command.getDepartureCountry(),
                command.getArrivalCountry(), command.getPrice(), command.getContinentId(), command.getImageUrl());
        return FlightResponseTransformer.transform(flight);
    }

    @PutMapping("/{flightId}")
    public FlightResponse updateFlight(@PathVariable Integer flightId, @RequestBody AddFlightCommand command) {
        // Agregar el campo imageUrl en la llamada a updateFlight
        Flight flight = addFlightCommandService.updateFlight(flightId, command.getAirline(), command.getDepartureCountry(),
                command.getArrivalCountry(), command.getPrice(), command.getContinentId(), command.getImageUrl());
        return FlightResponseTransformer.transform(flight);
    }

    @DeleteMapping("/{flightId}")
    public String deleteFlight(@PathVariable Integer flightId) {
        addFlightCommandService.deleteFlight(flightId);
        return "Flight deleted successfully";
    }
}
