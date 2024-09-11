package org.hign.platform.wanderlog.TravelPackages.interfaces.rest;

import jakarta.persistence.*;
import org.hign.platform.wanderlog.TravelPackages.application.commandServices.AddTravelPackageCommandService;
import org.hign.platform.wanderlog.TravelPackages.application.queryServices.GetTravelPackagesQueryService;
import org.hign.platform.wanderlog.TravelPackages.domain.model.aggregates.TravelPackages;
import org.hign.platform.wanderlog.TravelPackages.domain.model.commands.AddTravelPackageCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/travelpackages")
public class TravelPackagesController {

    @Autowired
    private AddTravelPackageCommandService addTravelPackageCommandService;

    @Autowired
    private GetTravelPackagesQueryService getTravelPackagesQueryService;

    // GET all travel packages
    @GetMapping
    public List<TravelPackages> getAllTravelPackages() {
        return getTravelPackagesQueryService.getAllTravelPackages();
    }

    // GET travel package by ID
    @GetMapping("/{id}")
    public ResponseEntity<TravelPackages> getTravelPackageById(@PathVariable Integer id) {
        try {
            TravelPackages travelPackage = getTravelPackagesQueryService.getTravelPackageById(id);
            return new ResponseEntity<>(travelPackage, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST new travel package
    @PostMapping
    public ResponseEntity<String> addTravelPackage(@RequestBody AddTravelPackageCommand command) {
        try {
            addTravelPackageCommandService.addTravelPackage(command);
            return new ResponseEntity<>("Travel package created successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // PUT update travel package
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTravelPackage(@PathVariable Integer id, @RequestBody AddTravelPackageCommand command) {
        try {
            addTravelPackageCommandService.updateTravelPackage(id, command);
            return new ResponseEntity<>("Travel package updated successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // DELETE travel package
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTravelPackage(@PathVariable Integer id) {
        try {
            addTravelPackageCommandService.deleteTravelPackage(id);
            return new ResponseEntity<>("Travel package deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}