package org.hign.platform.wanderlog.iam.interfaces.rest.resources;

import java.util.List;

public record AuthenticatedUserResource(Integer id, String username, String token, List<String> roles) {

}
