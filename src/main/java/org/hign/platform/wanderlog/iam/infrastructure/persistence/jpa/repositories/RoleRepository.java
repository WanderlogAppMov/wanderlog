package org.hign.platform.wanderlog.iam.infrastructure.persistence.jpa.repositories;

import org.hign.platform.wanderlog.iam.domain.model.entities.Role;
import org.hign.platform.wanderlog.iam.domain.model.valueobjects.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(Roles name);
    boolean existsByName(Roles name);
}
