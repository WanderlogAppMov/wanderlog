package org.hign.platform.wanderlog.iam.interfaces.rest.transform;

import org.hign.platform.wanderlog.iam.domain.model.commands.SignInCommand;
import org.hign.platform.wanderlog.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password());
    }
}

