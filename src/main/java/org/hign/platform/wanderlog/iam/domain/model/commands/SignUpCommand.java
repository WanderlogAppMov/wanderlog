package org.hign.platform.wanderlog.iam.domain.model.commands;


import org.hign.platform.wanderlog.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username, String password, List<Role> roles) {
}