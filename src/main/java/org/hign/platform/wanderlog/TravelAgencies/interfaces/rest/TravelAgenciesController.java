package org.hign.platform.wanderlog.TravelAgencies.interfaces.rest;

import org.hign.platform.wanderlog.TravelAgencies.application.commandServices.AddTravelAgencyCommandService;
import org.hign.platform.wanderlog.TravelAgencies.application.queryServices.GetTravelAgenciesQueryService;
import org.hign.platform.wanderlog.TravelAgencies.domain.model.aggregates.TravelAgencies;
import org.hign.platform.wanderlog.TravelAgencies.domain.model.commands.AddTravelAgencyCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/travelagencies")
public class TravelAgenciesController {

    @Autowired
    private AddTravelAgencyCommandService addTravelAgencyCommandService;

    @Autowired
    private GetTravelAgenciesQueryService getTravelAgenciesQueryService;

    // GET all agencies
    @GetMapping
    public List<TravelAgencies> getAllAgencies() {
        return getTravelAgenciesQueryService.getAllAgencies();
    }

    // GET agency by ID
    @GetMapping("/{id}")
    public ResponseEntity<TravelAgencies> getAgencyById(@PathVariable Integer id) {
        try {
            TravelAgencies agency = getTravelAgenciesQueryService.getAgencyById(id);
            return new ResponseEntity<>(agency, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST new agency
    @PostMapping
    public ResponseEntity<String> addAgency(@RequestBody AddTravelAgencyCommand command) {
        try {
            addTravelAgencyCommandService.addTravelAgency(command);
            return new ResponseEntity<>("Agency created successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // PUT update agency
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAgency(@PathVariable Integer id, @RequestBody AddTravelAgencyCommand command) {
        try {
            addTravelAgencyCommandService.updateTravelAgency(id, command);
            return new ResponseEntity<>("Agency updated successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // DELETE agency
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAgency(@PathVariable Integer id) {
        try {
            addTravelAgencyCommandService.deleteTravelAgency(id);
            return new ResponseEntity<>("Agency deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
