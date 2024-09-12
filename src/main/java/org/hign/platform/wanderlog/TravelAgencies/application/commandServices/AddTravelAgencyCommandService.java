package org.hign.platform.wanderlog.TravelAgencies.application.commandServices;

import org.hign.platform.wanderlog.TravelAgencies.domain.model.aggregates.TravelAgencies;
import org.hign.platform.wanderlog.TravelAgencies.domain.model.commands.AddTravelAgencyCommand;
import org.hign.platform.wanderlog.TravelAgencies.infrastructure.persistence.jpa.repositories.TravelAgenciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddTravelAgencyCommandService {

    @Autowired
    private TravelAgenciesRepository travelAgenciesRepository;

    public TravelAgencies addTravelAgency(AddTravelAgencyCommand command) {
        TravelAgencies agency = new TravelAgencies();
        agency.setOrganizationName(command.getOrganizationName());
        agency.setRepreFirstName(command.getRepreFirstName());
        agency.setRepreLastName(command.getRepreLastName());
        agency.setContactEmail(command.getContactEmail());
        agency.setPassword(command.getPassword());

        return travelAgenciesRepository.save(agency);
    }

    public TravelAgencies updateTravelAgency(Integer id, AddTravelAgencyCommand command) {
        TravelAgencies agency = travelAgenciesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agency not found"));

        agency.setOrganizationName(command.getOrganizationName());
        agency.setRepreFirstName(command.getRepreFirstName());
        agency.setRepreLastName(command.getRepreLastName());
        agency.setContactEmail(command.getContactEmail());
        agency.setPassword(command.getPassword());

        return travelAgenciesRepository.save(agency);
    }

    public void deleteTravelAgency(Integer id) {
        TravelAgencies agency = travelAgenciesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agency not found"));
        travelAgenciesRepository.delete(agency);
    }
}
