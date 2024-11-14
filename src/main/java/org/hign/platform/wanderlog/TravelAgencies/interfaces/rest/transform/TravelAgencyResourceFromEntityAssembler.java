package org.hign.platform.wanderlog.TravelAgencies.interfaces.rest.transform;

import org.hign.platform.wanderlog.TravelAgencies.domain.model.aggregates.TravelAgencies;
import org.hign.platform.wanderlog.TravelAgencies.interfaces.rest.resources.TravelAgencyResource;

public class TravelAgencyResourceFromEntityAssembler {
    public static TravelAgencyResource toResourceFromEntity(TravelAgencies travelAgency) {
        return new TravelAgencyResource(
                travelAgency.getAgencyId(),
                travelAgency.getTravelAgencyProfile().getOrganizationName(),
                travelAgency.getTravelAgencyProfile().getRepreFirstName(),
                travelAgency.getTravelAgencyProfile().getRepreLastName()
        );
    }
}
