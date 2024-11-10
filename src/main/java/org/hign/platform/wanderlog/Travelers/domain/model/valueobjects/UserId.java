package org.hign.platform.wanderlog.Travelers.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record UserId(Integer userId) {
}
