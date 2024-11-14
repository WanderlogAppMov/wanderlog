package org.hign.platform.wanderlog.TravelAgencies.domain.services;

import org.hign.platform.wanderlog.TravelAgencies.domain.model.aggregates.TravelAgencies;
import org.hign.platform.wanderlog.TravelAgencies.domain.model.commands.CreateTravelAgencyCommand;
import org.hign.platform.wanderlog.TravelAgencies.domain.model.commands.UpdateTravelAgencyCommand;

import java.util.Optional;

public interface TravelAgencyCommandService {

    Integer handle(CreateTravelAgencyCommand command);

    Optional<TravelAgencies> handle(UpdateTravelAgencyCommand command);
}
