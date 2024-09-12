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
        List<Flight> flights = getFlightsQueryService.getAllFlights();
        return flights.stream().map(FlightResponseTransformer::transform).collect(Collectors.toList());
    }

    @GetMapping("/departure/{departureCountry}")
    public List<FlightResponse> getFlightsByDepartureCountry(@PathVariable String departureCountry) {
        List<Flight> flights = getFlightsQueryService.getFlightsByDepartureCountry(departureCountry);
        return flights.stream().map(FlightResponseTransformer::transform).collect(Collectors.toList());
    }

    @GetMapping("/arrival/{arrivalCountry}")
    public List<FlightResponse> getFlightsByArrivalCountry(@PathVariable String arrivalCountry) {
        List<Flight> flights = getFlightsQueryService.getFlightsByArrivalCountry(arrivalCountry);
        return flights.stream().map(FlightResponseTransformer::transform).collect(Collectors.toList());
    }

    @PostMapping
    public FlightResponse addFlight(@RequestBody AddFlightCommand command) {
        Flight flight = addFlightCommandService.addFlight(command.getAirline(), command.getDepartureCountry(), command.getArrivalCountry(), command.getPrice());
        return FlightResponseTransformer.transform(flight);
    }

    @PutMapping("/{flightId}")
    public FlightResponse updateFlight(@PathVariable Integer flightId, @RequestBody AddFlightCommand command) {
        Flight flight = addFlightCommandService.updateFlight(flightId, command.getAirline(), command.getDepartureCountry(), command.getArrivalCountry(), command.getPrice());
        return FlightResponseTransformer.transform(flight);
    }

    @DeleteMapping("/{flightId}")
    public String deleteFlight(@PathVariable Integer flightId) {
        addFlightCommandService.deleteFlight(flightId);
        return "Flight deleted successfully";
    }
}