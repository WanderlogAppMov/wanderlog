package org.hign.platform.wanderlog.Attractions.interfaces.rest;

import org.hign.platform.wanderlog.Attractions.application.commandServices.AddAttractionCommandService;
import org.hign.platform.wanderlog.Attractions.application.queryServices.GetAttractionsQueryService;
import org.hign.platform.wanderlog.Attractions.domain.model.aggregates.Attractions;
import org.hign.platform.wanderlog.Attractions.domain.model.commands.AddAttractionCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attractions")
public class AttractionsController {

    @Autowired
    private AddAttractionCommandService addAttractionCommandService;

    @Autowired
    private GetAttractionsQueryService getAttractionsQueryService;

    // GET all attractions
    @GetMapping
    public List<Attractions> getAllAttractions() {
        return getAttractionsQueryService.getAllAttractions();
    }

    // GET attraction by ID
    @GetMapping("/{id}")
    public ResponseEntity<Attractions> getAttractionById(@PathVariable Integer id) {
        try {
            Attractions attraction = getAttractionsQueryService.getAttractionById(id);
            return new ResponseEntity<>(attraction, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST new attraction
    @PostMapping
    public ResponseEntity<String> addAttraction(@RequestBody AddAttractionCommand command) {
        try {
            addAttractionCommandService.addAttraction(command);
            return new ResponseEntity<>("Attraction created successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // PUT update attraction
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAttraction(@PathVariable Integer id, @RequestBody AddAttractionCommand command) {
        try {
            addAttractionCommandService.updateAttraction(id, command);
            return new ResponseEntity<>("Attraction updated successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // DELETE attraction
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAttraction(@PathVariable Integer id) {
        try {
            addAttractionCommandService.deleteAttraction(id);
            return new ResponseEntity<>("Attraction deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
