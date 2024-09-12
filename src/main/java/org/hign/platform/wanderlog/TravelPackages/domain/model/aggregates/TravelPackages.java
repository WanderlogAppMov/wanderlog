package org.hign.platform.wanderlog.TravelPackages.domain.model.aggregates;

import jakarta.persistence.*;
import org.hign.platform.wanderlog.Attractions.domain.model.aggregates.Attractions;
import org.hign.platform.wanderlog.Flights.domain.model.aggregates.Flight;
import org.hign.platform.wanderlog.Hotels.domain.model.aggregates.Hotel;
import org.hign.platform.wanderlog.Restaurants.domain.model.aggregates.Restaurant;
import org.hign.platform.wanderlog.TravelAgencies.domain.model.aggregates.TravelAgencies;

import java.math.BigDecimal;

@Entity
@Table(name = "travelpackages")
public class TravelPackages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer travelPackageId;

    @Column(nullable = false, length = 255)
    private String destination;

    @ManyToOne
    @JoinColumn(name = "hotelId", nullable = false)
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "restaurantId", nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "flightId", nullable = false)
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "attractionId", nullable = false)
    private Attractions attraction;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal pricePerStudent;

    @ManyToOne
    @JoinColumn(name = "agencyId", nullable = false)
    private TravelAgencies agency;

    @Column(nullable = false, length = 100)
    private String continent;

    // Getters and Setters

    public Integer getTravelPackageId() {
        return travelPackageId;
    }

    public void setTravelPackageId(Integer travelPackageId) {
        this.travelPackageId = travelPackageId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Attractions getAttraction() {
        return attraction;
    }

    public void setAttraction(Attractions attraction) {
        this.attraction = attraction;
    }

    public BigDecimal getPricePerStudent() {
        return pricePerStudent;
    }

    public void setPricePerStudent(BigDecimal pricePerStudent) {
        this.pricePerStudent = pricePerStudent;
    }

    public TravelAgencies getAgency() {
        return agency;
    }

    public void setAgency(TravelAgencies agency) {
        this.agency = agency;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
