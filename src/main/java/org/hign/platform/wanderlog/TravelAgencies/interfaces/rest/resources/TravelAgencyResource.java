package org.hign.platform.wanderlog.TravelAgencies.interfaces.rest.resources;

public record TravelAgencyResource(
        Integer agencyId,
        String organizationName,
        String repreFirstName,
        String repreLastName
) {
}
