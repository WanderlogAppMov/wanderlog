package org.hign.platform.wanderlog.TravelAgencies.domain.model.commands;

public record UpdateTravelAgencyCommand(
        Integer agencyId,
        String organizationName,
        String repreFirstName,
        String repreLastName,
        String username,
        String password
) {
}
