package org.hign.platform.wanderlog.Travelers.interfaces.rest.transform;

import org.hign.platform.wanderlog.Travelers.domain.model.commands.CreateTravelerCommand;
import org.hign.platform.wanderlog.Travelers.interfaces.rest.resources.CreateTravelerResource;

public class CreateTravelerCommandFromResourceAssembler {
    public static CreateTravelerCommand toCommandFromResource(CreateTravelerResource resource) {
        return new CreateTravelerCommand(
                resource.firstName(),
                resource.lastName(),
                resource.gender(),
                resource.birthdate(),
                resource.username(),
                resource.password(),
                resource.roles()
        );
    }
}
