package org.hign.platform.wanderlog.PlannedTrips.domain.model.aggregates;

import jakarta.persistence.*;
import org.hign.platform.wanderlog.TravelPackages.domain.model.aggregates.TravelPackages;
import org.hign.platform.wanderlog.Travelers.domain.model.aggregates.Travelers;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "plannedtrips")
public class PlannedTrips {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer plannedTripId;

    @ManyToOne
    @JoinColumn(name = "travelerId", nullable = false)
    private Travelers traveler;

    @ManyToOne
    @JoinColumn(name = "travelPackageId", nullable = false)
    private TravelPackages travelPackage;

    @Column(nullable = false)
    private Integer numberOfStudents;

    @Temporal(TemporalType.DATE)
    private Date tentativeDate;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal budget;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        PLANNED, CONFIRMED, CANCELLED
    }

    // Getters and Setters

    public Integer getPlannedTripId() {
        return plannedTripId;
    }

    public void setPlannedTripId(Integer plannedTripId) {
        this.plannedTripId = plannedTripId;
    }

    public Travelers getTraveler() {
        return traveler;
    }

    public void setTraveler(Travelers traveler) {
        this.traveler = traveler;
    }

    public TravelPackages getTravelPackage() {
        return travelPackage;
    }

    public void setTravelPackage(TravelPackages travelPackage) {
        this.travelPackage = travelPackage;
    }

    public Integer getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(Integer numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public Date getTentativeDate() {
        return tentativeDate;
    }

    public void setTentativeDate(Date tentativeDate) {
        this.tentativeDate = tentativeDate;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}