package org.hign.platform.wanderlog.TravelPackages.application.commandServices;

import jakarta.persistence.*;
import org.hign.platform.wanderlog.Attractions.infrastructure.persistence.jpa.repositories.AttractionsRepository;
import org.hign.platform.wanderlog.Flights.domain.model.aggregates.Flight;
import org.hign.platform.wanderlog.Flights.infrastructure.persistence.jpa.repositories.FlightRepository;
import org.hign.platform.wanderlog.Hotels.domain.model.aggregates.Hotel;
import org.hign.platform.wanderlog.Hotels.infrastructure.persistence.jpa.repositories.HotelRepository;
import org.hign.platform.wanderlog.Restaurants.domain.model.aggregates.Restaurant;
import org.hign.platform.wanderlog.Restaurants.infrastructure.persistence.jpa.repositories.RestaurantRepository;
import org.hign.platform.wanderlog.TravelAgencies.domain.model.aggregates.TravelAgencies;
import org.hign.platform.wanderlog.TravelAgencies.infrastructure.persistence.jpa.repositories.TravelAgenciesRepository;
import org.hign.platform.wanderlog.TravelPackages.domain.model.aggregates.TravelPackages;
import org.hign.platform.wanderlog.TravelPackages.domain.model.commands.AddTravelPackageCommand;
import org.hign.platform.wanderlog.TravelPackages.infrastructure.persistence.jpa.repositories.TravelPackagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddTravelPackageCommandService {

    @Autowired
    private TravelPackagesRepository travelPackagesRepository;

    @Autowired
    private HotelRepository hotelsRepository;

    @Autowired
    private RestaurantRepository restaurantsRepository;

    @Autowired
    private FlightRepository flightsRepository;

    @Autowired
    private AttractionsRepository attractionsRepository;

    @Autowired
    private TravelAgenciesRepository travelAgenciesRepository;

    public TravelPackages addTravelPackage(AddTravelPackageCommand command) {
        TravelPackages travelPackage = new TravelPackages();
        travelPackage.setDestination(command.getDestination());
        travelPackage.setPricePerStudent(command.getPricePerStudent());
        travelPackage.setContinent(command.getContinent());

        travelPackage.setHotel(hotelsRepository.findById(command.getHotelId())
                .orElseThrow(() -> new IllegalArgumentException("Hotel not found")));

        travelPackage.setRestaurant(restaurantsRepository.findById(command.getRestaurantId())
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found")));

        travelPackage.setFlight(flightsRepository.findById(command.getFlightId())
                .orElseThrow(() -> new IllegalArgumentException("Flight not found")));

        travelPackage.setAttraction(attractionsRepository.findById(command.getAttractionId())
                .orElseThrow(() -> new IllegalArgumentException("Attraction not found")));

        travelPackage.setAgency(travelAgenciesRepository.findById(command.getAgencyId())
                .orElseThrow(() -> new IllegalArgumentException("Agency not found")));

        return travelPackagesRepository.save(travelPackage);
    }

    public TravelPackages updateTravelPackage(Integer id, AddTravelPackageCommand command) {
        TravelPackages travelPackage = travelPackagesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Travel package not found"));

        travelPackage.setDestination(command.getDestination());
        travelPackage.setPricePerStudent(command.getPricePerStudent());
        travelPackage.setContinent(command.getContinent());

        travelPackage.setHotel(hotelsRepository.findById(command.getHotelId())
                .orElseThrow(() -> new IllegalArgumentException("Hotel not found")));

        travelPackage.setRestaurant(restaurantsRepository.findById(command.getRestaurantId())
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found")));

        travelPackage.setFlight(flightsRepository.findById(command.getFlightId())
                .orElseThrow(() -> new IllegalArgumentException("Flight not found")));

        travelPackage.setAttraction(attractionsRepository.findById(command.getAttractionId())
                .orElseThrow(() -> new IllegalArgumentException("Attraction not found")));

        travelPackage.setAgency(travelAgenciesRepository.findById(command.getAgencyId())
                .orElseThrow(() -> new IllegalArgumentException("Agency not found")));

        return travelPackagesRepository.save(travelPackage);
    }

    public void deleteTravelPackage(Integer id) {
        TravelPackages travelPackage = travelPackagesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Travel package not found"));
        travelPackagesRepository.delete(travelPackage);
    }
}