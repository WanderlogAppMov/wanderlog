package org.hign.platform.wanderlog.Flights.domain.model.aggregates;

import jakarta.persistence.*;
import org.hign.platform.wanderlog.Continents.domain.model.aggregates.Continent;

import java.math.BigDecimal;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightId;

    private String airline;
    private String departureCountry;
    private String arrivalCountry;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "continent_id", nullable = false)  // FK para continent
    private Continent continent;

    // Nuevo campo para la URL de la imagen
    @Column(length = 500)
    private String imageUrl;

    // Getters y Setters

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

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

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
