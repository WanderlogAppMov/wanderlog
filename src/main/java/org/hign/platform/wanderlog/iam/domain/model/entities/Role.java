package org.hign.platform.wanderlog.iam.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import org.hign.platform.wanderlog.iam.domain.model.valueobjects.Roles;

import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(length = 20, unique = true, nullable = false)
    private Roles name;

    public Role() {}
    public Role(Roles name) {
        this.name = name;
    }

    public String getStringName() {
        return name.name();
    }

    public static Role getDefaultRole() {
        return new Role(Roles.ROLE_TRAVELER);
    }

    public static Role toRoleFromName(String name) {
        return new Role(Roles.valueOf(name));
    }

    public static List<Role> validateRoleSet(List<Role> roles) {
        if (roles == null || roles.isEmpty()) {
            return List.of(getDefaultRole());
        }
        return roles;
    }
}
