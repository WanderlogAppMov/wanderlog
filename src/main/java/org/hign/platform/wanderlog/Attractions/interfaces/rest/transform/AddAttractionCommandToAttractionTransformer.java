package org.hign.platform.wanderlog.Attractions.interfaces.rest.transform;

import org.hign.platform.wanderlog.Attractions.domain.model.aggregates.Attractions;
import org.hign.platform.wanderlog.Attractions.domain.model.commands.AddAttractionCommand;
import org.springframework.stereotype.Component;

@Component
public class AddAttractionCommandToAttractionTransformer {

    public Attractions transform(AddAttractionCommand command) {
        Attractions attraction = new Attractions();
        attraction.setAttractionName(command.getAttractionName());
        attraction.setCountry(command.getCountry());
        attraction.setCity(command.getCity());
        attraction.setTicketPrice(command.getTicketPrice());
        return attraction;
    }
}
