package org.hign.platform.wanderlog.TravelAgencies.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
//import org.hign.platform.wanderlog.TravelAgencies.application.commandServices.AddTravelAgencyCommandService;
//import org.hign.platform.wanderlog.TravelAgencies.application.queryServices.GetTravelAgenciesQueryService;
//import org.hign.platform.wanderlog.TravelAgencies.domain.model.aggregates.TravelAgencies;
//import org.hign.platform.wanderlog.TravelAgencies.domain.model.commands.AddTravelAgencyCommand;
import org.hign.platform.wanderlog.TravelAgencies.domain.model.commands.UpdateTravelAgencyCommand;
import org.hign.platform.wanderlog.TravelAgencies.domain.services.TravelAgencyCommandService;
import org.hign.platform.wanderlog.TravelAgencies.domain.services.TravelAgencyQueryService;
import org.hign.platform.wanderlog.TravelAgencies.interfaces.rest.resources.CreateTravelAgencyResource;
import org.hign.platform.wanderlog.TravelAgencies.interfaces.rest.resources.TravelAgencyProfileResource;
import org.hign.platform.wanderlog.TravelAgencies.interfaces.rest.resources.TravelAgencyResource;
import org.hign.platform.wanderlog.TravelAgencies.interfaces.rest.transform.CreateTravelAgencyCommandFromResourceAssembler;
import org.hign.platform.wanderlog.TravelAgencies.interfaces.rest.transform.TravelAgencyProfileResourceFromEntityAssembler;
import org.hign.platform.wanderlog.TravelAgencies.interfaces.rest.transform.TravelAgencyResourceFromEntityAssembler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.hign.platform.wanderlog.iam.interfaces.acl.IamContextFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/travelagencies")
@Tag(name = "TravelAgencies", description = "Travel Agencies Endpoints")
public class TravelAgenciesController {

    private final TravelAgencyCommandService travelAgencyCommandService;
    private final TravelAgencyQueryService travelAgencyQueryService;
    private final IamContextFacade iamContextFacade;

    public TravelAgenciesController(TravelAgencyCommandService travelAgencyCommandService, TravelAgencyQueryService travelAgencyQueryService, IamContextFacade iamContextFacade) {
        this.travelAgencyCommandService = travelAgencyCommandService;
        this.travelAgencyQueryService = travelAgencyQueryService;
        this.iamContextFacade = iamContextFacade;
    }

    @GetMapping("/{id}/profile")
    public ResponseEntity<TravelAgencyProfileResource> getTravelAgencyProfileById(@PathVariable Integer id) {
        var traveler = travelAgencyQueryService.findById(id);
        if (traveler.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var travelerProfileResource = TravelAgencyProfileResourceFromEntityAssembler.toResourceFromEntity(traveler.get(), iamContextFacade);
        return ResponseEntity.ok(travelerProfileResource);
    }

    @GetMapping("/username/{username}/profile")
    public ResponseEntity<TravelAgencyProfileResource> getTravelAgencyProfileByUsername(@PathVariable String username) {
        var userId = iamContextFacade.fetchUserIdByUsername(username);
        var traveler = travelAgencyQueryService.findByUserId(userId);
        if (traveler.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var travelerProfileResource = TravelAgencyProfileResourceFromEntityAssembler.toResourceFromEntity(traveler.get(), iamContextFacade);
        return ResponseEntity.ok(travelerProfileResource);
    }


    @GetMapping
    ResponseEntity<List<TravelAgencyResource>> getAllTravelAgencies() {
        var travelAgencies = travelAgencyQueryService.findAll();
        if (travelAgencies.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var travelAgenciesResponse = travelAgencies.get().stream()
                .map(TravelAgencyResourceFromEntityAssembler::toResourceFromEntity)
                .collect(java.util.stream.Collectors.toList());
        return ResponseEntity.ok(travelAgenciesResponse);
    }

    @PostMapping
    ResponseEntity<TravelAgencyResource> createTravelAgency(@RequestBody CreateTravelAgencyResource createTravelAgencyResource){
        var createTravelAgencyCommand = CreateTravelAgencyCommandFromResourceAssembler.toCommandFromResource(createTravelAgencyResource);
        var travelAgencyId = travelAgencyCommandService.handle(createTravelAgencyCommand);
        if(travelAgencyId == 0){
            return ResponseEntity.badRequest().build();
        }
        var travelAgency = travelAgencyQueryService.findById(travelAgencyId);
        if(travelAgency.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var travelAgencyResource = TravelAgencyResourceFromEntityAssembler.toResourceFromEntity(travelAgency.get());
        return ResponseEntity.ok(travelAgencyResource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTravelAgency(@PathVariable Integer id, @RequestBody UpdateTravelAgencyCommand command) {
        if (!id.equals(command.agencyId())){
            return ResponseEntity.badRequest().body("Travel Agency ID in path and body must match");
        }
        var updateTravelAgency = travelAgencyCommandService.handle(command);
        return updateTravelAgency.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*
    @Autowired
    private AddTravelAgencyCommandService addTravelAgencyCommandService;

    @Autowired
    private GetTravelAgenciesQueryService getTravelAgenciesQueryService;*/

    /*
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
    }*/
}
