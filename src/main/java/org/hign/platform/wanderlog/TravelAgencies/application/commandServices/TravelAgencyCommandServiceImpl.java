package org.hign.platform.wanderlog.TravelAgencies.application.commandServices;

import jakarta.transaction.Transactional;
import org.hign.platform.wanderlog.TravelAgencies.application.outboundservice.acl.ExternalAgencyIamService;
import org.hign.platform.wanderlog.TravelAgencies.domain.model.aggregates.TravelAgencies;
import org.hign.platform.wanderlog.TravelAgencies.domain.model.commands.CreateTravelAgencyCommand;
import org.hign.platform.wanderlog.TravelAgencies.domain.model.commands.UpdateTravelAgencyCommand;
import org.hign.platform.wanderlog.TravelAgencies.domain.model.valueobjects.TravelAgencyProfile;
import org.hign.platform.wanderlog.TravelAgencies.domain.services.TravelAgencyCommandService;
import org.hign.platform.wanderlog.TravelAgencies.infrastructure.persistence.jpa.repositories.TravelAgenciesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TravelAgencyCommandServiceImpl implements TravelAgencyCommandService {

    private final TravelAgenciesRepository travelAgenciesRepository;
    private final ExternalAgencyIamService externalIamService;

    public TravelAgencyCommandServiceImpl(TravelAgenciesRepository travelAgenciesRepository, ExternalAgencyIamService externalIamService) {
        this.travelAgenciesRepository = travelAgenciesRepository;
        this.externalIamService = externalIamService;
    }

    @Override
    @Transactional
    public Integer handle(CreateTravelAgencyCommand command) {
        if (travelAgenciesRepository.existsByName(command.organizationName())) {
            throw new IllegalArgumentException("Travel agency with same organizationName already exists");
        }
        var userAgencyId = externalIamService.createUser(command.username(), command.password(), command.roles());
        if (userAgencyId.isEmpty()) {
            throw new IllegalArgumentException("Error while creating user in IAM");
        }
        var travelAgency = new TravelAgencies(command, userAgencyId.get());
        try {
            travelAgenciesRepository.save(travelAgency);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving travel agency: " + e.getMessage());
        }

        return travelAgency.getAgencyId();
    }

    @Override
    @Transactional
    public Optional<TravelAgencies> handle(UpdateTravelAgencyCommand command) {
        var travelAgencyOptional = travelAgenciesRepository.findById(command.agencyId());
        if (travelAgencyOptional.isEmpty()) {
            return Optional.empty();
        }
        var travelAgency = travelAgencyOptional.get();
        var travelAgencyProfile = new TravelAgencyProfile(command.organizationName(), command.repreFirstName(), command.repreLastName());
        travelAgency.update(travelAgencyProfile);
        travelAgenciesRepository.save(travelAgency);
        return Optional.of(travelAgency);
    }
}
