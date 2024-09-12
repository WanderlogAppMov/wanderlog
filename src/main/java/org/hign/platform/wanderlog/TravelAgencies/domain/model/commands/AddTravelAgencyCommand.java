package org.hign.platform.wanderlog.TravelAgencies.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddTravelAgencyCommand {
    private final String organizationName;
    private final String repreFirstName;
    private final String repreLastName;
    private final String contactEmail;
    private final String password;
}