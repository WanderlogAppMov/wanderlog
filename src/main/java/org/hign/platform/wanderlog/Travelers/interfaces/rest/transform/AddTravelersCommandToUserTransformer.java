package org.hign.platform.wanderlog.Travelers.interfaces.rest.transform;

import org.hign.platform.wanderlog.Travelers.domain.model.aggregates.Travelers;
import org.hign.platform.wanderlog.Travelers.domain.model.commands.AddTravelersCommand;
import org.springframework.stereotype.Component;

@Component
public class AddTravelersCommandToUserTransformer {

    public Travelers transform(AddTravelersCommand command) {
        Travelers traveler = new Travelers();
        traveler.setFirstName(command.getFirstName());
        traveler.setLastName(command.getLastName());
        traveler.setGender(command.getGender());
        traveler.setEmail(command.getEmail());
        traveler.setPasswordHash(command.getPasswordHash()); // El nombre correcto es getPasswordHash()
        traveler.setBirthdate(command.getBirthdate());
        traveler.setCellphone(command.getCellphone());
        traveler.setStreetAddress(command.getStreetAddress());
        traveler.setCity(command.getCity());
        traveler.setRegion(command.getRegion());
        traveler.setPostalCode(command.getPostalCode());
        traveler.setCountry(command.getCountry());
        return traveler;
    }
}
