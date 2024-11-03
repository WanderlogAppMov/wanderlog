package org.hign.platform.wanderlog.Attractions.application.commandServices;

import org.hign.platform.wanderlog.Attractions.domain.model.aggregates.Attractions;
import org.hign.platform.wanderlog.Attractions.domain.model.commands.AddAttractionCommand;
import org.hign.platform.wanderlog.Attractions.infrastructure.persistence.jpa.repositories.AttractionsRepository;
import org.hign.platform.wanderlog.Continents.infrastructure.persistence.jpa.repositories.ContinentRepository;
import org.hign.platform.wanderlog.Continents.domain.model.aggregates.Continent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddAttractionCommandService {

    @Autowired
    private AttractionsRepository attractionsRepository;

    @Autowired
    private ContinentRepository continentRepository;

    public Attractions addAttraction(AddAttractionCommand command) {
        Attractions attraction = new Attractions();
        attraction.setAttractionName(command.getAttractionName());
        attraction.setCountry(command.getCountry());
        attraction.setCity(command.getCity());
        attraction.setTicketPrice(command.getTicketPrice());

        // Establece el continente basado en el ID
        Continent continent = continentRepository.findById(command.getContinentId())
                .orElseThrow(() -> new IllegalArgumentException("Continent not found"));
        attraction.setContinent(continent);

        // Establece la URL de la imagen
        attraction.setImageUrl(command.getImageUrl());

        return attractionsRepository.save(attraction);
    }



    public Attractions updateAttraction(Integer id, AddAttractionCommand command) {
        Attractions attraction = attractionsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Attraction not found"));

        attraction.setAttractionName(command.getAttractionName());
        attraction.setCountry(command.getCountry());
        attraction.setCity(command.getCity());
        attraction.setTicketPrice(command.getTicketPrice());

        // Asignar continente basado en el ID
        Continent continent = continentRepository.findById(command.getContinentId())
                .orElseThrow(() -> new IllegalArgumentException("Continent not found"));
        attraction.setContinent(continent);

        return attractionsRepository.save(attraction);
    }

    public void deleteAttraction(Integer id) {
        Attractions attraction = attractionsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Attraction not found"));
        attractionsRepository.delete(attraction);
    }
}
