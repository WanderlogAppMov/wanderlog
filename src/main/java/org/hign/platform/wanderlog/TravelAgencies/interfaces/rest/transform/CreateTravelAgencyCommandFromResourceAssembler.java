package org.hign.platform.wanderlog.TravelAgencies.interfaces.rest.transform;

import org.hign.platform.wanderlog.TravelAgencies.domain.model.commands.CreateTravelAgencyCommand;
import org.hign.platform.wanderlog.TravelAgencies.interfaces.rest.resources.CreateTravelAgencyResource;

public class CreateTravelAgencyCommandFromResourceAssembler {
    public static CreateTravelAgencyCommand toCommandFromResource(CreateTravelAgencyResource resource){
        return new CreateTravelAgencyCommand(
                resource.organizationName(),
                resource.repreFirstName(),
                resource.repreLastName(),
                resource.username(),
                resource.password(),
                resource.roles()
        );
    }
}
