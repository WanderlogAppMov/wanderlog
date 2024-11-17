package org.hign.platform.wanderlog.iam.interfaces.rest.transform;


import org.hign.platform.wanderlog.iam.domain.model.aggregates.User;
import org.hign.platform.wanderlog.iam.domain.model.entities.Role;
import org.hign.platform.wanderlog.iam.interfaces.rest.resources.AuthenticatedUserResource;


public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        var roles = user.getRoles().stream().map(Role::getStringName).toList();
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), token, roles);
    }
}
