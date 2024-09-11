package org.hign.platform.wanderlog.PlannedTrips.interfaces.rest.transform;

import org.hign.platform.wanderlog.PlannedTrips.domain.model.aggregates.PlannedTrips;
import org.hign.platform.wanderlog.PlannedTrips.domain.model.commands.AddPlannedTripCommand;
import org.hign.platform.wanderlog.TravelPackages.domain.model.aggregates.TravelPackages;
import org.hign.platform.wanderlog.Travelers.domain.model.aggregates.Travelers;
import org.springframework.stereotype.Component;

@Component
public class AddPlannedTripCommandToPlannedTripTransformer {

    public PlannedTrips transform(AddPlannedTripCommand command, Travelers traveler, TravelPackages travelPackage) {
        PlannedTrips plannedTrip = new PlannedTrips();
        plannedTrip.setTraveler(traveler);
        plannedTrip.setTravelPackage(travelPackage);
        plannedTrip.setNumberOfStudents(command.getNumberOfStudents());
        plannedTrip.setTentativeDate(command.getTentativeDate());
        plannedTrip.setBudget(command.getBudget());
        plannedTrip.setStatus(PlannedTrips.Status.valueOf(command.getStatus()));
        return plannedTrip;
    }
}
