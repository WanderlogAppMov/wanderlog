package org.hign.platform.wanderlog.TravelAgencies.interfaces.rest.resources;

import java.util.List;

public record CreateTravelAgencyResource(
        String organizationName,
        String repreFirstName,
        String repreLastName,
        String username,
        String password,
        List<String> roles
) {
}
