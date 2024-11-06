package org.hign.platform.wanderlog.iam.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.hign.platform.wanderlog.iam.domain.model.queries.GetAllRolesQuery;
import org.hign.platform.wanderlog.iam.domain.services.RoleQueryService;
import org.hign.platform.wanderlog.iam.interfaces.rest.resources.RoleResource;
import org.hign.platform.wanderlog.iam.interfaces.rest.transform.RoleResourceFromEntityAssembler;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/roles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Roles", description = "Role Management Endpoints")
public class RolesController {
    private final RoleQueryService roleQueryService;

    public RolesController(RoleQueryService roleQueryService) {
        this.roleQueryService = roleQueryService;
    }

    @GetMapping
    public ResponseEntity<List<RoleResource>> getAllRoles() {
        var getAllRolesQuery = new GetAllRolesQuery();
        var roles = roleQueryService.handle(getAllRolesQuery);
        var roleResources = roles.stream().map(RoleResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(roleResources);
    }
}
