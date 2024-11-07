package org.hign.platform.wanderlog.iam.interfaces.rest.transform;

import org.hign.platform.wanderlog.iam.domain.model.aggregates.User;
import org.hign.platform.wanderlog.iam.domain.model.entities.Role;
import org.hign.platform.wanderlog.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        var roles = user.getRoles().stream().map(Role::getStringName).toList();
        return new UserResource(user.getId(), user.getUsername(), roles);
    }
}

