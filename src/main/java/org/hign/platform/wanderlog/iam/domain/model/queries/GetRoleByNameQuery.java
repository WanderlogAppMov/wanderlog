package org.hign.platform.wanderlog.iam.domain.model.queries;

import org.hign.platform.wanderlog.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles roleName) {
}
