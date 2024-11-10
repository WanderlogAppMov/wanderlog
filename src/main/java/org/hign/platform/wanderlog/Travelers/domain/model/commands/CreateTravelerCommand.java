package org.hign.platform.wanderlog.Travelers.domain.model.commands;

import java.util.List;

public record CreateTravelerCommand(
        String firstName,
        String lastName,
        String gender,
        String birthdate,
        String username,
        String password,
        List<String> roles
) {
}
