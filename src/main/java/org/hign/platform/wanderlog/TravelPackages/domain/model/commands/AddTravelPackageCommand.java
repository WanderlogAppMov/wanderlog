package org.hign.platform.wanderlog.TravelPackages.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class AddTravelPackageCommand {
    private final String destination;
    private final Integer hotelId;
    private final Integer restaurantId;
    private final Integer flightId;
    private final Integer attractionId;
    private final BigDecimal pricePerStudent;
    private final Integer agencyId;
    private final String continent;
}
