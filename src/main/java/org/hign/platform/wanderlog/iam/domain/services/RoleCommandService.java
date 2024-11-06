package org.hign.platform.wanderlog.iam.domain.services;

import org.hign.platform.wanderlog.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
