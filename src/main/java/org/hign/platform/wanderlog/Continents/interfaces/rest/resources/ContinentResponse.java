package org.hign.platform.wanderlog.Continents.interfaces.rest.resources;

public class ContinentResponse {

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
