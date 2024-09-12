package org.hign.platform.wanderlog.TravelAgencies.interfaces.rest.transform;

import org.hign.platform.wanderlog.TravelAgencies.domain.model.aggregates.TravelAgencies;
import org.hign.platform.wanderlog.TravelAgencies.domain.model.commands.AddTravelAgencyCommand;
import org.springframework.stereotype.Component;

@Component
public class AddTravelAgencyCommandToAgencyTransformer {

    public TravelAgencies transform(AddTravelAgencyCommand command) {
        TravelAgencies agency = new TravelAgencies();
        agency.setOrganizationName(command.getOrganizationName());
        agency.setRepreFirstName(command.getRepreFirstName());
        agency.setRepreLastName(command.getRepreLastName());
        agency.setContactEmail(command.getContactEmail());
        agency.setPassword(command.getPassword());
        return agency;
    }
}
