package org.hign.platform.wanderlog.Continents.domain.model.commands;

public class AddContinentCommand {
    private String continentName;

    // Constructor sin parámetros (necesario para la deserialización)
    public AddContinentCommand() {
    }

    // Constructor con parámetros
    public AddContinentCommand(String continentName) {
        this.continentName = continentName;
    }

    // Getters y Setters
    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }
}
