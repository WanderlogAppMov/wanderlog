package org.hign.platform.wanderlog.Continents.domain.model.aggregates;

import jakarta.persistence.*;

@Entity
@Table(name = "continents")
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer continentID;

    private String continentName;

    // Getters y Setters
    public Integer getContinentID() {
        return continentID;
    }

    public void setContinentID(Integer continentID) {
        this.continentID = continentID;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }
}
