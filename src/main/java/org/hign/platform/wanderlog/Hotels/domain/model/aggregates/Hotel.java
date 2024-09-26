package org.hign.platform.wanderlog.Hotels.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hign.platform.wanderlog.Continents.domain.model.aggregates.Continent;

import java.math.BigDecimal;

@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelId;

    @Column(nullable = false, length = 255)
    @NotNull(message = "Hotel name is mandatory")
    private String hotelName;

    @Column(nullable = false, length = 100)
    @NotNull(message = "Country is mandatory")
    private String country;

    @Column(nullable = false, length = 100)
    @NotNull(message = "City is mandatory")
    private String city;

    @Column(nullable = false)
    @NotNull(message = "Stars are mandatory")
    private Integer stars;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal pricePerNight;

    @ManyToOne
    @JoinColumn(name = "continent_id", nullable = false)
    private Continent continent;

    // Getters and Setters

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

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

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
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
