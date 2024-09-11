package org.hign.platform.wanderlog.TravelPackages.interfaces.rest.transform;

import org.hign.platform.wanderlog.TravelPackages.domain.model.aggregates.TravelPackages;
import org.hign.platform.wanderlog.TravelPackages.domain.model.commands.AddTravelPackageCommand;
import org.springframework.stereotype.Component;

@Component
public class AddTravelPackageCommandToTravelPackageTransformer {

    public TravelPackages transform(AddTravelPackageCommand command) {
        TravelPackages travelPackage = new TravelPackages();
        travelPackage.setDestination(command.getDestination());
        travelPackage.setTransportationDetails(command.getTransportationDetails());
        travelPackage.setAccommodationDetails(command.getAccommodationDetails());
        travelPackage.setActivitiesDetails(command.getActivitiesDetails());
        travelPackage.setPricePerStudent(command.getPricePerStudent());
        return travelPackage;
    }
}
