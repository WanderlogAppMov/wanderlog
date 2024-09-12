package org.hign.platform.wanderlog.Hotels.domain.model.commands;

import org.hign.platform.wanderlog.Continents.domain.model.aggregates.Continent;

import java.math.BigDecimal;

public class AddHotelCommand {

    private String hotelName;
    private String country;
    private String city;
    private int stars;
    private BigDecimal pricePerNight;
    private Continent continent;

    // Getters y Setters

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }
}
