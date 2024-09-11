package org.hign.platform.wanderlog.TravelPackages.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class AddTravelPackageCommand {
    private final String destination;
    private final String transportationDetails;
    private final String accommodationDetails;
    private final String activitiesDetails;
    private final BigDecimal pricePerStudent;
}
