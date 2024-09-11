package org.hign.platform.wanderlog.TravelPackages.interfaces.rest.resources;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AddTravelPackageResource {
    private String destination;
    private String transportationDetails;
    private String accommodationDetails;
    private String activitiesDetails;
    private BigDecimal pricePerStudent;
}
