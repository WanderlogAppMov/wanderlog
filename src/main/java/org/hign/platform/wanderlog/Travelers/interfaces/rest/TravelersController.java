package org.hign.platform.wanderlog.Travelers.interfaces.rest;

import org.hign.platform.wanderlog.Travelers.application.commandServices.AddTravelersCommandService;
import org.hign.platform.wanderlog.Travelers.application.queryServices.GetTravelersQueryService;
import org.hign.platform.wanderlog.Travelers.domain.model.aggregates.Travelers;
import org.hign.platform.wanderlog.Travelers.domain.model.commands.AddTravelersCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/travelers")
public class TravelersController {

    @Autowired
    private AddTravelersCommandService addTravelersCommandService;

    @Autowired
    private GetTravelersQueryService getTravelersQueryService;

    // GET all travelers
    @GetMapping
    public List<Travelers> getAllTravelers() {
        return getTravelersQueryService.getAllTravelers();
    }

    // GET traveler by ID
    @GetMapping("/{id}")
    public ResponseEntity<Travelers> getTravelerById(@PathVariable Integer id) {
        try {
            Travelers traveler = getTravelersQueryService.getTravelerById(id);
            return new ResponseEntity<>(traveler, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST new traveler
    @PostMapping
    public ResponseEntity<String> addTraveler(@RequestBody AddTravelersCommand command) {
        try {
            addTravelersCommandService.addTraveler(command);
            return new ResponseEntity<>("Traveler registered successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // PUT update traveler
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTraveler(@PathVariable Integer id, @RequestBody AddTravelersCommand command) {
        try {
            addTravelersCommandService.updateTraveler(id, command);
            return new ResponseEntity<>("Traveler updated successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // DELETE traveler
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTraveler(@PathVariable Integer id) {
        try {
            addTravelersCommandService.deleteTraveler(id);
            return new ResponseEntity<>("Traveler deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
