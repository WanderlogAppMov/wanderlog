package org.hign.platform.wanderlog.Travelers.interfaces.rest.transform;

import org.hign.platform.wanderlog.Travelers.domain.model.aggregates.Travelers;
import org.hign.platform.wanderlog.Travelers.interfaces.rest.resources.TravelerResource;

public class TravelerResourceFromEntityAssembler {
    public static TravelerResource toResourceFromEntity(Travelers traveler) {
        return new TravelerResource(
                traveler.getTravelerId(),
                traveler.getTravelerProfile().getFirstName(),
                traveler.getTravelerProfile().getLastName(),
                traveler.getTravelerProfile().getGender(),
                traveler.getTravelerProfile().getBirthdate()
        );
    }
}
