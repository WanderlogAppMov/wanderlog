package org.hign.platform.wanderlog.TravelAgencies.interfaces.rest.transform;

import org.hign.platform.wanderlog.TravelAgencies.domain.model.aggregates.TravelAgencies;
import org.hign.platform.wanderlog.TravelAgencies.interfaces.rest.resources.TravelAgencyProfileResource;
import org.hign.platform.wanderlog.iam.interfaces.acl.IamContextFacade;

public class TravelAgencyProfileResourceFromEntityAssembler {
    public static TravelAgencyProfileResource toResourceFromEntity(TravelAgencies travelAgencies, IamContextFacade iamContextFacade) {
        var userId = travelAgencies.getUserId().userId();
        var username = iamContextFacade.fetchUsernameByUserId(userId);
        var password = iamContextFacade.fetchPasswordByUserId(userId);
        return new TravelAgencyProfileResource(
                travelAgencies.getAgencyId(),
                travelAgencies.getTravelAgencyProfile().getOrganizationName(),
                travelAgencies.getTravelAgencyProfile().getRepreFirstName(),
                travelAgencies.getTravelAgencyProfile().getRepreLastName(),
                username,
                password
        );
    }
}
