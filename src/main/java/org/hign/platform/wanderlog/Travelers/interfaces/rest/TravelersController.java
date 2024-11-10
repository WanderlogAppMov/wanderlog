package org.hign.platform.wanderlog.Travelers.interfaces.rest;

//import org.hign.platform.wanderlog.Travelers.application.commandServices.AddTravelersCommandService;
//import org.hign.platform.wanderlog.Travelers.application.queryServices.GetTravelersQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hign.platform.wanderlog.Travelers.application.queryServices.TravelerQueryServiceImpl;
import org.hign.platform.wanderlog.Travelers.domain.model.aggregates.Travelers;
//import org.hign.platform.wanderlog.Travelers.domain.model.commands.AddTravelersCommand;
import org.hign.platform.wanderlog.Travelers.domain.services.TravelerCommandService;
import org.hign.platform.wanderlog.Travelers.interfaces.rest.resources.CreateTravelerResource;
import org.hign.platform.wanderlog.Travelers.interfaces.rest.resources.TravelerResource;
import org.hign.platform.wanderlog.Travelers.interfaces.rest.transform.CreateTravelerCommandFromResourceAssembler;
import org.hign.platform.wanderlog.Travelers.interfaces.rest.transform.TravelerResourceFromEntityAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/travelers", produces = "application/json")
@Tag(name = "Travelers", description = "Travelers Endpoints")
public class TravelersController {
    private final TravelerCommandService travelerCommandService;
    private final TravelerQueryServiceImpl travelerQueryService;

    /*
    @Autowired
    private AddTravelersCommandService addTravelersCommandService;

    @Autowired
    private GetTravelersQueryService getTravelersQueryService;*/

    public TravelersController(TravelerCommandService travelerCommandService, TravelerQueryServiceImpl travelerQueryService) {
        this.travelerCommandService = travelerCommandService;
        this.travelerQueryService = travelerQueryService;
    }

/*
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
    }*/

    /*
    // POST new traveler
    @PostMapping
    public ResponseEntity<String> addTraveler(@RequestBody AddTravelersCommand command) {
        try {
            addTravelersCommandService.addTraveler(command);
            return new ResponseEntity<>("Traveler registered successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }*/

    // POST new traveler
    @PostMapping
    public ResponseEntity<TravelerResource> createTraveler(@RequestBody CreateTravelerResource createTravelerResource) {
        var createTravelerCommand = CreateTravelerCommandFromResourceAssembler.toCommandFromResource(createTravelerResource);
        var travelerId = travelerCommandService.handle(createTravelerCommand);
        if (travelerId == 0) {
            return ResponseEntity.badRequest().build();
        }
        var traveler = travelerQueryService.findById(travelerId);
        if (traveler.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var travelerResource = TravelerResourceFromEntityAssembler.toResourceFromEntity(traveler.get());
        return ResponseEntity.ok(travelerResource);
    }

    /*
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
    }*/
}
