package org.hign.platform.wanderlog.PlannedTrips.domain.model.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetPlannedTripQuery {
    private final Integer plannedTripId;
}
