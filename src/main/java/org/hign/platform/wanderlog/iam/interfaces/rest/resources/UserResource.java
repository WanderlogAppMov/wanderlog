package org.hign.platform.wanderlog.iam.interfaces.rest.resources;

import java.util.List;

public record UserResource(Integer id, String username, List<String> roles) {
}
