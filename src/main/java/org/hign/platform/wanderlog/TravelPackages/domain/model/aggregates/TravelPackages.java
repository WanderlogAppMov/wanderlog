package org.hign.platform.wanderlog.TravelPackages.domain.model.aggregates;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "travelpackages")
public class TravelPackages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer travelPackageId;

    @Column(nullable = false, length = 255)
    private String destination;

    @Lob
    private String transportationDetails;

    @Lob
    private String accommodationDetails;

    @Lob
    private String activitiesDetails;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal pricePerStudent;

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

    public String getTransportationDetails() {
        return transportationDetails;
    }

    public void setTransportationDetails(String transportationDetails) {
        this.transportationDetails = transportationDetails;
    }

    public String getAccommodationDetails() {
        return accommodationDetails;
    }

    public void setAccommodationDetails(String accommodationDetails) {
        this.accommodationDetails = accommodationDetails;
    }

    public String getActivitiesDetails() {
        return activitiesDetails;
    }

    public void setActivitiesDetails(String activitiesDetails) {
        this.activitiesDetails = activitiesDetails;
    }

    public BigDecimal getPricePerStudent() {
        return pricePerStudent;
    }

    public void setPricePerStudent(BigDecimal pricePerStudent) {
        this.pricePerStudent = pricePerStudent;
    }
}