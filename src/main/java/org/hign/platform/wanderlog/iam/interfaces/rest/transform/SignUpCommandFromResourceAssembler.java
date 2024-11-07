package org.hign.platform.wanderlog.iam.interfaces.rest.transform;

import org.hign.platform.wanderlog.iam.domain.model.commands.SignUpCommand;
import org.hign.platform.wanderlog.iam.interfaces.rest.resources.SignUpResource;

public class SignUpCommandFromResourceAssembler {

    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        return new SignUpCommand(resource.username(), resource.password(), resource.roles());
    }

}