package org.hign.platform.wanderlog.Travelers.application.commandServices;

import org.hign.platform.wanderlog.Travelers.domain.model.aggregates.Travelers;
import org.hign.platform.wanderlog.Travelers.domain.model.commands.AddTravelersCommand;
import org.hign.platform.wanderlog.Travelers.infrastructure.persistence.jpa.repositories.TravelersRepository;
import org.hign.platform.wanderlog.Travelers.interfaces.rest.transform.AddTravelersCommandToUserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddTravelersCommandService {

    @Autowired
    private TravelersRepository travelersRepository;

    @Autowired
    private AddTravelersCommandToUserTransformer transformer;

    public Travelers addTraveler(AddTravelersCommand command) {
        if (travelersRepository.existsByEmail(command.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        Travelers traveler = transformer.transform(command);
        return travelersRepository.save(traveler);
    }

    public Travelers updateTraveler(Integer travelerId, AddTravelersCommand command) {
        Optional<Travelers> existingTraveler = travelersRepository.findById(travelerId);
        if (!existingTraveler.isPresent()) {
            throw new IllegalArgumentException("Traveler not found");
        }
        Travelers traveler = existingTraveler.get();
        traveler.setFirstName(command.getFirstName());
        traveler.setLastName(command.getLastName());
        // Otros campos a actualizar
        return travelersRepository.save(traveler);
    }

    public void deleteTraveler(Integer travelerId) {
        travelersRepository.deleteById(travelerId);
    }
}