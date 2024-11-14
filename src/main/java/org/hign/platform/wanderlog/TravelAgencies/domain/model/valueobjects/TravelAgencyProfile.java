package org.hign.platform.wanderlog.TravelAgencies.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
public class TravelAgencyProfile {
    private String organizationName;
    private String repreFirstName;
    private String repreLastName;

    public TravelAgencyProfile(String organizationName, String repreFirstName, String repreLastName) {
        this.organizationName = organizationName;
        this.repreFirstName = repreFirstName;
        this.repreLastName = repreLastName;
    }
}
