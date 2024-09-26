package org.hign.platform.wanderlog.Flights.domain.model.commands;

import java.math.BigDecimal;

public class AddFlightCommand {

    private String airline;
    private String departureCountry;
    private String arrivalCountry;
    private BigDecimal price;
    private Integer continentId;  // Nuevo campo

    // Constructor
    public AddFlightCommand(String airline, String departureCountry, String arrivalCountry, BigDecimal price, Integer continentId) {
        this.airline = airline;
        this.departureCountry = departureCountry;
        this.arrivalCountry = arrivalCountry;
        this.price = price;
        this.continentId = continentId;
    }

    // Getters y Setters

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDepartureCountry() {
        return departureCountry;
    }

    public void setDepartureCountry(String departureCountry) {
        this.departureCountry = departureCountry;
    }

    public String getArrivalCountry() {
        return arrivalCountry;
    }

    public void setArrivalCountry(String arrivalCountry) {
        this.arrivalCountry = arrivalCountry;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getContinentId() {
        return continentId;
    }

    public void setContinentId(Integer continentId) {
        this.continentId = continentId;
    }
}
