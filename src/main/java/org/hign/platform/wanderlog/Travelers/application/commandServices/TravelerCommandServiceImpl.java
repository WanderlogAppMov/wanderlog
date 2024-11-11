package org.hign.platform.wanderlog.Travelers.application.commandServices;

import jakarta.transaction.Transactional;
import org.hign.platform.wanderlog.Travelers.application.outboundservice.acl.ExternalIamService;
import org.hign.platform.wanderlog.Travelers.domain.model.aggregates.Travelers;
import org.hign.platform.wanderlog.Travelers.domain.model.commands.CreateTravelerCommand;
import org.hign.platform.wanderlog.Travelers.domain.model.commands.UpdateTravelerCommand;
import org.hign.platform.wanderlog.Travelers.domain.model.valueobjects.TravelerProfile;
import org.hign.platform.wanderlog.Travelers.domain.services.TravelerCommandService;
import org.hign.platform.wanderlog.Travelers.infrastructure.persistence.jpa.repositories.TravelersRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TravelerCommandServiceImpl implements TravelerCommandService {

    private final TravelersRepository travelersRepository;
    private final ExternalIamService externalIamService;

    public TravelerCommandServiceImpl(TravelersRepository travelersRepository, ExternalIamService externalIamService) {
        this.travelersRepository = travelersRepository;
        this.externalIamService = externalIamService;
    }


    @Override
    @Transactional
    public Integer handle(CreateTravelerCommand command) {
        if(travelersRepository.existsByName(command.firstName())){
            throw new IllegalArgumentException("Traveler with same user id already exists");
        }
        var userId = externalIamService.createUser(command.username(), command.password(), command.roles());
        if(userId.isEmpty()){
            throw new IllegalArgumentException("Error while creating user in IAM");
        }
        var traveler = new Travelers(command, userId.get());
        try {
            travelersRepository.save(traveler);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving traveler: " + e.getMessage());
        }

        return traveler.getTravelerId();
    }

    @Override
    @Transactional
    public Optional<Travelers> handle(UpdateTravelerCommand command) {
        var travelerOptional = travelersRepository.findById(command.travelerId());
        if (travelerOptional.isEmpty()) {
            return Optional.empty();
        }
        var traveler = travelerOptional.get();
        var travelerProfile = new TravelerProfile(command.firstName(), command.lastName(), command.gender(), command.birthdate());
        traveler.update(travelerProfile);
        travelersRepository.save(traveler);
        return Optional.of(traveler);
    }
}
