package org.hign.platform.wanderlog.TravelAgencies.domain.model.commands;

import java.util.List;

public record CreateTravelAgencyCommand(
        String organizationName,
        String repreFirstName,
        String repreLastName,
        String username,
        String password,
        List<String> roles
) {
}
