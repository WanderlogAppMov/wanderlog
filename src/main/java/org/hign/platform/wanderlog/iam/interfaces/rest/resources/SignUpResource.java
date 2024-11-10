package org.hign.platform.wanderlog.iam.interfaces.rest.resources;// SignUpResource


import java.util.List;

public record SignUpResource(String username, String password, List<String> roles) {
}