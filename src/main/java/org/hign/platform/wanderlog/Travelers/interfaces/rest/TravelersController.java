package org.hign.platform.wanderlog.Travelers.interfaces.rest;

//import org.hign.platform.wanderlog.Travelers.application.commandServices.AddTravelersCommandService;
//import org.hign.platform.wanderlog.Travelers.application.queryServices.GetTravelersQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hign.platform.wanderlog.Travelers.application.queryServices.TravelerQueryServiceImpl;
import org.hign.platform.wanderlog.Travelers.domain.model.aggregates.Travelers;
//import org.hign.platform.wanderlog.Travelers.domain.model.commands.AddTravelersCommand;
import org.hign.platform.wanderlog.Travelers.domain.model.commands.UpdateTravelerCommand;
import org.hign.platform.wanderlog.Travelers.domain.services.TravelerCommandService;
import org.hign.platform.wanderlog.Travelers.domain.services.TravelerQueryService;
import org.hign.platform.wanderlog.Travelers.interfaces.rest.resources.CreateTravelerResource;
import org.hign.platform.wanderlog.Travelers.interfaces.rest.resources.TravelerProfileResource;
import org.hign.platform.wanderlog.Travelers.interfaces.rest.resources.TravelerResource;
import org.hign.platform.wanderlog.Travelers.interfaces.rest.transform.CreateTravelerCommandFromResourceAssembler;
import org.hign.platform.wanderlog.Travelers.interfaces.rest.transform.TravelerProfileResourceFromEntityAssembler;
import org.hign.platform.wanderlog.Travelers.interfaces.rest.transform.TravelerResourceFromEntityAssembler;
import org.hign.platform.wanderlog.iam.interfaces.acl.IamContextFacade;
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
    private final TravelerQueryService travelerQueryService;
    private final IamContextFacade iamContextFacade;

    /*
    @Autowired
    private AddTravelersCommandService addTravelersCommandService;

    @Autowired
    private GetTravelersQueryService getTravelersQueryService;*/

    public TravelersController(TravelerCommandService travelerCommandService, TravelerQueryServiceImpl travelerQueryService, IamContextFacade iamContextFacade) {
        this.travelerCommandService = travelerCommandService;
        this.travelerQueryService = travelerQueryService;
        this.iamContextFacade = iamContextFacade;
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

    @GetMapping
    ResponseEntity<List<TravelerResource>> getAllTravelers() {
        var travelers = travelerQueryService.findAll();
        if(travelers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var travelersResponse = travelers.get().stream()
                .map(TravelerResourceFromEntityAssembler::toResourceFromEntity)
                .collect(java.util.stream.Collectors.toList());
        return ResponseEntity.ok(travelersResponse);
    }

    @GetMapping("/{id}/profile")
    public ResponseEntity<TravelerProfileResource> getTravelerProfileById(@PathVariable Integer id) {
        var traveler = travelerQueryService.findById(id);
        if (traveler.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var travelerProfileResource = TravelerProfileResourceFromEntityAssembler.toResourceFromEntity(traveler.get(), iamContextFacade);
        return ResponseEntity.ok(travelerProfileResource);
    }

    @GetMapping("/username/{username}/profile")
    public ResponseEntity<TravelerProfileResource> getTravelerProfileByUsername(@PathVariable String username) {
        var userId = iamContextFacade.fetchUserIdByUsername(username);
        var traveler = travelerQueryService.findByUserId(userId);
        if (traveler.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var travelerProfileResource = TravelerProfileResourceFromEntityAssembler.toResourceFromEntity(traveler.get(), iamContextFacade);
        return ResponseEntity.ok(travelerProfileResource);
    }

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
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTraveler(@PathVariable Integer id, @RequestBody UpdateTravelerCommand command) {
        if (!id.equals(command.travelerId())) {
            return ResponseEntity.badRequest().body("Traveler ID in path and body must match");
        }
        var updatedTraveler = travelerCommandService.handle(command);
        return updatedTraveler.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
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
