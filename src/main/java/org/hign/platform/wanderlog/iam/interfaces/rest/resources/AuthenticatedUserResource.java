package org.hign.platform.wanderlog.iam.interfaces.rest.resources;

public record AuthenticatedUserResource(Integer id, String username, String token) {
}
