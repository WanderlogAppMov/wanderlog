package org.hign.platform.wanderlog.Travelers.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hign.platform.wanderlog.Travelers.domain.model.aggregates.Travelers;

import java.util.Date;

@Getter
@AllArgsConstructor
public class AddTravelersCommand {
    private final String firstName;
    private final String lastName;
    private final Travelers.Gender gender; // Usar Gender de Travelers
    private final String email;
    private final String passwordHash;
    private final Date birthdate;
    private final String cellphone;
    private final String streetAddress;
    private final String city;
    private final String region;
    private final String postalCode;
    private final String country;
}
