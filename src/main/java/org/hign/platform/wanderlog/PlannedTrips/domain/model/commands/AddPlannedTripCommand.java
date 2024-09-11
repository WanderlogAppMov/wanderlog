package org.hign.platform.wanderlog.PlannedTrips.domain.model.commands;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@AllArgsConstructor
public class AddPlannedTripCommand {
    private final Integer travelerId;
    private final Integer travelPackageId;
    private final Integer numberOfStudents;
    private final Date tentativeDate;
    private final BigDecimal budget;
    private final String status;
}
