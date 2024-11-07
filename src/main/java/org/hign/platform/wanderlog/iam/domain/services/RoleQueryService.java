package org.hign.platform.wanderlog.iam.domain.services;

import org.hign.platform.wanderlog.iam.domain.model.entities.Role;
import org.hign.platform.wanderlog.iam.domain.model.queries.GetAllRolesQuery;
import org.hign.platform.wanderlog.iam.domain.model.queries.GetRoleByNameQuery;

import java.util.List;
import java.util.Optional;

public interface RoleQueryService {
    List<Role> handle(GetAllRolesQuery query);
    Optional<Role> handle(GetRoleByNameQuery query);
}
