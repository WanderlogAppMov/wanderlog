package org.hign.platform.wanderlog.iam.interfaces.rest.transform;

import org.hign.platform.wanderlog.iam.domain.model.aggregates.User;
import org.hign.platform.wanderlog.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
    }
}

