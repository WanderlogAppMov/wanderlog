package org.hign.platform.wanderlog.TravelAgencies.interfaces.rest.resources;

public record TravelAgencyProfileResource(
        Integer agencyId,
        String organizationName,
        String repreFirstName,
        String repreLastName,
        String username,
        String password
) {
}
