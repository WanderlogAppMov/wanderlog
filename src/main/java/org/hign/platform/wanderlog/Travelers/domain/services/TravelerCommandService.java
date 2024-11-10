package org.hign.platform.wanderlog.Travelers.domain.services;

import org.hign.platform.wanderlog.Travelers.domain.model.commands.CreateTravelerCommand;

public interface TravelerCommandService {
    Integer handle(CreateTravelerCommand command);
}
