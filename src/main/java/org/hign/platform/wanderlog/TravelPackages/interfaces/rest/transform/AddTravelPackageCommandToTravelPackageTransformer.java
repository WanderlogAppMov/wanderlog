package org.hign.platform.wanderlog.TravelPackages.interfaces.rest.transform;

import org.hign.platform.wanderlog.Attractions.domain.model.aggregates.Attractions;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddTravelPackageCommandToTravelPackageTransformer {

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

    public TravelPackages transform(AddTravelPackageCommand command) {
        TravelPackages travelPackage = new TravelPackages();
        travelPackage.setDestination(command.getDestination());
        travelPackage.setPricePerStudent(command.getPricePerStudent());
        travelPackage.setContinent(command.getContinent());

        // Obtener y asignar las entidades relacionadas (Hotel, Restaurant, Flight, Attraction, Agency)
        Hotel hotel = hotelsRepository.findById(command.getHotelId())
                .orElseThrow(() -> new IllegalArgumentException("Hotel not found"));
        travelPackage.setHotel(hotel);

        Restaurant restaurant = restaurantsRepository.findById(command.getRestaurantId())
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));
        travelPackage.setRestaurant(restaurant);

        Flight flight = flightsRepository.findById(command.getFlightId())
                .orElseThrow(() -> new IllegalArgumentException("Flight not found"));
        travelPackage.setFlight(flight);

        Attractions attraction = attractionsRepository.findById(command.getAttractionId())
                .orElseThrow(() -> new IllegalArgumentException("Attraction not found"));
        travelPackage.setAttraction(attraction);

        TravelAgencies agency = travelAgenciesRepository.findById(command.getAgencyId())
                .orElseThrow(() -> new IllegalArgumentException("Agency not found"));
        travelPackage.setAgency(agency);

        return travelPackage;
    }
}