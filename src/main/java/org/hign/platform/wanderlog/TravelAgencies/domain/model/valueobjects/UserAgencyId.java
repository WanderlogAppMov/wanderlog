package org.hign.platform.wanderlog.TravelAgencies.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record UserAgencyId(Integer userId) {
}
