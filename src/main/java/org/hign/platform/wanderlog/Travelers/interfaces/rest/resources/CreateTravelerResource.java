package org.hign.platform.wanderlog.Travelers.interfaces.rest.resources;

import java.util.List;

public record CreateTravelerResource(
        String firstName,
        String lastName,
        String gender,
        String birthdate,
        String username,
        String password,
        List<String> roles
) {
}
