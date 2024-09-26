package org.hign.platform.wanderlog.Attractions.domain.model.aggregates;

import jakarta.persistence.*;
import org.hign.platform.wanderlog.Continents.domain.model.aggregates.Continent;

import java.math.BigDecimal;

@Entity
@Table(name = "attractions")
public class Attractions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attractionId;

    @Column(nullable = false, length = 255)
    private String attractionName;

    @Column(nullable = false, length = 100)
    private String country;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal ticketPrice;

    // Nueva relación con Continent
    @ManyToOne
    @JoinColumn(name = "continent_id", nullable = false)  // FK en la tabla de 'attractions'
    private Continent continent;

    // Getters y Setters

    public Integer getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(Integer attractionId) {
        this.attractionId = attractionId;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
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

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }
}
