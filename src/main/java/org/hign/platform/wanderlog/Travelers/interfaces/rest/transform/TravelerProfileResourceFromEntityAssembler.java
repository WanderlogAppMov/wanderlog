package org.hign.platform.wanderlog.Travelers.interfaces.rest.transform;

import org.hign.platform.wanderlog.Travelers.domain.model.aggregates.Travelers;
import org.hign.platform.wanderlog.Travelers.interfaces.rest.resources.TravelerProfileResource;
import org.hign.platform.wanderlog.iam.domain.model.entities.Role;
import org.hign.platform.wanderlog.iam.interfaces.acl.IamContextFacade;

import java.util.stream.Collectors;

public class TravelerProfileResourceFromEntityAssembler {
    public static TravelerProfileResource toResourceFromEntity(Travelers traveler, IamContextFacade iamContextFacade) {
        var userId = traveler.getUserId().userId();
        var username = iamContextFacade.fetchUsernameByUserId(userId);
        var password = iamContextFacade.fetchPasswordByUserId(userId);
        return new TravelerProfileResource(
                traveler.getTravelerId(),
                traveler.getTravelerProfile().getFirstName(),
                traveler.getTravelerProfile().getLastName(),
                traveler.getTravelerProfile().getGender(),
                traveler.getTravelerProfile().getBirthdate(),
                username,
                password
        );
    }
}
