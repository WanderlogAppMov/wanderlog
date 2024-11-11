package org.hign.platform.wanderlog.Travelers.domain.services;

import org.hign.platform.wanderlog.Travelers.domain.model.aggregates.Travelers;
import org.hign.platform.wanderlog.Travelers.domain.model.commands.CreateTravelerCommand;
import org.hign.platform.wanderlog.Travelers.domain.model.commands.UpdateTravelerCommand;

import java.util.Optional;

public interface TravelerCommandService {
    Integer handle(CreateTravelerCommand command);

    Optional<Travelers> handle(UpdateTravelerCommand command);
}
