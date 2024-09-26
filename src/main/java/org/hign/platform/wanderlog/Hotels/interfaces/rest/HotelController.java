package org.hign.platform.wanderlog.Hotels.interfaces.rest;

import org.hign.platform.wanderlog.Hotels.application.commandServices.AddHotelCommandService;
import org.hign.platform.wanderlog.Hotels.application.queryServices.GetHotelsQueryService;
import org.hign.platform.wanderlog.Hotels.domain.model.aggregates.Hotel;
import org.hign.platform.wanderlog.Hotels.domain.model.commands.AddHotelCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private AddHotelCommandService addHotelCommandService;

    @Autowired
    private GetHotelsQueryService getHotelsQueryService;

    // GET all hotels
    @GetMapping
    public List<Hotel> getAllHotels() {
        return getHotelsQueryService.getAllHotels();
    }

    // GET hotel by ID
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Integer id) {
        try {
            Hotel hotel = getHotelsQueryService.getHotelById(id);
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // GET hotels by continent ID (opcional)
    @GetMapping("/continent/{continentId}")
    public ResponseEntity<List<Hotel>> getHotelsByContinent(@PathVariable Integer continentId) {
        try {
            List<Hotel> hotels = getHotelsQueryService.getHotelsByContinentId(continentId);
            return new ResponseEntity<>(hotels, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // POST new hotel
    @PostMapping
    public ResponseEntity<String> addHotel(@RequestBody AddHotelCommand command) {
        try {
            addHotelCommandService.addHotel(command);
            return new ResponseEntity<>("Hotel created successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // PUT update hotel
    @PutMapping("/{id}")
    public ResponseEntity<String> updateHotel(@PathVariable Integer id, @RequestBody AddHotelCommand command) {
        try {
            addHotelCommandService.updateHotel(id, command);
            return new ResponseEntity<>("Hotel updated successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // DELETE hotel
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable Integer id) {
        try {
            addHotelCommandService.deleteHotel(id);
            return new ResponseEntity<>("Hotel deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // GET hotels by city
    @GetMapping("/city/{city}")
    public ResponseEntity<List<Hotel>> getHotelsByCity(@PathVariable String city) {
        try {
            List<Hotel> hotels = getHotelsQueryService.getHotelsByCity(city);
            return new ResponseEntity<>(hotels, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // GET hotels by country
    @GetMapping("/country/{country}")
    public ResponseEntity<List<Hotel>> getHotelsByCountry(@PathVariable String country) {
        try {
            List<Hotel> hotels = getHotelsQueryService.getHotelsByCountry(country);
            return new ResponseEntity<>(hotels, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
