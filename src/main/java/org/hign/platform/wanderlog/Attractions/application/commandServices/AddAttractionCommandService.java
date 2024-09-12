package org.hign.platform.wanderlog.Attractions.application.commandServices;

import org.hign.platform.wanderlog.Attractions.domain.model.aggregates.Attractions;
import org.hign.platform.wanderlog.Attractions.domain.model.commands.AddAttractionCommand;
import org.hign.platform.wanderlog.Attractions.infrastructure.persistence.jpa.repositories.AttractionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddAttractionCommandService {

    @Autowired
    private AttractionsRepository attractionsRepository;

    public Attractions addAttraction(AddAttractionCommand command) {
        Attractions attraction = new Attractions();
        attraction.setAttractionName(command.getAttractionName());
        attraction.setCountry(command.getCountry());
        attraction.setCity(command.getCity());
        attraction.setTicketPrice(command.getTicketPrice());

        return attractionsRepository.save(attraction);
    }

    public Attractions updateAttraction(Integer id, AddAttractionCommand command) {
        Attractions attraction = attractionsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Attraction not found"));

        attraction.setAttractionName(command.getAttractionName());
        attraction.setCountry(command.getCountry());
        attraction.setCity(command.getCity());
        attraction.setTicketPrice(command.getTicketPrice());

        return attractionsRepository.save(attraction);
    }

    public void deleteAttraction(Integer id) {
        Attractions attraction = attractionsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Attraction not found"));
        attractionsRepository.delete(attraction);
    }
}