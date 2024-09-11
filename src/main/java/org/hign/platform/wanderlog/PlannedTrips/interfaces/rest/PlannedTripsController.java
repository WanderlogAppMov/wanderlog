package org.hign.platform.wanderlog.PlannedTrips.interfaces.rest;

import org.hign.platform.wanderlog.PlannedTrips.application.commandServices.AddPlannedTripCommandService;
import org.hign.platform.wanderlog.PlannedTrips.application.queryServices.GetPlannedTripsQueryService;
import org.hign.platform.wanderlog.PlannedTrips.domain.model.aggregates.PlannedTrips;
import org.hign.platform.wanderlog.PlannedTrips.domain.model.commands.AddPlannedTripCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plannedtrips")
public class PlannedTripsController {

    @Autowired
    private AddPlannedTripCommandService addPlannedTripCommandService;

    @Autowired
    private GetPlannedTripsQueryService getPlannedTripsQueryService;

    // GET all planned trips
    @GetMapping
    public List<PlannedTrips> getAllPlannedTrips() {
        return getPlannedTripsQueryService.getAllPlannedTrips();
    }

    // GET planned trip by ID
    @GetMapping("/{id}")
    public ResponseEntity<PlannedTrips> getPlannedTripById(@PathVariable Integer id) {
        try {
            PlannedTrips plannedTrip = getPlannedTripsQueryService.getPlannedTripById(id);
            return new ResponseEntity<>(plannedTrip, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST new planned trip
    @PostMapping
    public ResponseEntity<String> addPlannedTrip(@RequestBody AddPlannedTripCommand command) {
        try {
            addPlannedTripCommandService.addPlannedTrip(command);
            return new ResponseEntity<>("Planned trip created successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // PUT update planned trip
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlannedTrip(@PathVariable Integer id, @RequestBody AddPlannedTripCommand command) {
        try {
            addPlannedTripCommandService.updatePlannedTrip(id, command);
            return new ResponseEntity<>("Planned trip updated successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // DELETE planned trip
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlannedTrip(@PathVariable Integer id) {
        try {
            addPlannedTripCommandService.deletePlannedTrip(id);
            return new ResponseEntity<>("Planned trip deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
